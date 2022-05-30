package com.example.hellofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

import java.net.URI;
import java.net.URISyntaxException;

public class LogoutController {
    @FXML
    private ImageView myImageView;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private Label nameOfUser;
    @FXML
    private Label bday;
    Parent root;
    Scene scene;
    Stage stage;
    private static Account account;
    public static Account getAccount() {
        return account;
    }
    public static void setAccount(Account acc) {
        account = acc;
    }
    public void initialize() {
        scenePane.setBackground(new Background(new BackgroundFill(account.getTheme(), null, null)));
        nameOfUser.setText(account.getFirstName() + " " + account.getLastName());
        bday.setText(account.getBirthday().toString());
        myImageView.setImage(account.getAvatar());
    }
    public void logout(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout.");
        alert.setContentText("Confirm logout");
        if (alert.showAndWait().get() == ButtonType.OK) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
            root = loader.load();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void vsco() throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://vsco.co/jaidawilson/media/628c5d890acb486dd2832d29"));
    }
    public void hangMan(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
