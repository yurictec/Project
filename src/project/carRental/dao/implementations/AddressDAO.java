package project.carRental.dao.implementations;

import org.apache.log4j.Level;
import project.carRental.container.Container;
import project.carRental.dao.abstracts.AbstractDAO;
import project.carRental.dao.interfaces.IAddressDAO;
import project.carRental.entity.Address;
import project.carRental.propertiesManagers.CommandSQLManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Yuriy Kolennikov
 */

public class AddressDAO extends AbstractDAO implements IAddressDAO {

    /**
     * This is implementation Singleton-pattern
     */
    private AddressDAO() {
    }

    private static class AddressDAOHolder {
        private static final AddressDAO ADDRESS_DAO = new AddressDAO();
    }

    public static AddressDAO getInstance() {
        return AddressDAOHolder.ADDRESS_DAO;
    }

    /**
     * Initialization
     *
     * @return initialization address
     */
    private Container setEntity(ResultSet rs) {
        Container<Address> container = new Container<>(new ArrayList<>());
        UserDAO userDAO = UserDAO.getInstance();
        try {
            while (rs.next()) {
                Address address = new Address();
                address.setId(rs.getInt(1));
                address.setUser(userDAO.getById(rs.getInt(2)));
                address.setCountry(rs.getString(3));
                address.setCity(rs.getString(4));
                address.setStreet(rs.getString(5));
                container.add(address);
            }
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR AddressDAO setEntity SQL", ex);
        }
        return container;
    }

    /**
     * This method return the container of addresses of users
     *
     * @return container of addresses
     */
    @Override
    public Container<Address> getAll() {
        Container<Address> container = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager
                    .getInstance().getProperty("GET_ADDRESS_ALL"));
            rs = ps.executeQuery();
            container = setEntity(rs);
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR AddressDAO getAll", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return container;
    }

    /**
     * This method return the address of user by id
     *
     * @param id id to select
     * @return address
     */
    @Override
    public Address getById(int id) {
        Address address = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager
                    .getInstance().getProperty("GET_ADDRESS_BY_ID"));
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Container container = setEntity(rs);
            if (container.getLenght() > 0) {
                address = (Address) container.getEntity();
            }
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR AddressDAO getById SQL", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return address;
    }

}
