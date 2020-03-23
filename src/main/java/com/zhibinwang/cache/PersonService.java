package com.zhibinwang.cache;

/**
 * @author zhibin.wang
 * @create 2020-01-16 9:40
 * @desc
 **/
public interface PersonService {

    Person save(Person person);

    void remove(Long id);

    Person findOne(Long id);
}
