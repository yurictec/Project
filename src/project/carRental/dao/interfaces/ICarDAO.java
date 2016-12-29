package project.carRental.dao.interfaces;

import project.carRental.container.Container;
import project.carRental.entity.Car;

/**
 * @author Yuriy Kolennikov
 */

public interface ICarDAO extends IDAO<Car> {
    public int updateStat(int id, String stat);

    public Container getActivCars();

    public int update(Car car);
}
