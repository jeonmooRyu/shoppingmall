package com.example.coupang.service.payment;

import com.example.coupang.domain.orders.Orders;
import com.example.coupang.domain.payment.Payment;
import com.example.coupang.interfaces.payment.PaymentDto;
import com.example.coupang.interfaces.payment.PaymentDtoMapper;
import com.example.coupang.repository.PaymentRepository;
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
