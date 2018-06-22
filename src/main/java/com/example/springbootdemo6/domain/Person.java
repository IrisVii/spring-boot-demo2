package com.example.springbootdemo6.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 人物实体类
 */
// 若未加@Document，该bean save到mongo的user collection
// 若添加@Document，则save到注解中指定的collection，如果没有这个collection则会在当前数据库新建
@Document(collection = "person") // 表名该类与mongodb文档的映射关系，
public class Person implements Serializable {
    @Id // 设置为主键
    private String id;
    private String name;
    private Integer age;
    @Field("locs") // @Field注解此属性，则该属性在文档中的名称为locs
    private Set<Location> locations = new LinkedHashSet<Location>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

    public Person() {
    }

    public Person(String id, String name, Integer age, Set<Location> locations) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", locations=" + locations +
                '}';
    }
}
