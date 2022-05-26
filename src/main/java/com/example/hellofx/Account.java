package com.example.hellofx;

import javafx.scene.paint.Color;
import java.time.LocalDate;
import java.util.HashMap;

public class Account {
    private HashMap<String, String> userPass = new HashMap<String, String>();
    private HashMap<String, String> questAns = new HashMap<String, String>();
    private String firstName;
    private String lastName;
    private Color theme;
    private LocalDate birthday;

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
