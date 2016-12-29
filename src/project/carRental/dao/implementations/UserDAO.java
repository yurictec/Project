package project.carRental.dao.implementations;

import org.apache.log4j.Level;
import project.carRental.container.Container;
import project.carRental.dao.abstracts.AbstractDAO;
import project.carRental.entity.User;
import project.carRental.propertiesManagers.CommandSQLManager;
import project.carRental.dao.interfaces.IUserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Yuriy Kolennikov
 */

public class UserDAO extends AbstractDAO implements IUserDAO {

    /**
     * This is implementation Singleton-pattern
     */
    private UserDAO() {
    }

    private static class UserDAOHolder {
        private static final UserDAO USER_DAO = new UserDAO();
    }

    public static UserDAO getInstance() {
        return UserDAOHolder.USER_DAO;
    }

    /**
     * Initialization
     *
     * @return initialized user
     */
    private Container<User> setEntity(ResultSet rs) {
        Container<User> container = new Container(new ArrayList<>());
        RoleDAO roleDAO = RoleDAO.getInstance();
        try {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setRole(roleDAO.getById(rs.getInt(2)));
                user.setEmail(rs.getString(3));
                user.setPassword(rs.getString(4));
                user.setFname(rs.getString(5));
                user.setLname(rs.getString(6));
                user.setAge(rs.getString(7));
                user.setPhone(rs.getString(8));
                container.add(user);
            }
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR UserDAO setEntity SQL", ex);
        }
        return container;
    }

    /**
     * This method return the container of users
     *
     * @return container of users
     */
    @Override
    public Container<User> getAll() {
        Container<User> container = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("GET_USER_ALL"));
            rs = ps.executeQuery();
            container = setEntity(rs);
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR UserDAO getAll SQL", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return container;
    }

    /**
     * This method return the user by id
     *
     * @param id id to select
     * @return user
     */
    @Override
    public User getById(int id) {
        User user = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("GET_USER_BY_ID"));
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Container<User> container = setEntity(rs);
            if (container.getLenght() > 0) {
                user = container.getEntity();
            }
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR UserDAO getById SQL", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return user;
    }

    /**
     * This method return the user by email and pass
     *
     * @param email string password string
     * @return user
     */
    @Override
    public User getLoginAndPassword(String email, String password) {
        User user = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("GET_BY_LOGIN_AND_PASS"));
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            Container<User> container = setEntity(rs);
            if (container.getLenght() > 0) {
                user = container.getEntity();
            }
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR UserDAO getLoginAndPass SQL", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return user;
    }

    /**
     * This method create new user
     *
     * @param user user
     */
    @Override
    public int insert(User user) {
        Connection connection = null;
        PreparedStatement ps = null;
        int mod = 0;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("INSERT_USER"));
            ps.setInt(1, user.getRole().getId());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getFname());
            ps.setString(5, user.getLname());
            ps.setString(6, user.getAge());
            ps.setString(7, user.getPhone());
            mod = ps.executeUpdate();
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR UserDAO update", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
        }
        return mod;
    }

    /**
     * This method return the user by email
     *
     * @param email string
     * @return user
     */
    @Override
    public User getUserByEmail(String email) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("GET_EMAIL"));
            ps.setString(1, email);
            rs = ps.executeQuery();
            Container<User> container = setEntity(rs);
            if (container.getLenght() > 0) {
                u = container.getEntity();
            }
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR getUserByEmail", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return u;
    }

    /**
     * This method return id user by email
     *
     * @param email string
     * @return id user
     */
    @Override
    public int getIdUser(String email) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = 0;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("GET_ID_USER"));
            ps.setString(1, email);
            rs = ps.executeQuery();
            Container<User> c = setEntity(rs);
            if (c != null) {
                User user = c.getEntity();
                id = user.getId();
            }
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR UserDAO getById SQL", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return id;
    }

    /**
     * This method update information about user
     *
     * @param user user
     */
    @Override
    public int update(User user) {
        Connection connection = null;
        PreparedStatement ps = null;
        int mod = 0;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("UPDATE_USER"));
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getFname());
            ps.setString(3, user.getLname());
            ps.setString(4, user.getAge());
            ps.setString(5, user.getPhone());
            ps.setInt(6, user.getId());
            mod = ps.executeUpdate();
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR UserDAO update", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
        }
        return mod;
    }

    public int delete(int idUser) {
        int mod = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("DELETE_USER"));
            ps.setInt(1, idUser);
            mod = ps.executeUpdate();
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR UserDAO delete", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
        }
        return mod;
    }
}
