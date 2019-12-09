package com.txm3.feignApi;

import com.txm3.entity.Card;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 接口描述：
 *
 * @version 1.0          
 * @author: pltang
 * @date： 2019年12月03日  14:41
 */
//@FeignClient(name = "demo2List", url = "http://localhost:20002")
//@FeignClient(name = "DEMO2-CLIENT")
@FeignClient(name = "${feign.demo2name}")
public interface Demo2Feign {
    @RequestMapping(
            value = "/demo2/list",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    List<Card> getCardList2();


    @RequestMapping(
            value = "/demo2/insert",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String insertCard2(Card card);

    @RequestMapping(
            value = "/demo2/modify/{opt}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String modifyCard2(Card card,@PathVariable("opt") Integer opt);


    @RequestMapping(
            value = "/demo2/find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    Card find(@RequestParam(value = "cardId") String cardId);
}
