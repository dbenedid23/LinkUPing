
import Services.UserService;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dev
 */
public class Main {
    public static void main(String[] args) {
        String userName = "";
        UserService us = new UserService();
        us.createUser(userName);
    }
}
