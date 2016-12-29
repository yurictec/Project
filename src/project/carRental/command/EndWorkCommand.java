package project.carRental.command;

import project.carRental.services.EndWork;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static project.carRental.constantPages.ConstantPage.ERROR_PAGE;

/**
 * Created by Yuriy Kolennikov
 */

public class EndWorkCommand implements Command {
    private EndWork endWork;

    EndWorkCommand(EndWork endWork) {
        this.endWork = endWork;
    }

    @Override
    public String exequte(HttpServletRequest request, HttpServletResponse response) {
        String param = request.getParameter("con");
        if (param == null) {
            return ERROR_PAGE;
        }
        return endWork.continueOrNot(param, request);
    }
}
