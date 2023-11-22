package com.example.coupang.domain;

import com.example.coupang.domain.baseTime.BaseTime;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
public class Auth extends BaseTime {
    @Id private Long id;

    @ManyToOne
    @JoinColumn(name = "users.id")
    private Users user;
}
