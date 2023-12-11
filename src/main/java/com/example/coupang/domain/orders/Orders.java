package com.example.coupang.domain.orders;

import com.example.coupang.common.TokenGenerator;
import com.example.coupang.domain.baseEntity.BaseEntity;
import com.example.coupang.domain.enums.OrderStatus;
import com.example.coupang.domain.enums.PaymentType;
import com.example.coupang.domain.payment.Payment;
import com.example.coupang.domain.users.Users;
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
    private BigDecimal price;       // 상품가격
    @Setter
    private BigDecimal deliveryFee;
    @Setter
    private BigDecimal promotionDiscount;
    @Setter
    private PaymentType paymentType;
    @Setter
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "user.id")
    private Users user;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<OrdersDetail> ordersDetails;

    @OneToOne(mappedBy = "orders", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Payment payment;

    @Builder
    public Orders(String uid, String receiverName, String receiverTel,
                  String receiverAddr, String receiverAddrDetail, String deliveryMsg,
                  BigDecimal totalPrice, BigDecimal price, BigDecimal deliveryFee, BigDecimal promotionDiscount,
                  PaymentType paymentType, List<OrdersDetail> ordersDetails) {
        this.uid = uid;
        this.orderToken = TokenGenerator.generateOrderToken();
        this.receiverName = receiverName;
        this.receiverTel = receiverTel;
//        this.receiverEmail = receiverEmail;
        this.receiverAddr = receiverAddr;
        this.receiverAddrDetail = receiverAddrDetail;
        this.deliveryMsg = deliveryMsg;
        this.price = price;
        this.totalPrice = totalPrice;
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

    public void setPayment(Payment payment) {
        this.payment = payment;
        payment.setOrders(this);
    }
}
