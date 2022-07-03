package com.tuling.common.annotation;


import com.tuling.common.constant.SexEnum;


public @interface MyAnno {
    int value();
    int[] intArr();
    String str() default "";
    String[] s();
    SexEnum sexEnum();
    MyAnno1 annotation1();


}
