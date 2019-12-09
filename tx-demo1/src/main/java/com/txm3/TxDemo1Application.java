/**
 * Company
 * Copyright (C) 2018-2019 All Rights Reserved.
 */
package com.txm3;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 类的描述：
 *
 * @author: pltang
 * @email:
 * @blog:
 * @createDate: 2019年12月03日  9:32
 * @version: v1.0
 * @jdk version used: JDK1.8
 */

/** 开启 Feign 扫描支持 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EnableDistributedTransaction
public class TxDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(TxDemo1Application.class, args);
    }
}
