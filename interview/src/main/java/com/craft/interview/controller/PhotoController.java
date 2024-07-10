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

    // @Autowired
    // private final JsonProperties jp;

    @GetMapping("/photographers")
    public List<PEntity> getAllPEntities() {
        //return new ResponseEntity<>();
        //try {
        //System.out.println(jp.get(0));
        
        // } catch (Exception e) {

        // }

        //System.out.println(jp.plist.get(0).getUid());
        // try {
        //     System.out.println(jp.plist.size());
        //     System.out.println(jp.plist.get(0).getUid());
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        try {
            return service.getAllPEntity();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    

}
