package com.bny.bank.entity.user;

import com.bny.bank.entity.request.user.UserRequest;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@ToString
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String password;

    public User(UserRequest request) {
        this.login = request.getLogin();
        this.password = request.getPassword();
    }
}
