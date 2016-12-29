package project.carRental.services;

import project.carRental.constantPages.ConstantPage;
import project.carRental.dao.implementations.OrderDAO;
import project.carRental.entity.Order;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Yuriy kolennikov
 */

public class ManagerCorrect {

    public String correctOrder(int idOrder, HttpServletRequest request) {
        OrderDAO orderDAO = OrderDAO.getInstance();
        Order o = orderDAO.getById(idOrder);
        if (o == null) {
            return ConstantPage.ERROR_PAGE;
        }
        request.setAttribute("idOrder", o.getId());
        request.setAttribute("carBrand", o.getCarBrand());
        request.setAttribute("carMake", o.getCarMake());
        request.setAttribute("fname", o.getfNameUser());
        request.setAttribute("lname", o.getlNameUser());
        request.setAttribute("sum", o.getSum());
        request.setAttribute("stat", o.getStat());
        return ConstantPage.FORM_FILLING_MANAGER_PAGE;
    }
}
