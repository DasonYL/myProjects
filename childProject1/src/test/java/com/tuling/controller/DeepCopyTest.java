package com.tuling.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuling.Domain.Car;
import com.tuling.Domain.User;

import java.io.*;

/**
 * 深拷贝的几种方式
 */
public class DeepCopyTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User("youlin",32, new Car("blue", "benz"));

        User user1 = deepCopyUser(user);
        System.out.println(user1.toString());
        System.out.println("user1与user对象是否是同一个:" + (System.identityHashCode(user) == System.identityHashCode(user1)));
        System.out.println("user1中的car与user中的car是否是同一个:"+(System.identityHashCode(user.getCar()) == System.identityHashCode(user1.getCar())));

        System.out.println("======================================================================");

        User user4 = deepCopyUser(user);
        System.out.println(user4.toString());
        System.out.println("user4与user对象是否是同一个:" + (System.identityHashCode(user) == System.identityHashCode(user4)));
        System.out.println("user4中的car与user中的car是否是同一个:"+(System.identityHashCode(user.getCar()) == System.identityHashCode(user4.getCar())));
    }

    /**
     * 方法一：使用Java自带的流方式实现（推荐）
     * 优点：
     * 1.不破坏类的封装，无需了解被copy对象的内部
     * 2.不需要依赖第三方包
     * 3.代码可复用
     * 缺点：
     * 1.需要实现Serializable接口，会有额外的开销
     */
    public static User deepCopyUser(User user) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(user);
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object o = ois.readObject();
        if(o instanceof User){
            return (User)o;
        }
        return null;
    }

    /**
     * 方法二：使用第三方包Jackson实现
     * 优点：
     * 1.不破坏类的封装，无需了解被copy对象的内部
     * 2.不需要实现接口
     * 3.代码可复用
     * 缺点：
     * 1.需要依赖第三方包
     * 2.内部实现复杂
     */
    public static User copyUser4(User user) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(objectMapper.writeValueAsString(user),User.class);
    }
}
