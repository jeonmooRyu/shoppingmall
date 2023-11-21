package com.example.coupang.domain;

import com.example.coupang.domain.baseTime.BaseTime;
import com.example.coupang.domain.enums.CardCompany;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
public class Promotion extends BaseTime {

    @Id private Long id;
    @Setter private String promotionCode;
    @Setter private CardCompany cardCompany;
    @Setter private BigDecimal discountRate;
    @Setter private LocalDateTime promotionStartDateTime;
    @Setter private LocalDateTime promotionEndDateTime;
}
