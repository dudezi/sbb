package com.std.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PersonController {
    List<Person> people;

    PersonController() {
        people = new ArrayList<>();
    }


    @GetMapping("/person/add")
    @ResponseBody
    public String addPerson(@RequestParam ("name") String name, @RequestParam("age") int age) {
        Person p = new Person(name, age);

        people.add(p);

        return String.format("%d번 사람이 추가되었습니다.", p.getId());
    }

    @GetMapping("/person/people")
    @ResponseBody
    public List<Person> getPeople() {
        System.out.println(people);
        return people;
    }

    @GetMapping("/person/remove")
    @ResponseBody
    public String removePerson(@RequestParam ("id") int id) {
        Person p = null;
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getId() == id) {
                p = people.get(i);
            }
        }

        if (p == null) {
            return String.format("%d번 사람이 존재하지 않습니다.", id);
        }
        people.remove(p);
        return String.format("%d번 사람이 삭제되었습니다.", id);
    }
}