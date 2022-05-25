package com.example.hellofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ForgotController {
    @FXML
    private TextField username;
    @FXML
    private Label questionText;
    @FXML
    private TextField answerField;
    @FXML
    private Label passwordText;
    @FXML
    private Button recoverButton;
    @FXML
    private Label passwordText1;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField passwordField1;
    @FXML
    private Button ConfirmButton;

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void recoverPassword() {
        String name = username.getText();
        for (int i = 0; i < Accounts.getAccs().size(); i ++) {
            if (Accounts.getAccs().get(i).getUserPass().containsKey(name)) {
                questionText.setVisible(true);
                questionText.setText((String) Accounts.getAccs().get(i).getQuestAns().keySet().toArray()[0]);
                answerField.setVisible(true);
                recoverButton.setVisible(true);
                answerQuestion(i, questionText.getText());
                break;
            }
        }
    }
    public void answerQuestion(int index, String question) {
        if (answerField.getText().equals(Accounts.getAccs().get(index).getQuestAns().get(question))) {
            passwordText.setVisible(true);
            passwordText1.setVisible(true);
            passwordField.setVisible(true);
            passwordField1.setVisible(true);
            ConfirmButton.setVisible(true);
        }
    }
    public void confirm(ActionEvent event) throws IOException {
        for (int i = 0; i < Accounts.getAccs().size(); i ++) {
            if (Accounts.getAccs().get(i).getUserPass().containsKey(username.getText())) {
                Accounts.getAccs().get(i).getUserPass().replace(username.getText(), passwordField.getText());
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
                root = loader.load();
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
    }
    public void returnLogin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
