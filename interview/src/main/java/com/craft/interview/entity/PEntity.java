package com.craft.interview.entity;

import java.util.List;
//import java.util.Set;

import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PEntity {

    @Id
    private long id;
    private String uid; //": "c7204a53-77be-4ba6-b446-8f92921060a0",
    private String password; //  "uDQXExV6pr",
    private String first_name; // "Lorenzo",
    private List<String> event_type; // {

}
