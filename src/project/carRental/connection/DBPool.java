package project.carRental.connection;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import project.carRental.propertiesManagers.ConfigDBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * This pool is implemented to study
 * the principle of connection pooling
 *
 * @author Yuriy Kolennikov
 */

public class DBPool {

    private static final DBPool INSTANCE = new DBPool();
    private static LinkedBlockingDeque<Connection> connections = new LinkedBlockingDeque<>();
    private final static int SIZE_DB_POOL = 50;
    protected static Logger l = Logger.getLogger(DBPool.class.getName());
    private int count = 0;

    /**
     * Singltone -Traditional simple way
     */
    private DBPool() {
    }

    public static DBPool getInstance() {
        return INSTANCE;
    }

    /**
     * This method create new connection and return it
     *
     * @return new ConnectionWrapper
     */
    private Connection createConnection() {
        try {
            return DriverManager.getConnection(
                    ConfigDBManager.getInstanse().getProperty("URL"),
                    ConfigDBManager.getInstanse().getProperty("LOGIN"),
                    ConfigDBManager.getInstanse().getProperty("PASS"));
        } catch (SQLException exception) {
            l.log(Level.ERROR, "Error DBPool createConnection", exception);
        }
        return null;
    }

    /**
     * This method initialize the pool
     */
    private void preparationPool() {
        try {
            Class.forName(ConfigDBManager.getInstanse().getProperty("DB_DRIVER"));
        } catch (ClassNotFoundException exception) {
            l.log(Level.ERROR, "Error DBPool preparationPool", exception);
        }
        for (int i = 0; i < SIZE_DB_POOL; i++) {
            connections.add(createConnection());
        }
        ++count;
    }

    /**
     * Getting free connection from pool
     *
     * @return connection from pool
     */
    public Connection getConnection() {
        if(count == 0){
            preparationPool();
        }
        try {
            Connection c = connections.poll(500, TimeUnit.MILLISECONDS);
            if ( null == c) {
                connections.add(createConnection());
                c = connections.poll();
            }
            return c;
        } catch (InterruptedException exception) {
            l.log(Level.ERROR, "Error DBPool getConnection", exception);
        }
        return getConnection();
    }

    /**
     * Return connection to pool
     *
     * @param connection connection to close
     */
    public void release(Connection connection) {
        try {
        if (!connection.isClosed()) {
            connections.add(connection);
        } else {
            connections.add(createConnection());
        }
        } catch (SQLException exception) {
            l.log(Level.ERROR, "ERROR DBPool release", exception);
        }
    }
}
