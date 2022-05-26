package com.example.hellofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;


public class RegisterController {
    @FXML
    private ImageView regImgView;
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
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private DatePicker birthdayPick;
    @FXML
    private ColorPicker themePick;
    @FXML
    private AnchorPane avatarPane;
    @FXML
    private ImageView imgView1;
    @FXML
    private ImageView imgView2;
    @FXML
    private ImageView imgView3;
    @FXML
    private RadioButton rButton1, rButton2, rButton3;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void register(ActionEvent event) throws IOException {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        Color theme  = themePick.getValue();
        LocalDate birthday = birthdayPick.getValue();
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
            acc.setFirstName(firstName);
            acc.setLastName(lastName);
            acc.setBirthday(birthday);
            acc.setTheme(theme);
            acc.setAvatar(regImgView.getImage());
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
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void changeAvatar()  {
       avatarPane.setVisible(true);
       avatarPane.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 1, 0.5), null, null)));
    }
    public void applyAvatar() {
        if (rButton1.isSelected()) {
            regImgView.setImage(imgView1.getImage());
        } else if (rButton2.isSelected()) {
            regImgView.setImage(imgView2.getImage());
        } else if (rButton3.isSelected()) {
            regImgView.setImage(imgView3.getImage());
        }
        avatarPane.setVisible(false);
    }
}
