/**
 * Company
 * Copyright (C) 2018-2019 All Rights Reserved.
 */
package com.txm3.entity;

import java.util.UUID;

/**
 * 类的描述：
 *
 * @author: pltang
 * @email:
 * @blog:
 * @createDate: 2019年12月03日  11:29
 * @version: v1.0
 * @jdk version used: JDK1.8
 */
public class Card {
    private String id;
    private double balance;//余额
    private String cardName;//账户名称
    private String tradingTime;//交易時間

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCardName() {
        return this.cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getTradingTime() {
        return this.tradingTime;
    }

    public void setTradingTime(String tradingTime) {
        this.tradingTime = tradingTime;
    }

    public Card(String cardName, double money) {
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.cardName = cardName;
        this.balance = money;
    }

    public Card() {
    }
}
