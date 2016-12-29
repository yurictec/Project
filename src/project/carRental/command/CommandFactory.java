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
        map.put("REGISTRATION", new RegistrationCommand(new Registration()));
        map.put("BOOKING", new BookingCommand(new Booking()));
        map.put("FORMFILLING", new FormFillingCommand(new FormFilling()));
        map.put("ADMINSERVICE", new AdminCommand(new Admin()));
        map.put("CONTINUE", new EndWorkCommand(new EndWork()));
        map.put("FORMFILLINGCAR", new CorrectCarCommand(new CorrectCar()));
        map.put("MYACCOUNT", new AccountCommand(new Account()));
        map.put("MANAGERCORRECT", new ManagerCorrectCommand(new ManagerCorrect()));
        map.put("CHANGESTATUS", new ChangeStatusCommand(new ChangeStatus()));
        map.put("PAYMENT", new PaymentCommand(new Payment()));
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

