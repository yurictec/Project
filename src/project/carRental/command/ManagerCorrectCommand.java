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

public class ManagerCorrectCommand implements Command {

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
