package project.carRental.dao.interfaces;

import project.carRental.container.Container;
import project.carRental.entity.BasicEntity;

/**
 * @author Yuriy Kolennikov
 */

public interface IDAO<T extends BasicEntity> {
    public Container<T> getAll();

    public T getById(int id);
}
