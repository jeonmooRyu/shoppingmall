package com.example.coupang.domain;

import com.example.coupang.domain.baseTime.BaseTime;
import com.example.coupang.domain.enums.ProductType;
import com.example.coupang.domain.enums.ServiceType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
public class Product extends BaseTime {

    @Id private Long id;
    @Setter private String productCode;
    @Setter private ProductType productType;
    @Setter private ServiceType serviceType;
    @Setter private BigDecimal price;
    @Setter private Boolean isDelete;
    @Setter private String seller;

}
