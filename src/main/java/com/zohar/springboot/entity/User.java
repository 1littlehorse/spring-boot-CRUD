package com.zohar.springboot.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

//1、创建实体 数据表
@Entity // @Entity 声明该类为实体
@Data // 用于简化类，提供类的get、set、equals、hashCode、canEqual、toString方法
public class User{
    @Id // 设置主键
    @Column(nullable = false,unique = true) // nullable=false是这个字段在保存时必需有值,unique=true是指这个字段的值在这张表里不能重复，所有记录值都要唯一
    private long id;

    @Column(nullable = false,unique = false) // @Column建立数据表属性 唯一索引
    @NotEmpty(message = "姓名不能为空") // 提示或验证
    private String name;

    @Column(unique = false)
    private int age;
}
