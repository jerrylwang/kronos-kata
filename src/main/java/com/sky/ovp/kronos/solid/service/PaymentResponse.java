package com.sky.ovp.kronos.solid.service;

import java.time.ZonedDateTime;

public class PaymentResponse {

    private boolean suspicious = false;
    private String[] suspiciousStuff=null;
    private boolean wasPaid = true;

    public boolean isWasPaid() {
        return wasPaid;
    }

    public void setWasPaid(boolean wasPaid) {
        this.wasPaid = wasPaid;
    }

    public ZonedDateTime getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(ZonedDateTime timeSent) {
        this.timeSent = timeSent;
    }

    private ZonedDateTime timeSent = null;

    public void setSuspicious(boolean b) {
        this.suspicious = b;
    }

    public boolean isSuspicious(){
        return suspicious;
    }

    public void addSuspiciousStuff(String[] problems) {
        this.suspiciousStuff = problems;
    }

    public String[] getSuspiciousStuff(){
        return suspiciousStuff;
    }
}
