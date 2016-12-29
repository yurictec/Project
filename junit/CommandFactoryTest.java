package junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project.carRental.command.Command;
import project.carRental.command.CommandFactory;

import static org.junit.Assert.*;

/**
 * @author Yuriy Kolennikov
 */

public class CommandFactoryTest {

    private CommandFactory commandFactory;
    private Command cmd1;
    private Command cmd2;
    private Command cmd3;
    private Command cmd4;
    private Command cmd5;
    private Command cmd6;
    private Command cmd7;
    private Command cmd8;
    private Command cmd9;
    private Command cmd10;
    private Command cmd11;


    @Before
    public void setUp() throws Exception {

        commandFactory = CommandFactory.getInstance();

        cmd1 = commandFactory.getCommand("LOGIN");
        cmd2 = commandFactory.getCommand("REGISTRATION");
        cmd3 = commandFactory.getCommand("BOOKING");
        cmd4 = commandFactory.getCommand("FORMFILLING");
        cmd5 = commandFactory.getCommand("ADMINSERVICE");
        cmd6 = commandFactory.getCommand("CONTINUE");
        cmd7 = commandFactory.getCommand("FORMFILLINGCAR");
        cmd8 = commandFactory.getCommand("MYACCOUNT");
        cmd9 = commandFactory.getCommand("MANAGERCORRECT");
        cmd10 = commandFactory.getCommand("CHANGESTATUS");
        cmd11 = commandFactory.getCommand("PAYMENT");
    }

    @After
    public void tearDown() throws Exception {

        commandFactory = null;

        cmd1 = null;
        cmd2 = null;
        cmd3 = null;
        cmd4 = null;
        cmd5 = null;
        cmd6 = null;
        cmd7 = null;
        cmd8 = null;
        cmd9 = null;
        cmd10 = null;
        cmd11 = null;
    }

    @Test
    public void getInstance() throws Exception {

        CommandFactory factory = CommandFactory.getInstance();

        assertEquals(factory, commandFactory);
    }

    @Test
    public void getCommand() throws Exception {

        Command command1 = CommandFactory.getInstance().getCommand("LOGIN");
        Command command2 =CommandFactory.getInstance().getCommand("REGISTRATION");
        Command command3 =CommandFactory.getInstance().getCommand("BOOKING");
        Command command4 =CommandFactory.getInstance().getCommand("FORMFILLING");
        Command command5 =CommandFactory.getInstance().getCommand("ADMINSERVICE");
        Command command6 =CommandFactory.getInstance().getCommand("CONTINUE");
        Command command7 =CommandFactory.getInstance().getCommand("FORMFILLINGCAR");
        Command command8 =CommandFactory.getInstance().getCommand("MYACCOUNT");
        Command command9 =CommandFactory.getInstance().getCommand("MANAGERCORRECT");
        Command command10 =CommandFactory.getInstance().getCommand("CHANGESTATUS");
        Command command11 =CommandFactory.getInstance().getCommand("PAYMENT");

        assertEquals(command1, cmd1);
        assertEquals(command2, cmd2);
        assertEquals(command3, cmd3);
        assertEquals(command4, cmd4);
        assertEquals(command5, cmd5);
        assertEquals(command6, cmd6);
        assertEquals(command7, cmd7);
        assertEquals(command8, cmd8);
        assertEquals(command9, cmd9);
        assertEquals(command10, cmd10);
        assertEquals(command11, cmd11);

    }
}