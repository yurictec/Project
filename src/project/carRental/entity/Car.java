package project.carRental.entity;

/**
 * This class describes the entity Car
 *
 * @author Yuriy Kolennikov
 */

public class Car extends BasicEntity {

    private Equipment equipment;
    private String brand;
    private String make;
    private String stat;
    private int price;

    public Car() {

    }

    public Car(int id, String brand, String make, String stat, int price) {
        super.setId(id);
        this.brand = brand;
        this.make = make;
        this.stat = stat;
        this.price = price;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return super.toString() + brand + " " + make + ". "
                + stat + ". " + price + "$. Equipment: " + equipment.toString();
    }
}
