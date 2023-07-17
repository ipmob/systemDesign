package com.stripe.interview.paymentsystem;

public class StripePaymentStrategy implements PaymentStrategy{
    @Override
    public void process(double amount) {
        System.out.println("Process payment of $ +" + amount +" via stripe");
    }
}
