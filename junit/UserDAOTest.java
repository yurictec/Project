import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project.carRental.dao.implementations.UserDAO;
import project.carRental.entity.Role;
import project.carRental.entity.User;

import static org.junit.Assert.*;

/**
 * @author Yuriy Kolennikov
 */

public class UserDAOTest {

    private User user;
    private UserDAO userDAO;
    private User userDelete;
    private User userByLoginAndPass;

    @Before
    public void setUp() throws Exception {
        Role role = new Role();
        role.setId(1);
        user = new User(role, "1", "1", "1", "1", "1", "1");
        userDAO = UserDAO.getInstance();
        userDelete = userDAO.getUserByEmail("1");
        userByLoginAndPass = userDAO.getLoginAndPassword("qwerty@qwerty.qwerty", "qwerty");
    }

    @After
    public void tearDown() throws Exception {
        user = null;
        userDAO = null;
        userDelete = null;
        userByLoginAndPass = null;
    }

    @Test
    public void insertUser() throws Exception {
        int mod = userDAO.insert(user);
        int modActual = 1;
        assertEquals(mod, modActual);
    }

    @Test
    public void deleteUser() throws Exception {
        int mod = userDAO.delete(userDelete.getId());
        int modActual = 1;
        assertEquals(mod, modActual);
    }

    @Test
    public void getLoginAndPassword() {

        User userExpect = userDAO.getLoginAndPassword("qwerty@qwerty.qwerty", "qwerty");

        assertEquals(userExpect, userByLoginAndPass);
    }

}