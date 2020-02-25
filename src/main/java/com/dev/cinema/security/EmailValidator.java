package com.dev.cinema.security;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements
        ConstraintValidator<EmailConstraint, String> {
    private static final String REGEX_EMAIL = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+"
            + "@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}"
            + "[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";

    @Override
    public boolean isValid(String email,
                           ConstraintValidatorContext constraintValidatorContext) {
        return email.matches(REGEX_EMAIL);
    }
}
