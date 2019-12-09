/**
 * Company
 * Copyright (C) 2018-2019 All Rights Reserved.
 */
package com.txm3.service.impl;

import com.txm3.dao.CardDao;
import com.txm3.entity.Card;
import com.txm3.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class CardServiceImpl implements CardService {

    @Autowired
    CardDao cardDao;

    @Override
    public List<Card> getCardList() {
        return cardDao.geCardList();
    }

    @Override
    public void insertCard(Card card) {
        cardDao.insert(card);
    }

    @Override
    public String transferMoney(String card1Id, String card2Id, double money) {
        Card card1 = cardDao.find(card1Id);
        Card card2 = cardDao.find(card2Id);
        if (card1.getBalance() >= money) {
            card1.setBalance(card1.getBalance() - money);
            card2.setBalance(card2.getBalance() + money);
            cardDao.modify(card1);

        } else {
            return "用戶:" + card1.getCardName() + "=的账户：" + card1.getId() + "，余额不足!";
        }
        return "给用戶:" + card2.getCardName() + "=的账户:" + card2.getId() + "，成功转入" + money + "元钱";
    }

    @Override
    public void modify(Card card) {
        cardDao.modify(card);
    }

    @Override
    public Card find(String cardId){
      return   cardDao.find(cardId);
    }

}
