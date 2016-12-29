package project.carRental.utils;

import project.carRental.container.Container;
import project.carRental.dao.implementations.CarDAO;
import project.carRental.dao.implementations.OrderDAO;
import project.carRental.entity.Car;
import project.carRental.entity.Order;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuriy Kolennikov
 */

public class TableCar {
    public static void createTableCarForUser(HttpServletRequest request) {
        Container c = CarDAO.getInstance().getActivCars();
        List<Car> carlist = new ArrayList<>();
        Car car;
        for (int i = 0; i < c.getLenght(); i++) {
            car = (Car) c.getEntity();
            carlist.add(car);
        }
        request.setAttribute("userList", carlist);
    }

    public static void createTableCarForAdmin(HttpServletRequest request) {
        Container<Car> c = CarDAO.getInstance().getAll();
        List<Car> carlist = new ArrayList<>();
        Car car;
        for (int i = 0; i < c.getLenght(); i++) {
            car = c.getEntity();
            carlist.add(car);
        }
        request.setAttribute("adminList", carlist);
    }

    public static int createTableOrderForManager(HttpServletRequest request) {
        Container c = OrderDAO.getInstance().getAllByProcessing();
        List<Order> orderList = new ArrayList<>();
        Order order;
        for (int i = 0; i < c.getLenght(); i++) {
            order = (Order) c.getEntity();
            orderList.add(order);
        }
        request.setAttribute("managerList", orderList);
        return orderList.size();
    }
}
