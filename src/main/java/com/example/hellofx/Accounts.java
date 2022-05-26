package com.example.hellofx;

import java.util.ArrayList;

public class Accounts {
    private static ArrayList<Account> accs = new ArrayList<Account>();

    public static ArrayList<Account> getAccs() {
        return accs;
    }

    public static void setAccs(ArrayList<Account> accs) {
        Accounts.accs = accs;
    }
}
