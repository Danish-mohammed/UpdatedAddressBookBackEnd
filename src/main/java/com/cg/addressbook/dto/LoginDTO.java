package com.cg.addressbook.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class LoginDTO {
    public String email;
    public String password;
}
