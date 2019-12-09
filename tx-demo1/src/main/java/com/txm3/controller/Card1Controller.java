/**
 * Company
 * Copyright (C) 2018-2019 All Rights Reserved.
 */
package com.txm3.controller;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.txm3.entity.Card;
import com.txm3.feignApi.Demo2Feign;
import com.txm3.feignApi.Demo3Feign;
import com.txm3.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类的描述：
 * @author: pltang
 * @email:
 * @blog:
 * @createDate: 2019年12月03日  9:56  
 * @version: v1.0
 * @jdk version used: JDK1.8  
 */
@Controller
public class Card1Controller {

    @Autowired
    CardService cardService;

    @RequestMapping(value = "demo1/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Card> getCardList() {
        return cardService.getCardList();
    }


    @PostMapping(value = "demo1/insert")
    @ResponseBody
    public String insertCard(@RequestBody Card card) {
          cardService.insertCard(card);
        return "添加成功!";
    }

    @PostMapping(value = "demo1/modify")
    @ResponseBody
    public String modifyCard(Card card) {
          cardService.modify(card);
        return "修改成功!";
    }


    @PostMapping(value = "demo1/transferMoney/{opt}")
    @ResponseBody
    @Transactional
    @LcnTransaction
    public String insertCard(@RequestParam("card1Id") String card1Id,
                             @RequestParam("card2Id") String card2Id,
                             @PathVariable("opt") Integer opt,
                             double money) {
          return cardService.transferMoney(card1Id,card2Id,money,opt);
    }

    @PostMapping(value = "demo1/transferMoney3/{opt}")
    @ResponseBody
    @Transactional
    @LcnTransaction
    public String insertCard3(@RequestParam("card1Id") String card1Id,
                             @RequestParam("card2Id") String card2Id,
                             @PathVariable("opt") Integer opt,
                             double money) {
          return cardService.transferMoney3(card1Id,card2Id,money,opt);
    }


    @GetMapping(value = "demo1/addMoney")
    @ResponseBody
    public String addMoney(String cardName,double money){
        return "收到 "+cardName+"转来的"+money+" 元钱";
    }



    @GetMapping(value = "demo1/minusMoney")
    @ResponseBody
    public String minusMoney(String cardName,double money){
        return "转给 "+cardName+ money+" 元钱";
    }


    @Resource
    private Demo2Feign demo2Feign;


    @RequestMapping(
            value = "/demo2/list",
            method = RequestMethod.GET
    )
    @ResponseBody
    List<Card> getCardList2()  {
        return demo2Feign.getCardList2();
    }


    @PostMapping(value = "demo2/insert")
    @ResponseBody
//    @LcnTransaction
    public String insertCard2(Card card) {
        return demo2Feign.insertCard2(card);
    }

    @PostMapping(value = "demo2/modify/{opt}")
    @ResponseBody
//    @LcnTransaction
    public String modifyCard2(Card card,@PathVariable("opt") Integer opt) {
        return  demo2Feign.modifyCard2(card,opt);
    }

    @Resource
    private Demo3Feign demo3Feign;


    @RequestMapping(
            value = "/demo3/list",
            method = RequestMethod.GET
    )
    @ResponseBody
    List<Card> getCardList3()  {
        return demo3Feign.getCardList2();
    }

    @PostMapping(value = "demo3/insert")
    @ResponseBody
//    @LcnTransaction
    public String insertCard3(Card card) {
        return demo3Feign.insertCard2(card);
    }

    @PostMapping(value = "demo3/modify/{opt}")
    @ResponseBody
//    @LcnTransaction
    public String modifyCard3(Card card,@PathVariable("opt") Integer opt) {
        return  demo3Feign.modifyCard2(card,opt);
    }
}
