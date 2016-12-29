package project.carRental.command;

import project.carRental.constantPages.ConstantPage;
import project.carRental.dao.implementations.CarDAO;
import project.carRental.dao.implementations.OrderDAO;
import project.carRental.dao.implementations.UserDAO;
import project.carRental.entity.Car;
import project.carRental.entity.Order;
import project.carRental.entity.User;
import project.carRental.utils.TableCar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yuriy Kolennikov
 */

public class FormFillingCommand implements Command {

    @Override
    public String exequte(HttpServletRequest request, HttpServletResponse response) {
        String fname = request.getParameter("pw1");
        String lname = request.getParameter("pw2");
        String email = request.getParameter("pw3");
        String age = request.getParameter("pw4");
        String phone = request.getParameter("pw5");
        String start = request.getParameter("pw7");
        String end = request.getParameter("pw8");

        int idUser = UserDAO.getInstance().getIdUser(email);
        int day = (int) request.getSession().getAttribute("day");

        UserDAO userDAO = UserDAO.getInstance();
        User user = new User(idUser, fname, lname, email, age, phone);
        int result = userDAO.update(user);
        if (result == 1) {
            creatOrder(request, day, email);
            request.setAttribute("start", start);
            request.setAttribute("end", end);
            return ConstantPage.RESULT_BOOKING_PAGE;
        }
        TableCar.createTableCarForUser(request);
        return ConstantPage.BOOKING_ERROR_TRY_AGAIN_PAGE;
    }

    private void creatOrder(HttpServletRequest request, int day, String email) {
        CarDAO carDAO = CarDAO.getInstance();
        int idCar = (int) (request.getSession().getAttribute("idCar"));
        Car car = carDAO.getById(idCar);
        int idUser = UserDAO.getInstance().getIdUser(email);
        int sum = car.getPrice();
        String STAT = "processing";
        String PAY = "awaiting";
        Order o = getOrder(idCar, idUser, day, sum, STAT, PAY);
        request.setAttribute("idOrder", o.getId());
        request.setAttribute("carBrand", o.getCarBrand());
        request.setAttribute("carMake", o.getCarMake());
        request.setAttribute("fname", o.getfNameUser());
        request.setAttribute("lname", o.getlNameUser());
        request.setAttribute("day", o.getData());
        request.setAttribute("sum", o.getSum());
        request.setAttribute("stat", o.getStat());
    }

    private Order getOrder(int idCar, int idUser, int day, int sum, String stat, String pay) {
        Order o = null;
        OrderDAO orderDAO = OrderDAO.getInstance();
        int mod = orderDAO.creatOrder(idCar, idUser, day, sum, stat, pay);
        if (mod == 1) {
            o = orderDAO.getAllByIdUser(idUser).getEntity();
        }
        return o;
    }
}
