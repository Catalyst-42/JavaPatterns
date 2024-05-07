package code.task22;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Scheduler {
    @Autowired
    private BackupService dataExportService;

    private int seconds;

    @Scheduled(cron = "0 0/30 * * * *")
    public void scheduleExportData() {
        dataExportService.exportData();
        dataExportService.deleteLogs();
    }

    @Scheduled(cron = "*/15 * * * * *")
    public void cronTest() {
        seconds += 15;
        log.info("Cron is stil alive after " + seconds + "s!");
    }
}
