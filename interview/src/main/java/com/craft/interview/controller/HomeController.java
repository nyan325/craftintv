package com.craft.interview.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.NoArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@RestController
@ResponseBody
@RequestMapping("/")
@NoArgsConstructor
public class HomeController {

    @GetMapping("craft")
    public String getHomeMethod() {
        return new String("Craft-Hello");
    }
    
}
