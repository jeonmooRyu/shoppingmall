package com.example.coupang.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private Long id;
    private String uid;
    private String name;
    private String phoneNumber;
    private String userType;

}
