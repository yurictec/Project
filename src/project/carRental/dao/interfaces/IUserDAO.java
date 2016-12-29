package project.carRental.dao.interfaces;

import project.carRental.entity.User;

/**
 * @author Yuriy Kolennikov
 */

public interface IUserDAO extends IDAO<User> {
    public User getLoginAndPassword(String email, String password);

    public int insert(User user);

    public User getUserByEmail(String email);

    public int getIdUser(String email);

    public int update(User user);
}
