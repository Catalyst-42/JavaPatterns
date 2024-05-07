package code.task22;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JMXController implements JMXControllerMBean {
    @Autowired
    private BackupService dataExportService;
    
    @Override
    public void createBackups() {
        dataExportService.exportData();
        log.info("Backups created from JMX!");
    }
    
    @Override
    public void clearLogs() {
        dataExportService.deleteLogs();
        log.info("Logs cleared from JMX!");
    }
}
