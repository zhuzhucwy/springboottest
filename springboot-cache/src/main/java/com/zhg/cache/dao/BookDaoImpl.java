package com.zhg.cache.dao;

import com.zhg.cache.model.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class BookDaoImpl implements BookDao {

    @Cacheable("books")
    @Override
    public Book getBookByIsdn(String isdn) throws InterruptedException {
        Thread.sleep(3000);
        return new Book(isdn, "my book");
    }
}
