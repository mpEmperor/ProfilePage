package com.example.hellofx;

import java.util.ArrayList;
import java.util.HashMap;

public class Account {
    private HashMap<String, String> userPass = new HashMap<String, String>();
    private HashMap<String, String> questAns = new HashMap<String, String>();

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
