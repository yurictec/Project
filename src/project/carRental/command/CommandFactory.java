package project.carRental.command;

import project.carRental.services.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yuriy Kolennikov
 */

public class CommandFactory {

    private final Map<String, Command> map = new HashMap<>();


    private CommandFactory() {
        map.put("LOGIN", new LoginCommand(new Security()));
        map.put("REGISTRATION", new RegistrationCommand());
        map.put("BOOKING", new BookingCommand(new Booking()));
        map.put("FORMFILLING", new FormFillingCommand());
        map.put("ADMINSERVICE", new AdminCommand());
        map.put("CONTINUE", new EndWorkCommand());
        map.put("FORMFILLINGCAR", new CorrectCarCommand());
        map.put("MYACCOUNT", new AccountCommand());
        map.put("MANAGERCORRECT", new ManagerCorrectCommand());
        map.put("CHANGESTATUS", new ChangeStatusCommand());
        map.put("PAYMENT", new PaymentCommand());
    }

    /**
     * This is a the part of implementation
     * Singleton-pattern
     */
    private static class CommandFactoryHolder {
        private static final CommandFactory FACTORY = new CommandFactory();
    }

    public static CommandFactory getInstance() {
        return CommandFactoryHolder.FACTORY;
    }

    public Command getCommand(String key) {
        return map.get(key.toUpperCase());
    }
}

