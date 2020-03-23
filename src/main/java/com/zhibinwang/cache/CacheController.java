package com.zhibinwang.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhibin.wang
 * @desc
 **/
@RestController
public class CacheController {

    @Autowired
    PersonService personService;

    @RequestMapping("/put")
    public Person put(Person person){
        Person save = personService.save(person);
        return save;
    }
    @RequestMapping("/find/{id}")
    public Person find(@PathVariable(value = "id") Long id){
        Person one = personService.findOne(id);
        return one;
    }

    @RequestMapping("/remove")
    public String remove(Long id){
        personService.remove(id);
        return "成功";
    }
}
