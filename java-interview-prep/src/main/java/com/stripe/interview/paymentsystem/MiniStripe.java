package com.stripe.interview.paymentsystem;

public class MiniStripe {
    public static void main(String[] args) {
        // Create a payment management service
        PaymentManagementSystem paymentService = new PaymentManagementSystem();

        // Create a customer
        Customer customer = new Customer("123456");

        // Create a merchant
        Merchant merchant = new Merchant("987654");

        // Perform a transaction where the customer makes a payment to the merchant using Stripe
        double paymentAmount = 100.0;
        PaymentStrategy stripePaymentStrategy = new StripePaymentStrategy();
        paymentService.makePayment(customer, stripePaymentStrategy, paymentAmount);
        paymentService.receivePayment(merchant, paymentAmount);

        // Perform a transaction where the customer makes a payment to the merchant using PayPal
        double anotherPaymentAmount = 200.0;
        PaymentStrategy paypalPaymentStrategy = new PaypalPaymentStrategy();
        paymentService.makePayment(customer, paypalPaymentStrategy, anotherPaymentAmount);
        paymentService.receivePayment(merchant, anotherPaymentAmount);
    }
}
