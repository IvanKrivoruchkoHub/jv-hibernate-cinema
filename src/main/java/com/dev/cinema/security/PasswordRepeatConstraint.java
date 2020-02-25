package com.dev.cinema.security;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = PasswordRepeatValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordRepeatConstraint {
    String message() default "Password don't equal repeatedPassword";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
