package project.carRental.services;

import project.carRental.constantPages.ConstantPage;
import project.carRental.dao.implementations.CarDAO;
import project.carRental.entity.Car;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Yuriy kolennikov
 */

public class Admin {

    public String getDataCar(HttpServletRequest request, int idCar) {
        CarDAO carDAO = CarDAO.getInstance();
        Car car = carDAO.getById(idCar);
        if (car == null) {
            return ConstantPage.ERROR_PAGE;
        }
        request.setAttribute("brand", car.getBrand());
        request.setAttribute("make", car.getMake());
        request.setAttribute("equipment", car.getEquipment());
        request.setAttribute("stat", car.getStat());
        request.setAttribute("price", car.getPrice());
        request.getSession().setAttribute("carCorr", car.getId());
        return ConstantPage.FORM_FILLING_ADMIN_PAGE;
    }
}
