package project.carRental.services;

import project.carRental.dao.implementations.CarDAO;
import project.carRental.entity.User;
import project.carRental.dao.implementations.UserDAO;
import project.carRental.entity.Car;
import project.carRental.utils.TableCar;

import javax.servlet.http.HttpServletRequest;

import static project.carRental.constantPages.ConstantPage.BOOKING_ERROR_TRY_AGAIN_PAGE;
import static project.carRental.constantPages.ConstantPage.BOOKING_NOT_AVAILABLE_TRY_AGAIN_PAGE;
import static project.carRental.constantPages.ConstantPage.FORM_FILLING_USER_PAGE;

/**
 * @author Yuriy kolennikov
 */

public class Booking {

    public String booking(int id, int day, HttpServletRequest request) {
        CarDAO carDAO = CarDAO.getInstance();
        Car car = carDAO.getById(id);
        assert car != null;
        String Stat2 = "Busy";
        if (car.getStat().equals(Stat2)) {
            TableCar.createTableCarForUser(request);
            return BOOKING_ERROR_TRY_AGAIN_PAGE;
        }else {
//        car.setStat(Stat2);
//        int result = carDAO.updateStat(car.getId(), Stat2);
//        if (result == 1) {
            getUser(request, id, day);
            request.getSession().setAttribute("idCar", id);
            request.getSession().setAttribute("day", day);
            return FORM_FILLING_USER_PAGE;
        }
//        TableCar.createTableCarForUser(request);
//        return BOOKING_NOT_AVAILABLE_TRY_AGAIN_PAGE;
    }

    private void getUser(HttpServletRequest request, int idCar, int day) {
        UserDAO userDAO = UserDAO.getInstance();
        String email = (String) request.getSession().getAttribute("email");
        request.getSession().setAttribute("email", email);
        int id = userDAO.getIdUser(email);
        User u = userDAO.getById(id);
        Car car = CarDAO.getInstance().getById(idCar);
        request.setAttribute("fname", u.getFname());
        request.setAttribute("lname", u.getLname());
        request.setAttribute("email", u.getEmail());
        request.setAttribute("age", u.getAge());
        request.setAttribute("phone", u.getPhone());
        request.setAttribute("car", car.getBrand() + " " + car.getMake());
        request.setAttribute("sum", car.getPrice() * day);
    }
}

