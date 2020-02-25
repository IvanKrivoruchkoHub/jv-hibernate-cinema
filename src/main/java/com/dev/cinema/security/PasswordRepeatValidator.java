package com.dev.cinema.security;

import com.dev.cinema.dto.UserRegisterDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordRepeatValidator implements
        ConstraintValidator<PasswordRepeatConstraint, UserRegisterDto> {
    @Override
    public boolean isValid(UserRegisterDto userRegisterDto
            , ConstraintValidatorContext constraintValidatorContext) {
        return userRegisterDto.getPassword().equals(userRegisterDto.getRepeatedPassword());
    }
}
