package com.example.first.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.first.entity.People;

@RestController
@RequestMapping("/jpa")
public class JPAController {

    @Autowired
    private JPADalInterface jPADalInterface;

    @RequestMapping("save")
    public People savePeople(@RequestParam("name") String name, @RequestParam("height") Integer height,
            @RequestParam("weight") Integer weight) {
        People people = new People();
        people.setName(name);
        people.setHeight(height);
        people.setWeight(weight);
        return jPADalInterface.save(people);
    }

    @RequestMapping("list")
    public List<People> findList() {
        return jPADalInterface.findAll();
    }

    @RequestMapping("findEntity/{id}")
    public People findEntity(@PathVariable("id") Integer id) {
        return jPADalInterface.findOne(id);
    }

    @RequestMapping("update1/{id}")
    public People updateAll(@PathVariable("id") Integer id, String name, Integer weight) {
        People people = new People();
        people.setId(id);
        people.setName(name);
        people.setWeight(weight);
        return jPADalInterface.save(people);
    }

    @RequestMapping("update2/{id}")
    public String update(@PathVariable("id") Integer id, String name, Integer weight) {
        return jPADalInterface.updateOne(name, weight, id) + "";
    }

    @RequestMapping("select")
    public List<People> update(String name, Integer height) {
        return jPADalInterface.findPeopleByNameAndHeight(name, height);
    }

}
