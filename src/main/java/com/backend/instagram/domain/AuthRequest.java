package com.backend.instagram.domain;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class AuthRequest {

    @NotNull @Email
    @Getter
    @Setter
    private String username;
    @NotNull
    @Getter
    @Setter
    private String password;

}