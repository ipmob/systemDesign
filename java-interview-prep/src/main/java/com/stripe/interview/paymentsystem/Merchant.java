package com.stripe.interview.paymentsystem;

public class Merchant {
    private String merchantId;

    public Merchant(String merchantId){
        this.merchantId = merchantId;
    }

    public String getMerchantId(){
        return merchantId;
    }
}
