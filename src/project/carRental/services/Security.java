package project.carRental.services;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import project.carRental.constantPages.ConstantPage;
import project.carRental.dao.implementations.UserDAO;
import project.carRental.entity.User;
import project.carRental.utils.TableCar;

import javax.servlet.http.HttpServletRequest;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static project.carRental.constantPages.ConstantPage.*;

/**
 * @author Yuriy kolennikov
 */

public class Security {

    public Security() {
    }

    public String LogIn(String email, String pass, HttpServletRequest request) {
        String passCrypt = SecurityPass.passCrypt(pass);
        User user = UserDAO.getInstance().getLoginAndPassword(email, passCrypt);
        if (user != null) {
            if (user.getRole().getRole().equals("admin")) {
                request.getSession(true);
                request.getSession().setAttribute("email", user.getEmail());
                request.getSession().setAttribute("role", user.getRole());
                TableCar.createTableCarForAdmin(request);
                return ConstantPage.ADMIN_PAGE;
            }
            if (user.getRole().getRole().equals("manager")) {
                request.getSession(true);
                request.getSession().setAttribute("email", user.getEmail());
                request.getSession().setAttribute("role", user.getRole());
                int size = TableCar.createTableOrderForManager(request);
                if (size > 0) {
                    return ConstantPage.MANAGER_PAGE;
                }
                return ConstantPage.NOT_NEW_ORDERS_PAGE;
            }
            if (user.getRole().getRole().equals("visitor")) {
                request.getSession(true);
                request.getSession().setAttribute("email", user.getEmail());
                request.getSession().setAttribute("role", user.getRole());
                TableCar.createTableCarForUser(request);
                return ConstantPage.BOOKING_PAGE;
            }
        }
        return ConstantPage.LOGIN_AGAIN_PAGE;
    }
}

