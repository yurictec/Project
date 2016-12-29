package project.carRental.entity;

/**
 * This class describes the entity Order
 *
 * @author Yuriy Kolennikov
 */

public class Order extends BasicEntity {

    private String carBrand;
    private String carMake;
    private String fNameUser;
    private String lNameUser;
    private int date;
    private int sum;
    private String stat;
    private String pay;

    public Order() {

    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getPay() {
        return pay;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public int getData() {
        return date;
    }

    public void setData(int date) {
        this.date = date;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getfNameUser() {
        return fNameUser;
    }

    public void setfNameUser(String fNameUser) {
        this.fNameUser = fNameUser;
    }

    public String getlNameUser() {
        return lNameUser;
    }

    public void setlNameUser(String lNameUser) {
        this.lNameUser = lNameUser;
    }

    @Override
    public String toString() {
        return "Order #" + super.toString() + carBrand + " "
                + carMake + ". User: " + fNameUser + " " + lNameUser
                + ". How many days: " + date + ". Sum order: " + sum + "$. "
                + "Stat: " + stat + " Pay: " + pay + "\n";
    }


}
