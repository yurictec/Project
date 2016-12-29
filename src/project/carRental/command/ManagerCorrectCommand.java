package project.carRental.command;

import project.carRental.constantPages.ConstantPage;
import project.carRental.services.ManagerCorrect;
import project.carRental.utils.TableCar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yuriy Kolennikov
 */

public class ManagerCorrectCommand implements Command {
    private ManagerCorrect managerCorrect;

    ManagerCorrectCommand(ManagerCorrect managerCorrect) {
        this.managerCorrect = managerCorrect;
    }

    @Override
    public String exequte(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("order");
        if (id == null) {
            int size = TableCar.createTableOrderForManager(request);
            if (size > 0) {
                return ConstantPage.MANAGER_PAGE;
            }
            return ConstantPage.NOT_NEW_ORDERS_PAGE;
        }
        int idOrder = Integer.parseInt(id);
        return managerCorrect.correctOrder(idOrder, request);
    }
}
