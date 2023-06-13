package org.example.service.client;

import org.example.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("userservice")   //声明为userservice服务的HTTP请求客户端(服务名称)
public interface UserClient {
    //路径保证和其他微服务提供的一致即可
    @RequestMapping("/user/{uid}")
    public User findUserById(@PathVariable("uid") int uid);  //参数和返回值也保持一致
}
