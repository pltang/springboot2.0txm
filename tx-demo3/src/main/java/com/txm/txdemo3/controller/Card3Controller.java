/**
 * Company
 * Copyright (C) 2018-2019 All Rights Reserved.
 */
package com.txm.txdemo3.controller;


import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.txm.txdemo3.entity.Card;
import com.txm.txdemo3.feignApi.Demo1Feign;
import com.txm.txdemo3.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类的描述：
 *
 * @author: pltang
 * @email:
 * @blog:
 * @createDate: 2019年12月03日  11:20
 * @version: v1.0
 * @jdk version used: JDK1.8
 */
@RestController
public class Card3Controller {

    @Autowired
    CardService cardService;

    @Autowired
    Demo1Feign demo1Feign;


    @GetMapping(value = "demo3/addMoney")
    @ResponseBody
    public String addMoney(String cardName, double money) {
        return "收到 " + cardName + "转来的" + money + " 元钱";
    }


    @GetMapping(value = "demo3/minusMoney")
    @ResponseBody
    public String minusMoney(String cardName, double money) {
        return "转给 " + cardName + money + " 元钱";
    }

    @RequestMapping(value = "demo3/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Card> getCardList() {
        return cardService.getCardList();
    }


    @PostMapping(value = "demo3/insert")
    @ResponseBody
    public String insertCard(@RequestBody Card card) {
        cardService.insertCard(card);
        return "添加成功!";
    }

    @PostMapping(value = "demo3/find")
    @ResponseBody
    public Card findCard(@RequestParam(value = "cardId") String  cardId) {
        return cardService.find(cardId);
    }


    @PostMapping(value = "demo3/modify/{opt}")
    @ResponseBody
//    @Transactional
//    @LcnTransaction
    public String modifyCard(@RequestBody Card card,@PathVariable("opt") Integer opt) {
        cardService.modify(card);
        if(opt==2)
            throw new RuntimeException("转账失败");
        return "修改成功!";
    }


    @RequestMapping(
            value = "/demo1/list",
            method = RequestMethod.GET
    )
    List<Card> getCardList1() {
        return cardService.getCardList1();
    }


    @PostMapping(value = "demo1/insert")
    @ResponseBody
    @Transactional
    public String insertCard1(Card card) {
        return demo1Feign.insertCard1(card);
    }


    @PostMapping(value = "demo1/modify")
    @ResponseBody
    @Transactional
    public String modifyCard1(Card card) {
        return demo1Feign.modifyCard1(card);
    }
}
