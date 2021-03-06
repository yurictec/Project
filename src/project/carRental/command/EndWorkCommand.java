package project.carRental.command;

import project.carRental.constantPages.ConstantPage;
import project.carRental.utils.TableCar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yuriy Kolennikov
 */

public class EndWorkCommand implements Command {

    @Override
    public String exequte(HttpServletRequest request, HttpServletResponse response) {
        String param = request.getParameter("con");
        if (param == null) {
            return ConstantPage.ERROR_PAGE;
        }
        String PARAM_CONTINUE = "Continue";
        if (param.equals(PARAM_CONTINUE)) {
            TableCar.createTableCarForUser(request);
            return ConstantPage.BOOKING_PAGE;
        }
        String PARAM_END = "End";
        if (param.equals(PARAM_END)) {
            clear(request);
            return ConstantPage.LOGIN_PAGE;
        }
        return ConstantPage.ERROR_PAGE;
    }

    private void clear(HttpServletRequest request) {
        request.getSession().setAttribute("email", null);
        request.getSession().setAttribute("role", null);
    }
}
