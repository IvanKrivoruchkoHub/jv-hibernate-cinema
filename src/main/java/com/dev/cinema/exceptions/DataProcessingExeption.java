package com.dev.cinema.exceptions;

public class DataProcessingExeption extends RuntimeException {
    public DataProcessingExeption(String s, Exception e) {
        super(s, e);
    }
}
