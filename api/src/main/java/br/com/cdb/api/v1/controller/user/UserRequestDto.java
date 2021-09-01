package br.com.cdb.api.v1.controller.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private String name;
    private String cpf;
    private String email;
    private String password;
}
