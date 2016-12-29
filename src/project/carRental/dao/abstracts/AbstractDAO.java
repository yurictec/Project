package project.carRental.dao.abstracts;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import project.carRental.connection.DBPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Yuriy Kolennikov
 */

public class AbstractDAO {

    protected static Logger l = Logger.getLogger(AbstractDAO.class.getName());
    private final DBPool instance = DBPool.getInstance();

    /**
     * This method get connection from pool
     *
     * @return connection
     */
    protected Connection getConnection() {
        return instance.getConnection();
    }

    /**
     * This method return connection to databasePool
     *
     * @param connection connection to return
     */
    protected void closeConn(Connection connection) {
        instance.release(connection);
    }

    /**
     * This method close preparedStatement
     *
     * @param preparedStatement preparedStatement
     */
    protected void closePreparedStatement(PreparedStatement preparedStatement) {
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            l.log(Level.ERROR, "ERROR closePreparedStatement", e);
        }
    }

    /**
     * This method close resultSet
     *
     * @param resultSet resultSet
     */
    protected void closeResultSet(ResultSet resultSet) {
        try {
            resultSet.close();
        } catch (SQLException e) {
            l.log(Level.ERROR, "ERROR closePreparedStatement", e);
        }
    }
}
