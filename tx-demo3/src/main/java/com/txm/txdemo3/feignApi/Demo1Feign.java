package com.txm.txdemo3.feignApi;

import com.txm.txdemo3.entity.Card;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 接口描述：
 *
 * @version 1.0          
 * @author: pltang
 * @date： 2019年12月03日  14:41
 */
@FeignClient(value = "${feign.demo1name}")
public interface Demo1Feign {
    @RequestMapping(
            value = "/demo1/list",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    List<Card> getCardList1();

    @RequestMapping(
            value = "/demo1/insert",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String insertCard1(Card card);

    @RequestMapping(
            value = "/demo1/modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String modifyCard1(Card card);
}
