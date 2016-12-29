package project.carRental.propertiesManagers;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import static java.util.ResourceBundle.getBundle;
import static project.carRental.constantPages.ConstantPage.COMMAND_SQL_FILE;

public class CommandSQLManager {

    private ResourceBundle bundle;
    private static CommandSQLManager instance;
    protected static Logger l = Logger.getLogger(CommandSQLManager.class.getName());

    public static CommandSQLManager getInstance() {
        if (instance == null) {
            instance = new CommandSQLManager();
        }
        instance.bundle = getBundle(COMMAND_SQL_FILE);
        return instance;
    }

    /**
     * This method return command for MySQL
     *
     * @return command
     */
    public String getProperty(String key) {
        String s = null;
        try {
            s = (String) bundle.getObject(key);
        } catch (MissingResourceException ex) {
            l.log(Level.ERROR, "ERROR CommandSQLManager getProperty", ex);
        }
        return s;
    }
}
