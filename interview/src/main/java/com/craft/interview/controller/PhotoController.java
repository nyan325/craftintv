package com.craft.interview.controller;

import org.springframework.web.bind.annotation.RestController;

import com.craft.interview.service.PService;

import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;

import com.craft.interview.entity.PEntity;

import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

//import com.craft.interview.service.PService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PhotoController {

    @Autowired
    private final PService service;

    @GetMapping("/photographers")
    public List<PEntity> getAllPEntities() {
        //return new ResponseEntity<>();
        //try {
        return service.getAllPEntity();
        // } catch (Exception e) {

        // }
    }
    

}
