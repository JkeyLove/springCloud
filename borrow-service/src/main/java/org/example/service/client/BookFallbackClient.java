package org.example.service.client;

import org.example.entity.Book;
import org.springframework.stereotype.Component;

@Component   //注意，需要将其注册为Bean，Feign才能自动注入
public class BookFallbackClient implements BookClient{

    @Override
    public Book findBookById(int bid) {
        return new Book();
    }
}
