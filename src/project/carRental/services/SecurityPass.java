package project.carRental.services;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Администратор on 28.12.2016.
 */
public class SecurityPass {

    private static final Logger LOGGER = Logger.getLogger(Security.class.getName());

    public static String passCrypt(String pass) {
        String passCrypt = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(pass.getBytes(), 0, pass.length());
            passCrypt = new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.log(Level.ERROR, "ERROR createUser passCrypt", e);
        }
        if (passCrypt != null) {
            return passCrypt;
        }
        return passCrypt(pass);
    }
}
