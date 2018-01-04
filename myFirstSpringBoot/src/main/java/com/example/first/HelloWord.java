package com.example.first;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWord {
    //
    // @Value("${name}")
    // private String name;
    //
    // @Value("${people}")
    // private String people;

    // @Autowired
    // private ApplicationPropertiesValue applicationProperities;

    @RequestMapping("/first")
    public String one() {
        return "你好啊！！";
    }

}
