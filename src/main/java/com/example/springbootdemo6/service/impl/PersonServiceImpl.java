package com.example.springbootdemo6.service.impl;

import com.example.springbootdemo6.dao.PersonRepository;
import com.example.springbootdemo6.domain.Person;
import com.example.springbootdemo6.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Person业务层实现类
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    /**
     * 保存一个人物
     * @param person
     */
    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    /**
     * 根据名字查询
     * @param name
     * @return
     */
    @Override
    public Person queryByName(String name) {
        return personRepository.findByName(name);
    }

    /**
     * 根据年龄查询
     * @param age
     * @return
     */
    @Override
    public List<Person> queryByAge(Integer age) {
        return personRepository.withQueryFindByAge(age);
    }

    /**
     * 查询全部
     * @return
     */
    @Override
    public List<Person> queryAll() {
        return personRepository.findAll();
    }

    /**
     * 查询年龄小于30岁的
     * @param age
     * @return
     */
    @Override
    public List<Person> findByAgeBefore(Integer age) {
        return personRepository.findByAgeBefore(age);
    }
}
