package com.stripe.interview.paymentsystem;

public interface PaymentStrategy {
    void process(double amount);
}
