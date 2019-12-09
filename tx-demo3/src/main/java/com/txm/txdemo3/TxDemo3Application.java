package com.txm.txdemo3;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
//@EnableDistributedTransaction
public class TxDemo3Application {

    public static void main(String[] args) {
        SpringApplication.run(TxDemo3Application.class, args);
    }

}
