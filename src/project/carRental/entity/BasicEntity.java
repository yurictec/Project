package project.carRental.entity;

import java.util.Comparator;

public class BasicEntity {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + ") ";
    }

    public static final Comparator<BasicEntity> COMPARE_BY_ID = new Comparator<BasicEntity>() {
        @Override
        public int compare(BasicEntity lhs, BasicEntity rhs) {
            return lhs.getId() - rhs.getId();
        }
    };
}
