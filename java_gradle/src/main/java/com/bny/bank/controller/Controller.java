package com.bny.bank.controller;

import com.bny.bank.entity.request.user.UserRequest;
import com.bny.bank.entity.user.User;
import com.bny.bank.repository.user.UserRepository;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {

    private final UserRepository repository;

    public Label labelLogin;
    public TextField login;
    public Label labelPassword;
    public Button send;
    public PasswordField password;

    @Autowired
    public Controller(UserRepository repository) {
        this.repository = repository;
    }

    public void createUser(ActionEvent actionEvent) {
        if (login.getText().isEmpty() || password.getText().isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Preencha os campos").showAndWait();
            return;
        }

        User user = new User(UserRequest
                .builder()
                .login(login.getText())
                .password(password.getText())
                .build());

        User response = repository.save(user);

        if (response.getId() != null) {
            login.clear();
            password.clear();
        }
    }
}