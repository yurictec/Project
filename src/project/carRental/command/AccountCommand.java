package project.carRental.command;

import project.carRental.constantPages.ConstantPage;
import project.carRental.container.Container;
import project.carRental.dao.implementations.OrderDAO;
import project.carRental.dao.implementations.UserDAO;
import project.carRental.entity.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuriy Kolennikov
 */

public class AccountCommand implements Command {

    @Override
    public String exequte(HttpServletRequest request, HttpServletResponse response) {
        String email = (String) request.getSession().getAttribute("email");
        if (email == null) {
            return ConstantPage.LOGIN_PAGE;
        }
        UserDAO userDAO = UserDAO.getInstance();
        int idUser = userDAO.getIdUser(email);
        Container<Order> c = OrderDAO.getInstance().getAllByIdUser(idUser);
        List<Order> listOrder = getListOrder(c);
        if (listOrder.size() > 0) {
            request.setAttribute("listOrder", listOrder);
            return ConstantPage.MY_ACCOUNT_PAGE;
        }
        return ConstantPage.ACCOIUNT_NOT_ORDER_PAGE;
    }

    private List<Order> getListOrder(Container<Order> container) {
        Order order;
        List<Order> list = new ArrayList<>();
        for (int i = 0; i < container.getLenght(); i++) {
            order = container.getEntity();
            list.add(order);
        }
        return list;
    }
}
