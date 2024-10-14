package com.springpoc.springbootdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.id.UUIDGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@JsonIgnoreProperties({"dept","lastName"}) //either this at class level or individual attribute level you can ignore sending as part of response
@Entity
public class Employee {
    @Id
    @GeneratedValue(generator = UUIDGenerator.UUID_GEN_STRATEGY)
    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
    @JsonIgnore//Dont want this property to send as part of response
    private String dept;
    private List<Assignment> assignments;


}
