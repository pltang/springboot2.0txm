/**
 * Company
 * Copyright (C) 2018-2019 All Rights Reserved.
 */
package com.txm3.service;

import com.txm3.entity.Card;

import java.util.List;

/**
 * 类的描述：
 *
 * @author: pltang
 * @email:
 * @blog:
 * @createDate: 2019年12月03日  11:37
 * @version: v1.0
 * @jdk version used: JDK1.8
 */
public interface CardService {
    List<Card> getCardList();

    void insertCard(Card card);

    public String transferMoney(String card1Id, String card2Id, double money);

    public void modify(Card card);

    public Card find(String cardId);
}
