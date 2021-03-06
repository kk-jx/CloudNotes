package com.mjl.mybatisTest;

import com.mjl.dao.UserDaoI;
import com.mjl.model.po.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Alvin on 15/10/28.
 */
public class UserDaoTest {
    private static ApplicationContext ac;
    private static UserDaoI userDaoI;

    static{
        ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        userDaoI = (UserDaoI) ac.getBean("UserDaoI");
    }


    @Test
    public void insertTest(){
        User testuser = new User();
        testuser.setUserName("test30");
        testuser.setUserPassWord("1234");
        testuser.setUserEmail("q23we@qsdfdse.com");
        testuser.setUserPhone("13043342678");
        testuser.setUserCreateTime(new Timestamp(new Date().getTime()));
        testuser.setUserLastLoginTime(new Timestamp(new Date().getTime()));
        testuser.setUserLastIp("192.168.192.192");
        userDaoI.addUser(testuser);
    }

    @Test
    public void selectUserTest(){
        User user1 = userDaoI.findUserByUserName("test1");
        User user2 = userDaoI.findUserByUserName("test2");
        System.out.println(user1.toString());
        System.out.println(user2.toString());
    }

    @Test
    public void selectUserAndNoteTest(){
        User user = userDaoI.findUserAndNotesByUserName("test1");
        System.out.println(user);
    }


    @Test
    public void delectTest(){
        userDaoI.deleteUserByUserName("test4");
    }

    @Test
    public void updateTest(){
        User testuser = new User();
        testuser.setUserName("test1");
        testuser.setUserPhone("13212345678");
        userDaoI.updateUserByUserName(testuser);
    }
}
