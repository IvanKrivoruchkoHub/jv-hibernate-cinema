package com.dev.cinema.dto;

import com.dev.cinema.security.EmailConstraint;
import com.dev.cinema.security.PasswordRepeatConstraint;
import javax.validation.constraints.NotNull;

@PasswordRepeatConstraint
public class UserRegisterDto {
    @NotNull
    @EmailConstraint
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String repeatedPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }
}
