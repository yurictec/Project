package project.carRental.command;

import project.carRental.dao.implementations.UserDAO;
import project.carRental.services.FormFilling;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yuriy Kolennikov
 */

public class FormFillingCommand implements Command {

    private FormFilling filling = null;

    FormFillingCommand(FormFilling filling) {
        this.filling = filling;
    }

    @Override
    public String exequte(HttpServletRequest request, HttpServletResponse response) {
        String fname = request.getParameter("pw1");
        String lname = request.getParameter("pw2");
        String email = request.getParameter("pw3");
        String age = request.getParameter("pw4");
        String phone = request.getParameter("pw5");
        String car = request.getParameter("pw6");
        String start = request.getParameter("pw7");
        String end = request.getParameter("pw8");
        int idUser = UserDAO.getInstance().getIdUser(email);
        int day = (int) request.getSession().getAttribute("day");
        return filling.formFilling(idUser, day, fname, lname, email, age, phone, start, end, request);
    }
}
