package com.example.springbootdemo6.service;

import com.example.springbootdemo6.domain.Person;

import java.util.List;

/**
 * Person业务层
 */
public interface PersonService {
    /**
     * 保存一个人物
     */
    Person save(Person person);

    /**
     * 根据名字查询
     */
    Person queryByName(String name);

    /**
     * 根据年龄查询
     */
    List<Person> queryByAge(Integer age);

    /**
     * 查询全部
     */
    List<Person> queryAll();

    /**
     * 查询年龄小于30岁的
     */
    List<Person> findByAgeBefore(Integer age);
}
