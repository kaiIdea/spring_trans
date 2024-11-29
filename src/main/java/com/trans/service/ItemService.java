package com.trans.service;


import com.trans.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
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
            transactionManager.commit(transaction);
        } catch (Exception e) {
            e.printStackTrace();
            transactionManager.rollback(transaction);
        }
    }


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ItemService itemService = (ItemService) applicationContext.getBean("itemService");
        itemService.selectItem();

        itemService.updateItem();
        System.out.println();
    }
}
