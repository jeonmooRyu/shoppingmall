package com.example.coupang.domain.baseTime;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
public class BaseTime {

    @CreatedDate
    private String createdAt;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private String modifiedAt;
    @LastModifiedBy
    private String modifiedBy;
}
