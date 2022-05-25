package com.example.hellofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController {
    @FXML
    private TextField loginUsername;
    @FXML
    private TextField loginPassword;
    @FXML
    private CheckBox checkbox;
    @FXML
    private TextField showPasswordField;
    @FXML
    private Label errorText;
    Stage stage;
    Scene scene;
    Parent root;
    private boolean isShow = false;
    public void login(ActionEvent event) throws IOException {
        String username = loginUsername.getText();
        String password;
        if (isShow) {
             password = showPasswordField.getText();
        } else {
             password = loginPassword.getText();
        }
        for (int i = 0; i < Accounts.getAccs().size(); i ++) {
            if (Accounts.getAccs().get(i).getUserPass().containsKey(username) && Accounts.getAccs().get(i).getUserPass().get(username).equals(password)) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LogoutScene.fxml"));
                root = loader.load();
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                errorText.setVisible(true);
            }
        }
    }
    public void register(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RegisterScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void forgotPassword(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ForgotScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void showPassword() {
        if (checkbox.isSelected()) {
            loginPassword.setVisible(false);
            showPasswordField.setVisible(true);
            showPasswordField.setText(loginPassword.getText());
            isShow = true;
        } else {
            loginPassword.setVisible(true);
            showPasswordField.setVisible(false);
            loginPassword.setText(showPasswordField.getText());
            isShow = false;
        }
    }
}
