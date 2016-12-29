package project.carRental.command;

import project.carRental.services.Account;
import project.carRental.services.Payment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yuriy Kolennikov
 */

public class PaymentCommand implements Command {
    private Payment payment;

    PaymentCommand(Payment payment) {
        this.payment = payment;
    }


    @Override
    public String exequte(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("idOrder");
        if (id == null) {
            return new Account().getOrderByUser(request, (String) request.getSession().getAttribute("email"));
        }
        int idOrder = Integer.parseInt(id);
        return payment.pay(idOrder, request);
    }
}
