package project.carRental.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yuriy Kolennikov
 */

public interface Command {
    String exequte(HttpServletRequest request, HttpServletResponse response);
}
