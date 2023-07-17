package com.stripe.interview.paymentsystem;

public class PaymentManagementSystem {
    public void makePayment(Customer customer, PaymentStrategy paymentStrategy, double amount){
        paymentStrategy.process(amount);
    }
    public void receivePayment(Merchant merchant, double amount) {
        System.out.println("Merchant " + merchant.getMerchantId() + " received a payment of $" + amount);
        // Additional merchant-specific logic
    }
}
