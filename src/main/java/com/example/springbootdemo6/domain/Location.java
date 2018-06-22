package com.example.springbootdemo6.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * 地点实体类
 */
//@Document // 本类不需要作为文档存入数据库中，所以此注解可以不加
public class Location implements Serializable {
    private String place;
    private Date worktime;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getWorktime() {
        return worktime;
    }

    public void setWorktime(Date worktime) {
        this.worktime = worktime;
    }

    public Location() {
    }

    public Location(String place, Date worktime) {
        this.place = place;
        this.worktime = worktime;
    }

    @Override
    public String toString() {
        return "Location{" +
                "place='" + place + '\'' +
                ", worktime=" + worktime +
                '}';
    }
}
