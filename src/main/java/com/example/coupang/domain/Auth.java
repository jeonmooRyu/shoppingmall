package com.example.coupang.domain;

import com.example.coupang.domain.baseTime.BaseTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Auth extends BaseTime {
    @Id private Long id;
}
