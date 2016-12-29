package project.carRental.entity;

public class AccountUser extends BasicEntity {

    private User user;
    private String numberAccount;
    private String stat;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public String stat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return super.toString() + "User id: " + user.getId() + ". #"
                + numberAccount + ". Stat: " + stat + "\n";
    }
}
