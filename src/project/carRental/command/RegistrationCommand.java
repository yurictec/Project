package project.carRental.command;

import project.carRental.constantPages.ConstantPage;
import project.carRental.dao.implementations.UserDAO;
import project.carRental.entity.Role;
import project.carRental.entity.User;
import project.carRental.services.SecurityPass;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yuriy Kolennikov
 */

public class RegistrationCommand implements Command {

    @Override
    public String exequte(HttpServletRequest request, HttpServletResponse response) {
        String fname = request.getParameter("pw3");
        String lname = request.getParameter("pw4");
        String email = request.getParameter("pw5");
        String pass = request.getParameter("pw1");
        String age = "";
        String phone = "";

        UserDAO userDAO = UserDAO.getInstance();
        User user = userDAO.getUserByEmail(email);
        if (user != null) {
            return ConstantPage.THERES_A_MAIL_PAGE;
        }
        Role role = new Role();
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
