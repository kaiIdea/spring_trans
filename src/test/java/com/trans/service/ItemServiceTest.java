package com.trans.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ItemServiceTest{

    ItemService itemService;

    @Test
    public void testSelectItem() {
        itemService.selectItem();
        System.out.println();
    }
}