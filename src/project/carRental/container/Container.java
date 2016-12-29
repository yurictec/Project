package project.carRental.container;

import project.carRental.entity.BasicEntity;

import java.util.List;

/**
 * This class is a container of entities
 *
 * @author Yuriy Kolennikov
 */

public class Container<T extends BasicEntity> {

    private List<T> list;
    private int index = -1;

    public Container() {
    }

    public Container(List<T> list) {
        this.list = list;
    }

    public int getLenght() {
        return list.size();
    }

    public void add(T entity) {
        list.add(entity);
        index++;
    }

    public T getEntity() {
        T t = null;
        if (list.size() >= 0) {
            t = list.get(index--);
        }
        return t;
    }

    @Override
    public String toString() {
        String s = "";
        for (T entity : list) {
            s += entity.toString();
        }
        return s;
    }
}
