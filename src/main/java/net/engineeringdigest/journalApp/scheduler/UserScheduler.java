package net.engineeringdigest.journalApp.scheduler;

import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.cache.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserScheduler {

    @Autowired
    AppCache appCache;

    @Scheduled(cron = "0 */5 * * * *")
    public void clearCache() {
        log.info("Cron job triggered");
        appCache.init();
    }
}
