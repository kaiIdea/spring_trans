package com.trans.service;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainService {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ItemService itemService = (ItemService) applicationContext.getBean("itemService");
        //itemService.selectItem();

        //itemService.updateItem1();
        itemService.update222();
        System.out.println();
    }
}
