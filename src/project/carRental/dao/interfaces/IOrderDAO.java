package project.carRental.dao.interfaces;

import project.carRental.container.Container;
import project.carRental.entity.Order;

/**
 * @author Yuriy Kolennikov
 */

public interface IOrderDAO extends IDAO<Order> {
    public int creatOrder(int carId, int userId, int date, int price, String stat, String pay);

    public int getIdOrder(int idcar, int iduser, int date);

//    public Container getOrder(int idUser);

    public Container getAllByIdUser(int idUser);

    public Container getAllByProcessing();

    public int update(Order order);

    public int pay(int idOrder, String pay);
}
