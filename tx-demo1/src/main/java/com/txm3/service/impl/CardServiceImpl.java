/**
 * Company
 * Copyright (C) 2018-2019 All Rights Reserved.
 */
package com.txm3.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.txm3.dao.CardDao;
import com.txm3.entity.Card;
import com.txm3.feignApi.Demo2Feign;
import com.txm3.feignApi.Demo3Feign;
import com.txm3.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类的描述：
 *
 * @author: pltang
 * @email:
 * @blog:
 * @createDate: 2019年12月03日  11:36
 * @version: v1.0
 * @jdk version used: JDK1.8
 */
@Service
//@Transactional
public class CardServiceImpl implements CardService {

    @Autowired
    CardDao cardDao;

    @Autowired

    @Resource
    Demo2Feign demo2Feign;

    @Resource
    Demo3Feign demo3Feign;


    @Override
    public List<Card> getCardList() {
        return cardDao.geCardList();
    }

    @Override
    public void insertCard(Card card) {
        cardDao.insert(card);
    }

    @Override
    public void modify(Card card) {
        cardDao.modify(card);
    }


    @Override
    @Transactional
//    @LcnTransaction
    public String transferMoney(String card1Id, String card2Id, double money,Integer opt) {
        Card card1 = cardDao.find(card1Id);
        Card card2 = demo2Feign.find(card2Id);
        if (card1.getBalance() >= money) {
            card1.setBalance(card1.getBalance() - money);
            card2.setBalance(card2.getBalance() + money);
            cardDao.modify(card1);
            demo2Feign.modifyCard2(card2,opt);
        } else {
            return "用戶:" + card1.getCardName() + "=的账户：" + card1.getId() + "，余额不足!";
        }
        if(opt==1)
            throw new RuntimeException("账号出错，回滚转账记录");
        return "给用戶:" + card2.getCardName() + "=的账户:" + card2.getId() + "，成功转入" + money + "元钱";
    }


    @Override
    @Transactional
//    @LcnTransaction
    public String transferMoney3(String card1Id, String card2Id, double money,Integer opt) {
        Card card1 = cardDao.find(card1Id);
        Card card3 = demo3Feign.find(card2Id);
        if (card1.getBalance() >= money) {
            card1.setBalance(card1.getBalance() - money);
            card3.setBalance(card3.getBalance() + money);
            cardDao.modify(card1);
            demo3Feign.modifyCard2(card3,opt);
        } else {
            return "用戶:" + card1.getCardName() + "=的账户：" + card1.getId() + "，余额不足!";
        }
        if(opt==1)
            throw new RuntimeException("账号出错，回滚转账记录");
        return "给用戶:" + card3.getCardName() + "=的账户:" + card3.getId() + "，成功转入" + money + "元钱";
    }

}
