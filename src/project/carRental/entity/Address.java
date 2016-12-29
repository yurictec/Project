package project.carRental.entity;

public class Address extends BasicEntity{
    private User user;
    private String  country;
    private String city;
    private String street;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return super.toString() + "User id: " + user.getId() + ". "
                + country + " " + city + " " + street + "\n";
    }
    
    
    
}
