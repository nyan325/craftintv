package com.craft.interview.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.craft.interview.entity.PEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PService {

    @Autowired
    private ObjectMapper objectMapper;

    @Value("classpath:data/p.json")
    private Resource resourceFile;

    @Autowired
    private ResourceLoader resourceLoader;

    public List<PEntity> loadData() throws IOException {
        Resource resourceFile = resourceLoader.getResource("classpath:data/p.json");
        //List<PEntity> users = objectMapper.readValue(resourceFile.getInputStream(), new TypeReference<List<PEntity>>() {});
        //userRepository.saveAll(users);

        JsonNode jsonNode = objectMapper.readTree(resourceFile.getInputStream());
        List<PEntity> pEntities = new ArrayList<>();

        if (jsonNode.isArray()) {
            for (JsonNode node : jsonNode) {

                PEntity e = new PEntity();
                e.setId(node.get("id").asLong());
                e.setUid(node.get("uid").asText());
                e.setFirst_name(node.get("first_name").asText());
                e.setLast_name(node.get("last_name").asText());
                JsonNode eventTypeNode = node.get("event_type").get("type");
                List<String> eventType = StreamSupport.stream(eventTypeNode.spliterator(), false)
                        .map(JsonNode::asText)
                        .collect(Collectors.toList());
                e.setEvent_type(eventType);

                pEntities.add(e);
            }
        }


        System.out.println(pEntities.size());
        return pEntities;
    }


    public List<PEntity> getAllPEntity() throws IOException {

        List<PEntity> plist =  new ArrayList<>();

        plist = this.loadData();
   
        // List<String> alist =  new ArrayList<>();
        // alist.add("graduation"); //, "bakery", "wedding"};
        // alist.add("bakery"); 

        // PEntity e = new PEntity();
        // e.setId(0);
        // e.setUid("asdrwerwer");
        // e.setFirst_name("nnn");
        // e.setEvent_type(alist);

        // List<PEntity> plist =  new ArrayList<>();
        // plist.add(e);
        // //add as many e's like 
        
        return plist;
    };

}
