package com.trans.service;


import com.trans.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;


@Component
public class ItemService {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    PlatformTransactionManager transactionManager;

    public void selectItem(){
        String sql = "select * from item where id = ?";
        Item item = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Item>(Item.class), 317578);
        System.out.println(item);
        System.out.println();
    }

    public void updateItem(){
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus transaction = transactionManager.getTransaction(definition);
        String sql = "update user set balance = ? where id = ?";
        try {
            int update = jdbcTemplate.update(sql, 200, 1);
            int i = 1/0;
            transactionManager.commit(transaction);
        } catch (Exception e) {
            e.printStackTrace();
            transactionManager.rollback(transaction);
        }
    }


    @Transactional
    public void updateItem1(){
        String sql = "update user set balance = ? where id = ?";
        int update = jdbcTemplate.update(sql, 123, 1);
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
