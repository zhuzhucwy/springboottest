package com.zhg.cache.dao;

import com.zhg.cache.model.Book;

public interface BookDao {
    Book getBookByIsdn(String isdn) throws InterruptedException;
}
