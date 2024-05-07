package code.task22;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.EntityType;

@Service
public class BackupService {
    private static final Logger log = LoggerFactory.getLogger(BackupService.class);

    @Value("${data.export.directory}")
    private String exportDirectory;

    @Autowired
    private EntityManager em;

    public void deleteLogs() {
        File logsFolder = new File("logs");
        if (logsFolder.exists() && logsFolder.isDirectory()) {
            deleteDirectory(logsFolder);
        }
    }
    
    private void deleteDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    file.delete();
                }
            }
        }
        directory.delete();
    }

    @SuppressWarnings("rawtypes")
    public void exportData() {
        log.info("Exporting data to directory: {}", exportDirectory);

        // Clear the export directory
        File directory = new File(exportDirectory);
        if (!directory.exists()) {
            directory.mkdir();
        }
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                file.delete();
            }
        }

        // Get all entities and export them to a file
        Map<Class, List<Object>> entities = getAllEntities();
        for (Map.Entry<Class, List<Object>> entry : entities.entrySet()) {
            Class entityClass = entry.getKey();
            List<Object> entitiesList = entry.getValue();

            String fileName = entityClass.getSimpleName() + ".txt";
            File entityFile = new File(exportDirectory, fileName);

            try (PrintWriter writer = new PrintWriter(entityFile)) {
                for (Object entity : entitiesList) {
                    writer.println(entity + ",");
                }
            } catch (FileNotFoundException e) {
                log.error("Failed to create file: {}", entityFile.getAbsolutePath(), e);
            }
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private Map<Class, List<Object>> getAllEntities() {
        Map<Class, List<Object>> entities = new HashMap<>();
        for (EntityType entityType : em.getMetamodel().getEntities()) {
            Class entityClass = entityType.getJavaType();
            CriteriaQuery query = em.getCriteriaBuilder().createQuery();
            
            Root root = query.from(entityClass);
            query.select(root);
            List<Object> entityList = em.createQuery(query).getResultList();
            
            entities.put(entityClass, entityList);
        }

        return entities;
    }
}
