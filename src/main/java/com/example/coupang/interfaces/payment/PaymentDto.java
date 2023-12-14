package com.example.coupang.interfaces.payment;

import com.example.coupang.common.TokenGenerator;
import com.example.coupang.domain.enums.CardCompany;
import com.example.coupang.domain.enums.PaymentType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class PaymentDto {

    @Getter
    @Setter
    @ToString
    public static class PaymentRequest {
        private String orderToken;
        private PaymentType paymentType;
        private CardCompany cardCompany;
        private String cardNo;
        private String cardExpYear;
        private String cardExpMon;
        private String cardCvv;
        private String cardPw;
    }

    @Getter
    @Setter
    @ToString
    public static class PaymentResponse {
        private String orderToken;
        private String pgId;
        private Boolean isSuccess;

        @Builder
        public PaymentResponse(String orderToken, String pgId) {
            this.orderToken = orderToken;
            this.pgId = TokenGenerator.generatePgId();
            this.isSuccess = true;
        }
    }


}
