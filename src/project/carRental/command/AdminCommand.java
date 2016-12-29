package project.carRental.command;

import project.carRental.services.Admin;
import project.carRental.utils.TableCar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static project.carRental.constantPages.ConstantPage.ADMIN_PAGE;

/**
 * Created by Yuriy Kolennikov
 */

public class AdminCommand implements Command {

    private Admin admin;

    /**
     * @param admin admin
     */
    AdminCommand(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String exequte(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("carCorr");
        if (id != null) {
            int idCar = Integer.parseInt(id);
            return admin.getDataCar(request, idCar);
        }
        TableCar.createTableCarForAdmin(request);
        return ADMIN_PAGE;
    }
}
