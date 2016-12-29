package project.carRental.command;

import project.carRental.services.CorrectCar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yuriy Kolennikov
 */

public class CorrectCarCommand implements Command {

    private CorrectCar correctCar;

    CorrectCarCommand(CorrectCar correctCar) {
        this.correctCar = correctCar;
    }

    @Override
    public String exequte(HttpServletRequest request, HttpServletResponse response) {
        String brand = request.getParameter("pw1");
        String make = request.getParameter("pw2");
        String equipment = request.getParameter("pw3");
        String stat = request.getParameter("pw4");
        int price = Integer.parseInt(request.getParameter("pw5"));
        int carId = (int) request.getSession().getAttribute("carCorr");
        return correctCar.correct(carId, brand, make, stat, price, request);
    }
}
