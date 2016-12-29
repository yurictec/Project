package project.carRental.command;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import project.carRental.constantPages.ConstantPage;
import project.carRental.services.Booking;
import project.carRental.utils.TableCar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;

/**
 * Created by Yuriy Kolennikov
 */

public class BookingCommand implements Command {

    private static Logger log = Logger.getLogger(Booking.class.getName());
    private Booking b = null;

    BookingCommand(Booking b) {
        this.b = b;
    }

    @Override
    public String exequte(HttpServletRequest request, HttpServletResponse response) {
        String car = request.getParameter("car");
        if (car == null) {
            TableCar.createTableCarForUser(request);
            return ConstantPage.BOOKING_PAGE;
        }
        int idCar = Integer.parseInt(car);

        String start = request.getParameter("start");
        String end = request.getParameter("end");
        if (start.equals("2015-01-01") && end.equals("2015-01-01")) {
            TableCar.createTableCarForUser(request);
            return ConstantPage.BOOKING_PAGE;
        }
        request.setAttribute("start", start);
        request.setAttribute("end", end);

        int days = quantityDay(start, end);
        try {
            if (idCar > 0 & days > 0) {
                return b.booking(idCar, days, request);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            log.log(Level.ERROR, "ERROR BookingCommand exequte", ex);
        }
        TableCar.createTableCarForUser(request);
        return ConstantPage.BOOKING_ERROR_TRY_AGAIN_PAGE;
    }

    /**
     * This method return the number of days that the user has select
     *
     * @return number of days
     * @params start string, end string
     */

    private int quantityDay(String start, String end) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date start2 = null;
        java.util.Date end2 = null;
        try {
            start2 = format.parse(start);
            end2 = format.parse(end);
            if (start2 == null && end2 == null) {
                return 0;
            }
        } catch (Exception e) {
            log.log(Level.ERROR, "ERROR BookingCommand exequte DATE", e);
        }
        assert end2 != null;
        assert start2 != null;
        long difference = end2.getTime() - start2.getTime();

        return (int) difference / (24 * 60 * 60 * 1000);
    }
}
