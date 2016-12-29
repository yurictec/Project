package project.carRental.dao.implementations;

import org.apache.log4j.Level;
import project.carRental.dao.abstracts.AbstractDAO;
import project.carRental.dao.interfaces.IEquipmentDAO;
import project.carRental.container.Container;
import project.carRental.entity.Equipment;
import project.carRental.propertiesManagers.CommandSQLManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Yuriy Kolennikov
 */

public class EquipmentDAO extends AbstractDAO implements IEquipmentDAO {

    /**
     * This is implementation Singleton-pattern
     */
    private EquipmentDAO() {

    }

    private static class EquipmentDAOHolder {
        private static final EquipmentDAO EQUIPMENT_DAO = new EquipmentDAO();
    }

    public static EquipmentDAO getInstance() {
        return EquipmentDAOHolder.EQUIPMENT_DAO;
    }

    /**
     * Initialization
     *
     * @return initialized equipment
     */
    private Container<Equipment> setEntity(ResultSet rs) {
        Container<Equipment> container = new Container(new ArrayList<>());
        try {
            while (rs.next()) {
                Equipment e = new Equipment();
                e.setId(rs.getInt(1));
                e.setEquipment(rs.getString(2));
                e.setTransmission(rs.getString(3));
                e.setLeatherInterior(rs.getString(4));
                e.setElectroPackage(rs.getString(5));
                e.setAirConditioning(rs.getString(6));
                e.setVoiceControl(rs.getString(7));
                container.add(e);
            }
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR EquipmentDAO setEntity SQL", ex);
        }
        return container;
    }

    /**
     * This method return the container of equipment
     *
     * @return container of equipments
     */
    @Override
    public Container<Equipment> getAll() {
        Connection connection = null;
        Container<Equipment> container = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("GET_EQUIPMENT_ALL"));
            rs = ps.executeQuery();
            container = setEntity(rs);
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR EquipmentDAO getAll SQL", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return container;
    }

    /**
     * This method return the equipment by id
     *
     * @param id int
     * @return equipment
     */
    @Override
    public Equipment getById(int id) {
        Equipment e = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(CommandSQLManager.getInstance().getProperty("GET_EQUIPMENT_BY_ID"));
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Container<Equipment> container = setEntity(rs);
            if (container.getLenght() > 0) {
                e = container.getEntity();
            }
        } catch (SQLException ex) {
            l.log(Level.ERROR, "ERROR EquipmentDAO getById SQL", ex);
        } finally {
            closeConn(connection);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return e;
    }

}
