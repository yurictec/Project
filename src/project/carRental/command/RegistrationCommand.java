package project.carRental.command;

import project.carRental.services.Registration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yuriy Kolennikov
 */

public class RegistrationCommand implements Command {
    private Registration r;

    RegistrationCommand(Registration r) {
        this.r = r;
    }

    @Override
    public String exequte(HttpServletRequest request, HttpServletResponse response) {
        String fname = request.getParameter("pw3");
        String lname = request.getParameter("pw4");
        String email = request.getParameter("pw5");
        String pass = request.getParameter("pw1");
        String age = "";
        String phone = "";

        return r.createUser(email, pass, fname, lname, age, phone);
    }

}
