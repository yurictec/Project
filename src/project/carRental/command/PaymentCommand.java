package project.carRental.command;

import project.carRental.constantPages.ConstantPage;
import project.carRental.dao.implementations.OrderDAO;
import project.carRental.services.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yuriy Kolennikov
 */

public class PaymentCommand implements Command {

    @Override
    public String exequte(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("idOrder");
        if (id == null) {
            return new Account().getOrderByUser(request, (String) request.getSession().getAttribute("email"));
        }
        int idOrder = Integer.parseInt(id);
        OrderDAO orderDAO = OrderDAO.getInstance();
        String PAY = "paid";
        int mod = orderDAO.pay(idOrder, PAY);
        if (mod != 1) {
            return ConstantPage.ERROR_PAGE;
        }
        return new Account().getOrderByUser(request, (String) request.getSession().getAttribute("email"));
    }
}
