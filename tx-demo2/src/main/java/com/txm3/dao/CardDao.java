package com.txm3.dao;

import com.txm3.entity.Card;
import com.txm3.mapper.MyRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class CardDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Card> geCardList() {

        List<Card> list = jdbcTemplate.query("select * from card", new Object[]{}, new BeanPropertyRowMapper(Card.class));
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }

    }


    public void modify(Card card) {
        String updateSql = "update card set balance=" + card.getBalance() + ",tradingTime=NOW() where id='" + card.getId() + "'";
        jdbcTemplate.execute(updateSql);
    }


    public Card find(String id) {
        String sql = "select * from card where id=?";
        return jdbcTemplate.queryForObject(sql, new MyRowMapper(), id);
    }


    public void insert(Card card) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String sql = "'" + uuid + "','" + card.getCardName() + "'," + card.getBalance() + "," + card.getTradingTime();
        jdbcTemplate.execute("insert into card  (id,cardName,balance,tradingTime) values(" + sql + ")");
    }
}
