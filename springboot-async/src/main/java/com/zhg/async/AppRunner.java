package com.zhg.async;

import com.zhg.async.entity.User;
import com.zhg.async.service.GitHubLookUpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AppRunner implements CommandLineRunner {

    private static Logger logger  = LoggerFactory.getLogger(AppRunner.class);

    private GitHubLookUpService gitHubLookUpService;

    public AppRunner(GitHubLookUpService gitHubLookUpService) {
        this.gitHubLookUpService = gitHubLookUpService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Start the clock
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        Future<User> page1 = gitHubLookUpService.findUser("PivotalSoftware");
        Future<User> page2 = gitHubLookUpService.findUser("CloudFoundry");
        Future<User> page3 = gitHubLookUpService.findUser("Spring-Projects");

        // Wait until they are all done
        while (!(page1.isDone() && page2.isDone() && page3.isDone())) {
            Thread.sleep(10); //10-millisecond pause between each check
        }

        // Print results, including elapsed time
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        logger.info("--> " + page1.get());
        logger.info("--> " + page2.get());
        logger.info("--> " + page3.get());
    }
}
