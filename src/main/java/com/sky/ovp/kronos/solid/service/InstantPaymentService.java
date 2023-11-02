package com.sky.ovp.kronos.solid.service;


import java.time.Duration;

import static java.time.ZonedDateTime.now;

public class InstantPaymentService {

    private FraudCheckService fraudCheckService;
    private UKInstantPayments paymentInfrastructure;

    public InstantPaymentService(ExternalFraudSystem externalFraudSystem, UKInstantPayments paymentInfrastructure){
        fraudCheckService = new FraudCheckService(externalFraudSystem);
        this.paymentInfrastructure = paymentInfrastructure;
    }

    public PaymentResponse makePayment(PaymentRequest request){

        PaymentResponse response= new PaymentResponse();
        try{
            response = fraudCheckService.checkForSuspiciousBehaviour(request) ;
        }catch (FraudCheckException fre){
            response.addSuspiciousStuff(fre.getProblems());
            response.setSuspicious(fre.suspicious);
            response.setWasPaid(false);
            return response;
        }

        if(request.getAmount()<10000 && response.isSuspicious()==false  ){
            if(request.getPaymentDate().isBefore(now().plus(Duration.ofHours(72))))
                paymentInfrastructure.sendPayment(request, response);
            else
                response.setWasPaid(false);
        }
        return response;
    }
}
