package project.carRental.controller;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import project.carRental.command.Command;
import project.carRental.command.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This is main servlet
 *
 * @author Yuriy Kolennikov
 */

public class Controller extends javax.servlet.http.HttpServlet {

    private static Logger logger = Logger.getLogger(Controller.class.getName());

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest(request, response);
//        HttpSession session = request.getSession(true);
//        String sid = (String) session.getAttribute("sid");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        //initializing variable
        String page;
        CommandFactory factory = CommandFactory.getInstance();
        String cmd = request.getParameter("cmd").toUpperCase();

        Command command = factory.getCommand(cmd);
        page = command.exequte(request, response);
        try {
            request.getRequestDispatcher(page).forward(request, response);
        } catch (ServletException e) {
            logger.log(Level.ERROR, "Controller if() ServletEx", e);
        } catch (IOException e) {
            logger.log(Level.ERROR, "Controller if() IOEx", e);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
