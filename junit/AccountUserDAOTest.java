import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project.carRental.container.Container;
import project.carRental.dao.implementations.AccountUserDAO;
import project.carRental.entity.AccountUser;

import static org.junit.Assert.*;

/**
 * @author Yuriy Kolennikov
 */

public class AccountUserDAOTest {

    private AccountUserDAO accountUserDAOActual;
    private Container<AccountUser> containerActual;
    private AccountUser accountUserActual;
    private int sizeActual;

    @Before
    public void setUp() throws Exception {
        accountUserDAOActual = AccountUserDAO.getInstance();

        containerActual = accountUserDAOActual.getAll();
        sizeActual = containerActual.getLenght();

        accountUserActual = accountUserDAOActual.getById(1);

    }

    @After
    public void tearDown() throws Exception {
        accountUserDAOActual = null;
        containerActual = null;

    }

    @Test
    public void getAll() throws Exception {
        Container<AccountUser> c = accountUserDAOActual.getAll();
        int size = c.getLenght();
        assertEquals(size, sizeActual);

    }

    @Test
    public void getById() throws Exception {
        AccountUser accUser = accountUserDAOActual.getById(1);
        assertEquals(accUser, accountUserActual);
    }

}