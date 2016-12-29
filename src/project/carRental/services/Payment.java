package project.carRental.services;

import project.carRental.constantPages.ConstantPage;
import project.carRental.dao.implementations.OrderDAO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Yuriy kolennikov
 */

public class Payment {

    public String pay(int idOrder, HttpServletRequest request) {
        OrderDAO orderDAO = OrderDAO.getInstance();
        String PAY = "paid";
        int mod = orderDAO.pay(idOrder, PAY);
        if (mod != 1) {
            return ConstantPage.ERROR_PAGE;
        }
        return new Account().getOrderByUser(request, (String) request.getSession().getAttribute("email"));
    }
}
