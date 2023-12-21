package com.example.shoppingmall.domain.cart;

import com.example.shoppingmall.common.Util;
import com.example.shoppingmall.domain.enums.Option;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.transaction.annotation.Transactional;

@Getter
@Setter
@ToString
public class CartCommand {

    private Option option;
    private Integer quantity;
    private  String productCode;

    @Transactional
    public Cart toEntity() {
        return Cart.builder()
                .uid(Util.getUid().orElseThrow())
                .option(option)
                .quantity(quantity)
                .build();
    }

}
