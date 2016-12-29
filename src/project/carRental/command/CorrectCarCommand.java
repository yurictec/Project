package project.carRental.command;

import project.carRental.constantPages.ConstantPage;
import project.carRental.dao.implementations.CarDAO;
import project.carRental.entity.Car;
import project.carRental.utils.TableCar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yuriy Kolennikov
 */

public class CorrectCarCommand implements Command {

    @Override
    public String exequte(HttpServletRequest request, HttpServletResponse response) {
        String brand = request.getParameter("pw1");
        String make = request.getParameter("pw2");
        String stat = request.getParameter("pw4");

        int price = Integer.parseInt(request.getParameter("pw5"));
        int carId = (int) request.getSession().getAttribute("carCorr");

        CarDAO carDAO = CarDAO.getInstance();
        Car car = new Car(carId, brand, make, stat, price);

        int mod = carDAO.update(car);
        if (mod == 0) {
            return ConstantPage.ERROR_PAGE;
        }

        TableCar.createTableCarForAdmin(request);
        return ConstantPage.ADMIN_PAGE;
    }
}
