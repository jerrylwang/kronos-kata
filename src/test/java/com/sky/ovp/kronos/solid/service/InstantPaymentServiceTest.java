package com.sky.ovp.kronos.solid.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InstantPaymentServiceTest {

    @Mock
    ExternalFraudSystem externalFraudSystem;
    @Mock
    UKInstantPayments ukInstantPayments;

    @Test
    public void shouldSendPaymentToPayeeIfAllOK(){
        // given
        when(externalFraudSystem.isFraudulant(any())).thenReturn(false);

        InstantPaymentService systemUnderTest = new InstantPaymentService(externalFraudSystem,ukInstantPayments);

        //when
        PaymentRequest request = new PaymentRequest(100, "Stephen Wink", "Chung Man Chau", ZonedDateTime.parse(  "2021-02-17T16:24:11.252+05:30[Z]"  ));

        PaymentResponse response = systemUnderTest.makePayment(request);


        // then
        assertThat(response.isWasPaid()).isTrue();
    }

    @Test
    public void shouldNotSendPaymentIfSuspicious(){
        // given
        when(externalFraudSystem.isFraudulant(any())).thenReturn(true);
        when(externalFraudSystem.getProblems(any())).thenReturn(new String[]{"Multiple transactions in short period", "Transactions from new device", "Transactions in multiple locations"});

        InstantPaymentService systemUnderTest = new InstantPaymentService(externalFraudSystem,ukInstantPayments);

        //when
        PaymentRequest request = new PaymentRequest(100, "Stephen Wink", "Chung Man Chau", ZonedDateTime.parse(  "2021-02-17T16:24:11.252+05:30[Z]"  ));

        PaymentResponse response = systemUnderTest.makePayment(request);

        // then
        assertThat(response.getSuspiciousStuff()).contains("Multiple transactions in short period", "Transactions from new device", "Transactions in multiple locations");
        assertThat(response.isSuspicious()).isTrue();
        assertThat(response.isWasPaid()).isFalse();
    }

    @Test
    public void shouldNotPayIfPaymentTooFarInFuture(){
        // given
        when(externalFraudSystem.isFraudulant(any())).thenReturn(true);
        when(externalFraudSystem.getProblems(any())).thenReturn(new String[]{"Multiple transactions in short period", "Transactions from new device", "Transactions in multiple locations"});

        InstantPaymentService systemUnderTest = new InstantPaymentService(externalFraudSystem,ukInstantPayments);

        //when
        PaymentRequest request = new PaymentRequest(100, "Stephen Wink", "Chung Man Chau", ZonedDateTime.parse(  "2022-02-17T16:24:11.252+05:30[Z]"  ));

        PaymentResponse response = systemUnderTest.makePayment(request);

        // then

        assertThat(response.isWasPaid()).isFalse();
    }

}