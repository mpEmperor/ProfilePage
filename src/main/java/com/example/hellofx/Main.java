package com.example.hellofx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Account defaultAccount = new Account();
        defaultAccount.getUserPass().put("37901101", "pm101");
        defaultAccount.getQuestAns().put("What is your favorite food?", "pizza");
        defaultAccount.setFirstName("Prabnoor");
        defaultAccount.setLastName("Multani");
        defaultAccount.setTheme(Color.WHITE);
        defaultAccount.setBirthday(LocalDate.of(2004, 6, 30));
        Accounts.getAccs().add(defaultAccount);
        Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        stage.setTitle("Prab's attempt at Social Media");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> {
            event.consume();
            logout(stage);
        });
    }
    public void logout(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to exit out of the application.");
        alert.setContentText("Confirm exit");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage.close();
        }

    }
}
