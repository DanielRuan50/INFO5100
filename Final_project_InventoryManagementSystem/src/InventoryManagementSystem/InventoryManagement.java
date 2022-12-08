package InventoryManagementSystem;

import MO.IDandPasswords;
import UI.LoginPageUI;

public class InventoryManagement {

    public static void main(String[] args) {

        IDandPasswords idandPasswords = new IDandPasswords();       //create object idandPasswords of IDandPasswords class
        new LoginPageUI(idandPasswords.getLoginInfo());         //call LoginPageUI

    }
}
