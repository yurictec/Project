package junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project.carRental.connection.DBPool;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * @author Yuriy Kolennikov
 */
public class DBPoolTest {

    private static DBPool dbPool;

    @Before
    public void setUp() throws Exception {
        dbPool = DBPool.getInstance();
    }

    @After
    public void tearDown() throws Exception {
        dbPool = null;
    }

    @Test
    public void getInstance() throws Exception {
        DBPool dbPoolEx = DBPool.getInstance();
        assertEquals(dbPool, dbPoolEx);
    }

    @Test
    public void getConnection() throws Exception {
        Connection connection = dbPool.getConnection();
        assertNotNull(connection);
    }

}