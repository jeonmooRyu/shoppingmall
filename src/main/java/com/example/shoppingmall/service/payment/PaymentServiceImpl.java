package com.example.shoppingmall.service.payment;

import com.example.shoppingmall.domain.orders.Orders;
import com.example.shoppingmall.domain.payment.Payment;
import com.example.shoppingmall.interfaces.payment.PaymentDto;
import com.example.shoppingmall.interfaces.payment.PaymentDtoMapper;
import com.example.shoppingmall.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;
    private final PaymentDtoMapper paymentDtoMapper;

    /**
     * PG사 결제진행 통신
     */
    @Override
    public void payOrders( Orders orders, PaymentDto.PaymentRequest request) {
        var response = PaymentDto.PaymentResponse.builder()
                .orderToken(request.getOrderToken())
                .build();
        var command = paymentDtoMapper.of(request, response);
        var payment = command.toEntity(orders);
        this.save(payment);
    }

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }
}
