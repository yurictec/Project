package project.carRental.command;

import project.carRental.constantPages.ConstantPage;
import project.carRental.services.ChangeStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yuriy Kolennikov
 */

public class ChangeStatusCommand implements Command {

    private ChangeStatus changeStatus;

    ChangeStatusCommand(ChangeStatus changeStatus) {
        this.changeStatus = changeStatus;
    }


    @Override
    public String exequte(HttpServletRequest request, HttpServletResponse response) {
        String status = request.getParameter("status");
        String id = request.getParameter("idOrder");

        if (status == null && id == null) {
            return ConstantPage.ERROR_PAGE;
        }
        int idOrder = Integer.parseInt(id);
        return changeStatus.change(status, idOrder, request);
    }
}
