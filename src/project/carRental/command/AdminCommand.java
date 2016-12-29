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

public class AdminCommand implements Command {

    @Override
    public String exequte(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("carCorr");
        if (id != null) {
            int idCar = Integer.parseInt(id);
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
        TableCar.createTableCarForAdmin(request);
        return ConstantPage.ADMIN_PAGE;
    }
}
