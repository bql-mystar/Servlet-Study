package com.xie.test;

import com.xie.domain.Person;
import org.junit.Test;

public class JacksonTest {
    // Java对象转换为Json字符串
    @Test
    public void test1(){
        Person person = new Person();
        person.setName("xrz");
        person.setAge(18);
        person.setGender("男");
        // 创建Jackson核心对象：ObjectMapper
        
    }
}
