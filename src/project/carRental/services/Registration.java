package project.carRental.services;

import project.carRental.constantPages.ConstantPage;
import project.carRental.dao.implementations.UserDAO;
import project.carRental.entity.Role;
import project.carRental.entity.User;

/**
 * @author Yuriy kolennikov
 */

public class Registration {

    private Role role = new Role();

    public String createUser(String email, String pass, String fname,
                             String lname, String age, String phone) {
        UserDAO userDAO = UserDAO.getInstance();
        User user = userDAO.getUserByEmail(email);
        if (user != null) {
            return ConstantPage.THERES_A_MAIL_PAGE;
        }
        role.setId(1);
        String passCrypt = SecurityPass.passCrypt(pass);
        user = new User(role, email, passCrypt, fname, lname, age, phone);
        int i;
        i = userDAO.insert(user);
        if (i != 0) {
            return ConstantPage.LOGIN_AFTER_REGISTRATION_PAGE;
        }
        return ConstantPage.REGISTRATION_PAGE;
    }
}
