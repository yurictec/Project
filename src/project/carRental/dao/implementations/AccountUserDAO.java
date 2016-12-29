package project.carRental.dao.implementations;

import org.apache.log4j.Level;
import project.carRental.container.Container;
import project.carRental.dao.abstracts.AbstractDAO;
import project.carRental.dao.interfaces.IAccountUserDAO;
import project.carRental.entity.AccountUser;
import project.carRental.propertiesManagers.CommandSQLManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountUserDAO extends AbstractDAO implements IAccountUserDAO {

    /**
     * This is implementation Singleton-pattern
     */
    private AccountUserDAO() {
    }

    private static class AccountUserDAOHolder {
        private static final AccountUserDAO ACCOUNT_USER_DAO = new AccountUserDAO();
    }

    public static AccountUserDAO getInstance() {
        return AccountUserDAOHolder.ACCOUNT_USER_DAO;
    }

    /**
     * Initialization
     *
     * @return initialized accountUser
     */
    private Container<AccountUser> setEntity(ResultSet rs) {
        Container<AccountUser> container = new Container(new ArrayList<AccountUser>());
        UserDAO userDAO = UserDAO.getInstance();
        try {
            while (rs.next()) {
                AccountUser au = new AccountUser();
                au.setId(rs.getInt(1));
                au.setUser(userDAO.getById(rs.getInt(2)));
                au.setNumberAccount(rs.getString(3));
                au.setStat(rs.getString(4));
                container.add(au);
            }
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR AccountUserDAO setEntity SQL", ex);
        }
        return container;
    }

    /**
     * This method return the container of accounts of users
     *
     * @return container of accountuser
     */
    @Override
    public Container<AccountUser> getAll() {
        Container<AccountUser> container = null;
        Connection connection = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager
                    .getInstance().getProperty("GET_ACCOUNT_ALL"));
            rs = ps.executeQuery();
            container = setEntity(rs);
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR AccountUserDAO getAll SQL", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return container;
    }

    /**
     * This method return the account of user by id
     *
     * @param id id to select
     * @return accoutnsUser
     */
    @Override
    public AccountUser getById(int id) {
        AccountUser accountUser = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager
                    .getInstance().getProperty("GET_ACCOUNT_BY_ID"));
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Container<AccountUser> container = setEntity(rs);
            if (container.getLenght() > 0) {
                accountUser = container.getEntity();
            }
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR AccountUserDAO getById SQL", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return accountUser;
    }
}

