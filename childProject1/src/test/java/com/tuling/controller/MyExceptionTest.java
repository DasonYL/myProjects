package com.tuling.controller;

import com.tuling.Domain.User;
import com.tuling.common.exception.ApiException;

import java.util.HashSet;

public class MyExceptionTest {
    public static void main(String[] args) {

        //测试字符串
//        testString();

        //测试java到底是值传递，还是引用传递
//        testJavaValueTransferOrAddressTransfer();  //是值传递
        //测试java到底是值传递，还是引用传递
//        testAddressTransferOrJavaValueTransfer();  //是引用传递
        //测试java到底是值传递，还是引用传递
//        testJavaValueTransferOrAddressTransfer1(); //是值传递
        //真正正确的例子：
//        realTest();
//        String s=new String("aaa");
        //另一个案例
//        String s= "aaa";
//        String ns= appendStr(s);
//        System.out.println("String aaa >>> "+s.toString());

        try {
//            throw new RuntimeException("初始化大小不能小于0:" + 1);
            throw new ApiException("这是一个自定义apiException");
        } catch (Exception e) {
            System.out.println("捕获了手动抛出的异常");
            e.printStackTrace();
        }


    }


    public static String appendStr(String s){
        s+="bbb";
        return s;
    }

    public static void testString(){
        String str = "abcd";
        String str1 = new String("abcd");
        System.out.println("str==str1? :"+ (str == str1)); //比较引用地址 --> 不等
        System.out.println("str.equals(str1)? :"+ str.equals(str1)); //比较值--> 相等

        String str2 = "ab";  String str3="cd";
        String str4 = str2 + str3; //底层执行的是：new StringBuilder().append(str2).append(str3).toString();
        System.out.println("str==str4? :"+ (str == str4));

        String s = "cd"; //s是个变量
        String s1 = "ab"+s;
        System.out.println("s1="+s1 + "; str==s1? :"+ (str == s1));
        System.out.println("str4==s1? :"+ (str4 == s1));

        final String s2 = "cd"; //final修饰，s2实际被看作一个常量，而不会像上面的s一样被当作一个变量
        String s3 = "ab"+s2;
        System.out.println("str==s3? :"+ (str == s3));
    }


    /**
     * 第一种情况
     */
    public static void testJavaValueTransferOrAddressTransfer() {
        int i = 10;
        pass(i);
        System.out.println("print in main() , i is " + i);
    }
    public static void pass(int j) {
        j = 20;
        System.out.println("print in pass() , j is " + j);
    }
    /**
     * 第二种情况
     */
    public static void testAddressTransferOrJavaValueTransfer(){
        User hollis = new User("jack", 28);
        pass1(hollis);
    }
    public static void pass1(User user) {
        user.setName("hollischuang");
        System.out.println("print in pass1() , user is " + user);
    }

    /**
     * 第三种情况
     */
    public static void testJavaValueTransferOrAddressTransfer1() {
        String name = "Hollis";
        pass2(name);
        System.out.println("print in main() , name is " + name);
    }
    public static void pass2(String name) {
        name = "hollischuang";
        System.out.println("print in pass2() , name is " + name);
    }

    /**
     * 真正的例子
     */
    public static void realTest(){
        User hollis = new User("Tom", 30);
        pass3(hollis);
        System.out.println("print in main() , user is "+hollis);
    }
    public static void pass3(User user) {
        user = new User();
        user.setName("hollischuang");
        user.setAge(40);
        System.out.println("print in pass3() , user is " + user);
    }



}
