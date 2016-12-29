package project.carRental.dao.implementations;

import org.apache.log4j.Level;
import project.carRental.container.Container;
import project.carRental.dao.abstracts.AbstractDAO;
import project.carRental.dao.interfaces.IRoleDAO;
import project.carRental.entity.Role;
import project.carRental.propertiesManagers.CommandSQLManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Yuriy Kolennikov
 */

public class RoleDAO extends AbstractDAO implements IRoleDAO {

    /**
     * This is implementation Singleton-pattern
     */
    private RoleDAO() {
    }

    private static class RoleDAOHolder {
        private static final RoleDAO ROLE_DAO = new RoleDAO();
    }

    public static RoleDAO getInstance() {
        return RoleDAOHolder.ROLE_DAO;
    }

    /**
     * Initialization
     *
     * @return initialized role
     */
    private Container<Role> setEntity(ResultSet rs) {
        Container<Role> container = new Container(new ArrayList<>());
        try {
            while (rs.next()) {
                Role r = new Role();
                r.setId(rs.getInt(1));
                r.setRole(rs.getString(2));
                container.add(r);
            }
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR RoleDAO setEntity SQL", ex);
        }
        return container;
    }

    /**
     * This method return the container of roles
     *
     * @return container of roles
     */
    @Override
    public Container<Role> getAll() {
        Container<Role> container = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("GET_ROLE_ALL"));
            rs = ps.executeQuery();
            container = setEntity(rs);
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR RoleDAO getAll SQL", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return container;
    }

    /**
     * This method return the role by id
     *
     * @param id id to select
     * @return role
     */
    @Override
    public Role getById(int id) {
        Role role = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("GET_ROLE_BY_ID"));
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Container<Role> container = setEntity(rs);
            if (container.getLenght() > 0) {
                role = container.getEntity();
            }
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR RoleDAO detById SQL", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return role;
    }
}
