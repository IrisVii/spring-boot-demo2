package com.example.springbootdemo6.controller;

import com.example.springbootdemo6.domain.Location;
import com.example.springbootdemo6.domain.Person;
import com.example.springbootdemo6.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Person控制器
 */
@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    /**
     * 保存一个人物
     * @param person
     * @return
     */
    @RequestMapping("/save")
    public Person savePerson(Person person){
        // 生成主键id
        String id = UUID.randomUUID().toString().replace("-", "");
        person.setId(id);
        // 创建地点集合并封装
        Set<Location> locations = new HashSet<>();
        locations.add(new Location("广州",new Date()));
        locations.add(new Location("深圳",new Date()));
        locations.add(new Location("上海",new Date()));
        locations.add(new Location("北京",new Date()));
        person.setLocations(locations);
        return personService.save(person);
    }

    /**
     * 根据名字查询
     * @param name
     * @return
     */
    @RequestMapping("/q1")
    public Person queryByName(String name){
        return personService.queryByName(name);
    }

    /**
     * 根据年龄查询
     * @param age
     * @return
     */
    @RequestMapping("/q2")
    public List<Person> queryByAge(Integer age){
        return personService.queryByAge(age);
    }

    /**
     * 查询全部
     * @return
     */
    @RequestMapping("/all")
    public List<Person> queryAll(){
        return personService.queryAll();
    }

    /**
     * 查询年龄小于30岁的
     * @return
     */
    @RequestMapping("/q3")
    public List<Person> queryByAgeBefore(Integer age){
        return personService.findByAgeBefore(age);
    }

}
