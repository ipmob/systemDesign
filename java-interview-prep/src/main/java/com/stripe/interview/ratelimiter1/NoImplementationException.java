package com.stripe.interview.ratelimiter1;

public class NoImplementationException extends RuntimeException {
    public NoImplementationException(){
        this("Method not found");
    }
    public NoImplementationException(final String message ){
        super(message);
    }
}
