package com.br.arraiapp.domain.exception;

import java.io.Serial;

public class CheckoutNotPaidException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public CheckoutNotPaidException(String message) {
        super(message);
    }
}
