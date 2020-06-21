package com.trendyol.dolapapp.exception;

import lombok.Data;

@Data
public class ResourceAlreadyHaveException extends RuntimeException {

    public ResourceAlreadyHaveException(String message) {
        super(message);
    }

}
