package com.example.coupang.domain;

import com.example.coupang.domain.baseTime.BaseTime;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Auth extends BaseTime {
    @Id private Long id;
}
