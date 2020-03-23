package com.zhibinwang.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author zhibin.wang
 * @desc
 **/
@Service
public class PersonServiceImpl implements  PersonService {


    @Autowired
    PersonRepository personRepository;

    @Override
    @CachePut(value = "people",key = "#person.id")
    public Person save(Person person) {
        Person p = personRepository.save(person);
        System.out.println("为id key为"+person.getId()+"数据做了缓存");

        return p;
    }

    @Override
    @CacheEvict(value = "people")
    public void remove(Long id) {
        System.out.println("为id key为"+id+"数据删除缓存");
        personRepository.deleteById(id);

    }

    @Override
    @Cacheable(value = "people",key = "#id")
    public Person findOne(Long id) {
        Optional<Person> byId = personRepository.findById(id);
        return byId.get();
    }
}
