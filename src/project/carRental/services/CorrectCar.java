package project.carRental.services;

import project.carRental.constantPages.ConstantPage;
import project.carRental.dao.implementations.CarDAO;
import project.carRental.entity.Car;
import project.carRental.utils.TableCar;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Yuriy kolennikov
 */

public class CorrectCar {

    public String correct(int carId, String brand, String make, String stat, int price, HttpServletRequest request) {
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
