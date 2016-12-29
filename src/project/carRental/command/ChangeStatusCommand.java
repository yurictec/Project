package project.carRental.command;

import project.carRental.constantPages.ConstantPage;
import project.carRental.dao.implementations.OrderDAO;
import project.carRental.entity.Order;
import project.carRental.utils.TableCar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yuriy Kolennikov
 */

public class ChangeStatusCommand implements Command {

    @Override
    public String exequte(HttpServletRequest request, HttpServletResponse response) {
        String status = request.getParameter("status");
        String id = request.getParameter("idOrder");

        if (status == null && id == null) {
            return ConstantPage.ERROR_PAGE;
        }
        int idOrder = Integer.parseInt(id);
        OrderDAO orderDAO = OrderDAO.getInstance();
        Order order = new Order();
        order.setId(idOrder);
        order.setStat(status);
        int mod = orderDAO.update(order);
        if (mod != 1) {
            return ConstantPage.ERROR_PAGE;
        }
        TableCar.createTableOrderForManager(request);
        return ConstantPage.MANAGER_PAGE;
    }
}
