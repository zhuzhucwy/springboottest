package com.zhg.cache;

import com.zhg.cache.dao.BookDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(AppRunner.class);
    private BookDao bookDao;

    public AppRunner(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info(".... Fetching books");
        logger.info("isbn-1234 -->" +bookDao.getBookByIsdn("isbn-1234"));
        logger.info("isbn-4567 -->" + bookDao.getBookByIsdn("isbn-4567"));
        logger.info("isbn-1234 -->" + bookDao.getBookByIsdn("isbn-1234"));
        logger.info("isbn-4567 -->" + bookDao.getBookByIsdn("isbn-4567"));
        logger.info("isbn-1234 -->" + bookDao.getBookByIsdn("isbn-1234"));
        logger.info("isbn-1234 -->" + bookDao.getBookByIsdn("isbn-1234"));
    }
}
