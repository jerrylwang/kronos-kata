package com.sky.ovp.kronos.solid.service;

public interface ExternalFraudSystem {

    String[] getProblems(PaymentRequest request);

    boolean isFraudulant(PaymentRequest request);
}
