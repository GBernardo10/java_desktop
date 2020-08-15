package com.bny.bank.entity.request.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {
    private String login;
    private String password;
}
