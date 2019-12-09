package com.txm.txdemo3.mapper;

import com.txm.txdemo3.entity.Card;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 实现RowMapper接口，返回User对象
 */
public class MyRowMapper implements RowMapper<Card> {

    @Override
    public Card mapRow(ResultSet resultSet, int i) throws SQLException {
//        获取结果集中的数据
        String id = resultSet.getString("id");
        String cardName = resultSet.getString("cardName");
        double balance = resultSet.getDouble("balance");
//        把数据封装成Card对象
        Card card = new Card();
        card.setCardName(cardName);
        card.setBalance(balance);
        card.setId(id);
        return card;
    }
}