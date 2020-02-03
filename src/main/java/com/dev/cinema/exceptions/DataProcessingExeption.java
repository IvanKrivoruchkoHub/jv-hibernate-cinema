package com.dev.cinema.exceptions;

import java.sql.SQLException;

public class DataProcessingExeption extends Exception {
    public DataProcessingExeption(String s, Exception e) {
        super(s, e);
    }
}
