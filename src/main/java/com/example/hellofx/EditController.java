package com.example.hellofx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;

public class EditController {
    @FXML
    private Label username;
    @FXML
    private Label password;
    @FXML
    private ImageView avatarView;
    @FXML
    private Label theme;
    @FXML
    private Label birthday;
    @FXML
    private AnchorPane scenePane;
    public void initialize() {
        scenePane.setBackground(new Background(new BackgroundFill(LogoutController.getAccount().getTheme(), null, null)));
        username.setText((String) LogoutController.getAccount().getUserPass().keySet().toArray()[0]);
        password.setText(LogoutController.getAccount().getUserPass().get(username.getText()));
        avatarView.setImage(LogoutController.getAccount().getAvatar());
        theme.setText(LogoutController.getAccount().getTheme().toString());
        birthday.setText(LogoutController.getAccount().getBirthday().toString());
    }
}
