package project.carRental.dao.implementations;

import org.apache.log4j.Level;
import project.carRental.dao.abstracts.AbstractDAO;
import project.carRental.dao.interfaces.IOrderDAO;
import project.carRental.container.Container;
import project.carRental.entity.Order;
import project.carRental.propertiesManagers.CommandSQLManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Yuriy Kolennikov
 */

public class OrderDAO extends AbstractDAO implements IOrderDAO {

    /**
     * This is implementation Singleton-pattern
     */
    private OrderDAO() {

    }

    private static class OrderDAOHolder {
        private static final OrderDAO ORDER_DAO = new OrderDAO();
    }

    public static OrderDAO getInstance() {
        return OrderDAOHolder.ORDER_DAO;
    }

    /**
     * Initialization
     *
     * @return initialized orders
     */
    private Container<Order> setEntity(ResultSet rs) {
        Container<Order> container = new Container(new ArrayList<>());
        try {
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt(1));
                order.setCarBrand(rs.getString(2));
                order.setCarMake(rs.getString(3));
                order.setfNameUser(rs.getString(4));
                order.setlNameUser(rs.getString(5));
                order.setData(rs.getInt(6));
                order.setSum(rs.getInt(7) * rs.getInt(6));
                order.setStat(rs.getString(8));
                order.setPay(rs.getString(9));
                container.add(order);
            }
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR OrderDAO setEntity SQL", ex);
        }
        return container;
    }

    /**
     * This method return the container of orders
     *
     * @return container of orders
     */
    @Override
    public Container<Order> getAll() {
        Container<Order> container = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("GET_ORDER_ALL"));
            rs = ps.executeQuery();
            container = setEntity(rs);
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR OrderDAO getAll SQL", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return container;
    }

    /**
     * This method return the order by id
     *
     * @param id id to select
     * @return order
     */
    @Override
    public Order getById(int id) {
        Order order = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("GET_ORDER_BY_ID"));
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Container<Order> container = setEntity(rs);
            if (container.getLenght() > 0) {
                order = container.getEntity();
            }
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR OrderDAO getById SQL", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return order;
    }

    /**
     * This method create the order
     *
     * @return number of updated rows
     */
    @Override
    public int creatOrder(int carId, int userId, int date, int price, String stat, String pay) {
        Connection connection = null;
        PreparedStatement ps = null;
        int mod = 0;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("INSERT_NEW_ORDER"));
            ps.setInt(1, carId);
            ps.setInt(2, userId);
            ps.setInt(3, date);
            ps.setInt(4, (price * date));
            ps.setString(5, stat);
            ps.setString(6, pay);
            mod = ps.executeUpdate();
        } catch (SQLException ex) {
            l.log(Level.ERROR, "OrderDAO creatOrder", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
        }
        return mod;
    }

    /**
     * This method return id order
     *
     * @return id order
     */
    @Override
    public int getIdOrder(int idcar, int iduser, int date) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = 0;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("GET_ID_ORDER"));
            ps.setInt(1, idcar);
            ps.setInt(2, iduser);
            ps.setInt(3, date);
            rs = ps.executeQuery();
            Container<Order> c = setEntity(rs);
            if (c.getLenght() > 0) {
                Order order = c.getEntity();
                id = order.getId();
            }
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR UserDAO getIdOrder SQL", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return id;
    }

    /**
     * This method returns a container of order by id user
     *
     * @return container orders
     */
    @Override
    public Container<Order> getAllByIdUser(int idUser) {
        Container<Order> container = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("GET_ORDER_ALL_BY_ID"));
            ps.setInt(1, idUser);
            rs = ps.executeQuery();
            container = setEntity(rs);
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR OrderDAO getAllById SQL", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return container;
    }

    /**
     * This method returns a container of order by status processing
     *
     * @return container orders
     */
    @Override
    public Container getAllByProcessing() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Container container = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("GET_ORDER_BY_PROCESSING"));
            rs = ps.executeQuery();
            container = setEntity(rs);
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR OrderDAO getAllByProcessing SQL", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return container;
    }

    /**
     * This method update the information about order
     *
     * @param order order
     * @return number of updated rows
     */
    @Override
    public int update(Order order) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int mod = -1;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("UPDATE_ORDER"));
            preparedStatement.setString(1, order.getStat());
            preparedStatement.setInt(2, order.getId());
            mod = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            l.log(Level.ERROR, "ERROR OrderDAO update", e);
        } finally {
            closeConn(connection);
            closePreparedStatement(preparedStatement);
        }
        return mod;
    }

    /**
     * This method updates the information on the payment order
     *
     * @return number of updated rows
     * @params idOrder int pay string
     */
    @Override
    public int pay(int idOrder, String pay) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int mod = -1;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("UPDATE_PAY_ORDER"));
            preparedStatement.setString(1, pay);
            preparedStatement.setInt(2, idOrder);
            mod = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            l.log(Level.ERROR, "ERROR OrderDAO pay", e);
        } finally {
            closeConn(connection);
            closePreparedStatement(preparedStatement);
        }
        return mod;
    }

    public int deleteOrder(int idOrder) {
        int mod = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("DELETE_ORDER"));
            ps.setInt(1, idOrder);
            mod = ps.executeUpdate();
        } catch (SQLException e) {
            l.log(Level.ERROR, "ERROR OrderDAO deleteOrder", e);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
        }
        return mod;
    }
}
