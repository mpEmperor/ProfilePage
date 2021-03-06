package com.example.hellofx;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import java.time.LocalDate;
import java.util.HashMap;

public class Account {
    private HashMap<String, String> userPass;
    private HashMap<String, String> questAns;
    private String firstName;
    private String lastName;
    private Color theme;
    private LocalDate birthday;
    private Image avatar;

    public Account() {
        this.userPass = new HashMap<>();
        this.questAns = new HashMap<>();
    }

    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Color getTheme() {
        return theme;
    }

    public void setTheme(Color theme) {
        this.theme = theme;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public HashMap<String, String> getUserPass() {
        return userPass;
    }
    public void setUserPass(HashMap<String, String> userPass) {
        this.userPass = userPass;
    }

    public HashMap<String, String> getQuestAns() {
        return questAns;
    }

    public void setQuestAns(HashMap<String, String> questAns) {
        this.questAns = questAns;
    }
}
