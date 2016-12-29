package junit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import project.carRental.dao.implementations.OrderDAO;

import static org.junit.Assert.assertEquals;

/**
 * @author Yuriy Kolennikov
 */

public class OrderDAOTest {

    private static OrderDAO orderDAO;
    private int idCar;
    private int idUser;
    private int date;
    private int price;
    private String stat;
    private String pay;
    private int modActual;
    private String payActual;

    public OrderDAOTest() {
    }

    @Before
    public void setUp() throws Exception {
        orderDAO = OrderDAO.getInstance();

        idCar = 1;
        idUser = 1;
        date = 44;
        price = 100;
        stat = "processing";
        pay = "awaiting";

        modActual = 1;

        payActual = "paid";
    }

    @AfterClass
    public static void tearDown() throws Exception {

    }

    @Test
    public void pay() throws Exception {
        orderDAO.creatOrder(idCar, idUser, date, price, stat, pay);
        int id = orderDAO.getIdOrder(idCar, idUser, date);
        int mod = OrderDAO.getInstance().pay(id, payActual);
        orderDAO.deleteOrder(orderDAO.getIdOrder(idCar, idUser, date));
        assertEquals(mod, modActual);
    }

    @Test
    public void creatOrder() throws Exception {
        int mod = orderDAO.creatOrder(idCar, idUser, date, price, stat, pay);
        orderDAO.deleteOrder(orderDAO.getIdOrder(idCar, idUser, date));
        assertEquals(mod, modActual);

    }
}