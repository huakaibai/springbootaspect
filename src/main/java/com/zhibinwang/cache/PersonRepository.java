package com.zhibinwang.cache;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhibin.wang
 * @create 2020-01-16 9:39
 * @desc
 **/
public interface PersonRepository extends JpaRepository<Person,Long> {
}
