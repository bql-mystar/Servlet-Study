package com.xie.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xie.domain.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class JacksonTest {
    // Java对象转换为Json字符串
    @Test
    public void test1() throws JsonProcessingException {
        Person person = new Person();
        person.setName("xrz");
        person.setAge(18);
        person.setGender("男");
        // 创建Jackson核心对象：ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        /**
         * 转换方法
         *      writeValue(参数1, Object obj)
         *              参数1：
         *                  File：将obj对象转换为json字符串，并保存到指定的文件中
         *                  Writer：将obj对象转换为json字符串，并将json数据填充到字符输出流中
         *                  OutputStream：：将obj对象转换为json字符串，并将json数据填充到字符节输出流中
         *      writeValueAsString(Object obj)：将对象转为json字符串
         *
         */
//        mapper.writeValue();
        String s = mapper.writeValueAsString(person);
        System.out.println(s);
    }

    @Test
    public void test2() throws JsonProcessingException {
        Person person = new Person();
        person.setName("xrz");
        person.setAge(18);
        person.setGender("男");
        person.setBirthday(new Date());
        // 创建Jackson核心对象：ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        String s = mapper.writeValueAsString(person);
        System.out.println(s);
    }

    // List转换为json
    @Test
    public void test3() throws JsonProcessingException {
        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            person.setAge(i);
            people.add(person);
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(people);
        System.out.println(json);

    }

    // Map转换为json
    @Test
    public void test4() throws JsonProcessingException {
        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            person.setAge(i);
            people.add(person);
        }


        HashMap<String, ArrayList<Person>> map = new HashMap<>();
        map.put("person", people);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        System.out.println(json);
    }

    // 将json数据转换为对应的对象
    @Test
    public void test5() throws JsonProcessingException {
        String json = "{\"name\":\"xrz\",\"age\":18,\"gender\":\"男\",\"birthday\":null}";
        // 创建Jackson核心对象：ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);

    }
}
