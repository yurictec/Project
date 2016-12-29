package project.carRental.command;

import project.carRental.services.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static project.carRental.constantPages.ConstantPage.LOGIN_PAGE;

/**
 * Created by Yuriy Kolennikov
 */

public class AccountCommand implements Command {
    private Account account;

    AccountCommand(Account account) {
        this.account = account;
    }

    @Override
    public String exequte(HttpServletRequest request, HttpServletResponse response) {
        String email = (String) request.getSession().getAttribute("email");
        if (email == null) {
            return LOGIN_PAGE;
        }
        return account.getOrderByUser(request, email);
    }
}
