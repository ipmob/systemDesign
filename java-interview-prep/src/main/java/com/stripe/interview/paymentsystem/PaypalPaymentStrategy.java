package com.stripe.interview.paymentsystem;

public class PaypalPaymentStrategy  implements PaymentStrategy{
    @Override
    public void process(double amount) {
        System.out.println("Process payment of $ +" + amount +" via paypal");
    }
}
