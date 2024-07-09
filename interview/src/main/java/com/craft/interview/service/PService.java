package com.craft.interview.service;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.craft.interview.entity.PEntity;

@Service
public class PService {

    public List<PEntity> getAllPEntity() {

        //ArrayList<PEntity> = new ArrayList<>();

        List<String> alist =  new ArrayList<>();
        alist.add("graduation"); //, "bakery", "wedding"};
        alist.add("bakery"); 

        PEntity e = new PEntity();
        e.setId(0);
        e.setUid("asdrwerwer");
        e.setFirst_name("nnn");
        e.setEvent_type(alist);

        List<PEntity> plist =  new ArrayList<>();
        plist.add(e);
        //add as many e's like 
        
        return plist;
    };

}
