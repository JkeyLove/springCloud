package org.example.service.impl;

import org.example.entity.Book;
import org.example.entity.Borrow;
import org.example.entity.User;
import org.example.entity.UserBorrowDetail;
import org.example.mapper.BorrowMapper;
import org.example.service.BorrowService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService{

    @Resource
    BorrowMapper mapper;

    @Resource
    RestTemplate template;

    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(int uid) {
        List<Borrow> borrow = mapper.getBorrowsByUid(uid);
        //RestTemplate支持多种方式的远程调用
        //这里通过调用getForObject来请求其他服务，并将结果自动进行封装
        //获取User信息
        User user = template.getForObject("http://userservice:8300/user/"+uid, User.class);
        //获取每一本书的详细信息
        List<Book> bookList = borrow
                .stream()
                .map(b -> template.getForObject("http://bookservice:8100/book/"+b.getBid(), Book.class))
                .collect(Collectors.toList());
        return new UserBorrowDetail(user, bookList);
    }
}
