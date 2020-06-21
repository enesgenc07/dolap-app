package com.trendyol.dolapapp.exception;

import lombok.Data;

@Data
public class NotFoundException extends RuntimeException {

    public NotFoundException(String entity) {
        super(entity + " not found");
    }

}
