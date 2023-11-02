package com.sky.ovp.kronos.solid.service;

public class FraudCheckService {

    private ExternalFraudSystem fraudSystem;

    public FraudCheckService(ExternalFraudSystem fraudSystem){
        this.fraudSystem = fraudSystem;
    }

    public PaymentResponse checkForSuspiciousBehaviour(PaymentRequest request) throws FraudCheckException {
        PaymentResponse response = new PaymentResponse();
        if( isFraudulant(request)){
            throw new FraudCheckException(getProblems(request));
        } else {
            response.setSuspicious(false);
        }
        return response;
    }

    private String[] getProblems(PaymentRequest request) {
        return fraudSystem.getProblems(request);
    }

    private boolean isFraudulant(PaymentRequest request) {
        return fraudSystem.isFraudulant(request);
    }
}
