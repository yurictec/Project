package project.carRental.dao.implementations;

import org.apache.log4j.Level;
import project.carRental.container.Container;
import project.carRental.dao.abstracts.AbstractDAO;
import project.carRental.dao.interfaces.ICarDAO;
import project.carRental.entity.Car;
import project.carRental.propertiesManagers.CommandSQLManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Yuriy Kolennikov
 */

public class CarDAO extends AbstractDAO implements ICarDAO {

    /**
     * This is implementation Singleton-pattern
     */
    private CarDAO() {
    }

    private static class CarDAOHolder {
        private static final CarDAO CAR_DAO = new CarDAO();
    }

    public static CarDAO getInstance() {
        return CarDAOHolder.CAR_DAO;
    }

    /**
     * Initialization
     *
     * @return initialized car
     */
    private Container<Car> setEntity(ResultSet rs) {
        Container<Car> container = new Container(new ArrayList<>());
        EquipmentDAO equipmentDAO = EquipmentDAO.getInstance();
        try {
            while (rs.next()) {
                Car car = new Car();
                car.setId(rs.getInt(1));
                car.setEquipment(equipmentDAO.getById(rs.getInt(2)));
                car.setBrand(rs.getString(3));
                car.setMake(rs.getString(4));
                car.setStat(rs.getString(5));
                car.setPrice(rs.getInt(6));
                container.add(car);
            }

        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR CarDAO setEntity SQL", ex);
        }
        return container;
    }

    /**
     * This method return the container of cars
     *
     * @return container of cars
     */
    @Override
    public Container<Car> getAll() {
        Container<Car> container = null;
        Connection connection = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("GET_CAR_ALL"));
            rs = ps.executeQuery();
            container = setEntity(rs);
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR CarDAO getAll SQL", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return container;
    }

    /**
     * This method return the car by id
     *
     * @param id id to select
     * @return car
     */
    @Override
    public Car getById(int id) {
        Car car = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("GET_CAR_BY_ID"));
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Container<Car> container = setEntity(rs);
            if (container.getLenght() > 0) {
                car = container.getEntity();
            }
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR CarDAO getById SQL", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return car;
    }

    /**
     * This method updates the state of the car
     *
     * @param id int stat string
     * @return number of updated rows
     */
    @Override
    public int updateStat(int id, String stat) {
        int mod = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("UPDATE_CAR_STAT"));
            ps.setString(1, stat);
            ps.setInt(2, id);
            mod = ps.executeUpdate();
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR CarDAO updateStat", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
        }
        return mod;
    }

    /**
     * This method returns the container available cars
     *
     * @return container of cars
     */
    @Override
    public Container getActivCars() {
        Connection connection = null;
        Container container = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("GET_ACTIV_CARS"));
            rs = ps.executeQuery();
            container = setEntity(rs);
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR CarDAO getAll SQL", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return container;
    }

    /**
     * This method update the information about car
     *
     * @param car car
     * @return number of updated rows
     */
    @Override
    public int update(Car car) {
        Connection connection = null;
        PreparedStatement ps = null;
        int mod = 0;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("UPDATE_CAR"));
            ps.setString(1, car.getBrand());
            ps.setString(2, car.getMake());
            ps.setString(3, car.getStat());
            ps.setInt(4, car.getPrice());
            ps.setInt(5, car.getId());
            mod = ps.executeUpdate();
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR CarDAO update", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
        }
        return mod;
    }
}
