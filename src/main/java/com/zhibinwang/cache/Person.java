package com.zhibinwang.cache;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zhibin.wang
 * @desc
 **/
@Entity
@Table(name = "person")
@Data
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;


    private String address;


}
