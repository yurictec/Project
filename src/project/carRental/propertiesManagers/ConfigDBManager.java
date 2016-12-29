package project.carRental.propertiesManagers;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import static java.util.ResourceBundle.getBundle;
import static project.carRental.constantPages.ConstantPage.CONFIG_DB_FILE;

/**
 * @author Yuriy Kolennikov
 */

public class ConfigDBManager {

    private ResourceBundle bundle;
    private static ConfigDBManager instance;
    protected static Logger l = Logger.getLogger(ConfigDBManager.class.getName());

    public static ConfigDBManager getInstanse() {
        if (instance == null) {
            instance = new ConfigDBManager();
        }
        instance.bundle = getBundle(CONFIG_DB_FILE);
        return instance;
    }

    /**
     * This method return command for DBPool
     *
     * @return command
     */
    public String getProperty(String key) {
        String s = null;
        try {
            s = (String) bundle.getObject(key);
        } catch (MissingResourceException exception) {
            l.log(Level.ERROR, "ERROR ConfigDBManager getProperty Missing", exception);
        }
        return s;
    }
}
