package com.example.hellofx;

import javafx.collections.ObservableArray;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;


public class RegisterController {
    @FXML
    private TextField RegisterUserName;
    @FXML
    private TextField RegisterPassword;
    @FXML
    private Label existText;
    @FXML
    private ComboBox questionsBox;
    @FXML
    private TextField answer;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void register(ActionEvent event) throws IOException {
        String username = RegisterUserName.getText();
        String password = RegisterPassword.getText();
        String secQuestion = questionsBox.getValue().toString();
        String secAnswer = answer.getText();
        boolean isExist = false;
        for (int i = 0; i < Accounts.getAccs().size(); i ++) {
            if (Accounts.getAccs().get(i).getUserPass().containsKey(username)) {
                isExist = true;
            } else {
                isExist = false;
            }
        }
        if (isExist) {
            existText.setVisible(true);
        } else {
            Account acc = new Account();
            acc.getQuestAns().put(secQuestion, secAnswer);
            acc.getUserPass().put(username, password);
            Accounts.getAccs().add(acc);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
            root = loader.load();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void accountExist(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
