package com.txm3.feignApi;

import com.txm3.entity.Card;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 接口描述：
 *
 * @version 1.0          
 * @author: pltang
 * @date： 2019年12月03日  14:41
 */
@FeignClient(name = "${feign.demo3name}")
public interface Demo3Feign {
    @RequestMapping(
            value = "/demo3/list",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    List<Card> getCardList2();


    @RequestMapping(
            value = "/demo3/insert",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String insertCard2(@RequestBody  Card card);

    @RequestMapping(
            value = "/demo3/modify/{opt}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String modifyCard2(Card card, @PathVariable("opt") Integer opt);


    @RequestMapping(
            value = "/demo3/find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    Card find(@RequestParam(value = "cardId") String cardId);
}
