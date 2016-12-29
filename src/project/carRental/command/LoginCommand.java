package project.carRental.command;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import project.carRental.constantPages.ConstantPage;
import project.carRental.services.Security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yuriy Kolennikov
 */

public class LoginCommand implements Command {

    private Security s = null;
    private static Logger log = Logger.getLogger(Command.class.getName());

    LoginCommand(Security s) {
        this.s = s;
    }

    @Override
    public String exequte(HttpServletRequest request, HttpServletResponse response) {
        try {
            String email = request.getParameter("email");
            String pass = request.getParameter("pass");
            if (email != null & pass != null) {
                return s.LogIn(email, pass, request);
            }
        } catch (Exception e) {
            log.log(Level.ERROR, "LoginCommand exequte", e);
        }
        return ConstantPage.LOGIN_PAGE;
    }
}
