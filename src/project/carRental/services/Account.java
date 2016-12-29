package project.carRental.services;

import project.carRental.container.Container;
import project.carRental.dao.implementations.OrderDAO;
import project.carRental.entity.Order;
import project.carRental.dao.implementations.UserDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static project.carRental.constantPages.ConstantPage.ACCOIUNT_NOT_ORDER_PAGE;
import static project.carRental.constantPages.ConstantPage.MY_ACCOUNT_PAGE;

/**
 * @author Yuriy kolennikov
 */
public class Account {

    public String getOrderByUser(HttpServletRequest request, String email) {
        UserDAO userDAO = UserDAO.getInstance();
        int idUser = userDAO.getIdUser(email);
        Container<Order> c = OrderDAO.getInstance().getAllByIdUser(idUser);
        List<Order> listOrder = getListOrder(c);
        if (listOrder.size() > 0) {
            request.setAttribute("listOrder", listOrder);
            return MY_ACCOUNT_PAGE;
        }
        return ACCOIUNT_NOT_ORDER_PAGE;
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
