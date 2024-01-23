/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import dao.UserImplDAO;
import model.User;

/**
 *
 * @author dev
 */
public class UserService {
    public void createUser(String userName){
        User u = new User();
        u.setNombre(userName);
        UserImplDAO uid = new UserImplDAO();
        try {          
                uid.createUser(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
