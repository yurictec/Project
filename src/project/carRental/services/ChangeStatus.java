package project.carRental.services;

import project.carRental.dao.implementations.OrderDAO;
import project.carRental.entity.Order;
import project.carRental.utils.TableCar;

import javax.servlet.http.HttpServletRequest;

import static project.carRental.constantPages.ConstantPage.ERROR_PAGE;
import static project.carRental.constantPages.ConstantPage.MANAGER_PAGE;

/**
 * @author Yuriy Kolennikov
 */

public class ChangeStatus {

    public String change(String stat, int idOrder, HttpServletRequest request) {
        OrderDAO orderDAO = OrderDAO.getInstance();
        Order order = new Order();
        order.setId(idOrder);
        order.setStat(stat);
        int mod = orderDAO.update(order);
        if (mod != 1) {
            return ERROR_PAGE;
        }
        TableCar.createTableOrderForManager(request);
        return MANAGER_PAGE;
    }

}
