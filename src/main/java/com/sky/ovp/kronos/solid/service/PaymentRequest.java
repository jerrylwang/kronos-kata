package com.sky.ovp.kronos.solid.service;

import java.time.ZonedDateTime;

public class PaymentRequest {

    private int amount;
    private String customer;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public ZonedDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(ZonedDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    private String payee;
    private ZonedDateTime paymentDate;

    public PaymentRequest(int amount, String customer, String payee, ZonedDateTime paymentDate){
        this.amount = amount;
        this.customer = customer;
        this.payee = payee;
        this.paymentDate = paymentDate;
    }

    public int getAmount(){
        return amount;
    }
}
