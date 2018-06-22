package com.example.springbootdemo6.dao;

import com.example.springbootdemo6.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Person类的mongoDB数据访问接口
 *  继承spring提供的MongoRepository，里面已经封装了基本的crud操作，无需自己实现
 */
public interface PersonRepository extends MongoRepository<Person,String>{
    /**
     * 根据名字查询
     *  支持通过实体类的属性名查询，使用findByXxx的格式
     */
    Person findByName(String name);

    /**
     * 根据年龄查询
     *  支持通过@Query注解查询
     */
    @Query("{'age' : ?0}")  // 注解中的?0相当于占位符，表示为方法参数列表里的第一个参数
    List<Person> withQueryFindByAge(Integer age);

    /**
     * 查询年龄小于30岁的
     */
    List<Person> findByAgeBefore(Integer age);

}
