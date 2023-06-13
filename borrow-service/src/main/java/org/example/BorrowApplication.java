package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableFeignClients//启用OpenFeign实现负载均衡
public class BorrowApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(BorrowApplication.class,args);
    }
}
