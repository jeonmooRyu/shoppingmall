package com.example.shoppingmall.domain.orders;

import com.example.shoppingmall.common.TokenGenerator;
import com.example.shoppingmall.domain.baseEntity.BaseEntity;
import com.example.shoppingmall.domain.enums.OrderStatus;
import com.example.shoppingmall.domain.enums.PaymentType;
import com.example.shoppingmall.domain.payment.Payment;
import com.example.shoppingmall.domain.users.Users;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Orders extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Setter
    private String uid; // 구매자 uid
    @Setter
    private String orderToken;
    @Setter
    private Boolean isPay;
    @Setter
    private String receiverName;
    @Setter
    private String receiverTel;
    @Setter
    private String receiverEmail;
    @Setter
    private String receiverAddr;
    @Setter
    private String receiverAddrDetail;
    @Setter
    private String deliveryMsg;
    @Setter
    private BigDecimal totalPrice;      // 상품가격 + 배송비
    @Setter
    private Integer totalQuantity;
    @Setter
    private BigDecimal deliveryFee;
    @Setter
    private BigDecimal promotionDiscount;
    @Setter
    @Enumerated(value = EnumType.STRING)
    private PaymentType paymentType;
    @Setter
    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "user.id")
    private Users user;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrdersDetail> ordersDetails;

    @Setter
    @OneToOne(mappedBy = "orders", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
    private Payment payment;

    @Builder
    public Orders(String uid, String receiverName, String receiverTel,
                  String receiverAddr, String receiverAddrDetail, String deliveryMsg,
                  BigDecimal totalPrice, Integer totalQuantity, BigDecimal deliveryFee, BigDecimal promotionDiscount,
                  PaymentType paymentType, List<OrdersDetail> ordersDetails) {
        this.uid = uid;
        this.isPay = false;
        this.orderToken = TokenGenerator.generateOrderToken();
        this.receiverName = receiverName;
        this.receiverTel = receiverTel;
        this.receiverAddr = receiverAddr;
        this.receiverAddrDetail = receiverAddrDetail;
        this.deliveryMsg = deliveryMsg;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.deliveryFee = deliveryFee;
        this.promotionDiscount = promotionDiscount;
        this.paymentType = paymentType;
        this.orderStatus = OrderStatus.ORDER_REGISTRATION;
        this.ordersDetails = ordersDetails;
    }

    public void setOrdersDetails(List<OrdersDetail> ordersDetails) {
        this.ordersDetails = ordersDetails;
        ordersDetails.forEach(ordersDetail -> {
            ordersDetail.setOrders(this);
        });
    }

    public Orders checkout(String receiverName, String receiverTel, String receiverAddr, String receiverAddrDetail, String deliveryMsg) {
        this.isPay = true;
        this.receiverName = receiverName;
        this.receiverTel = receiverTel;
        this.receiverAddr = receiverAddr;
        this.receiverAddrDetail = receiverAddrDetail;
        this.deliveryMsg = deliveryMsg;
        return this;
    }
}
