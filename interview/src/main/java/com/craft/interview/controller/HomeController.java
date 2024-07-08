package com.craft.interview.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.NoArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> getHomeMethod() {
        try {
            //return ResponseEntity.status(HttpStatus.OK).body(new String("Craft-Hello")).build();            //new String("Craft-Hello");
            return new ResponseEntity<>("Craft-Hello", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
