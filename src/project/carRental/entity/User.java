package project.carRental.entity;

/**
 * This class describes the entity User
 *
 * @author Yuriy Kolennikov
 */

public class User extends BasicEntity {

    private Role role;
    private String email;
    private String password;
    private String fname;
    private String lname;
    private String age;
    private String phone;

    public User(Role role, String email, String password, String fname, String lname, String age, String phone) {
        this.role = role;
        this.email = email;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.phone = phone;
    }

    public User() {
    }

    public User(int id, String fname, String lname, String email, String age, String phone) {
        super.setId(id);
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.age = age;
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return super.toString() + "Email: " + email + ". Password: <<" + password
                + ">>.  " + fname + " " + lname + ". Age: " + age + ". Phohe: "
                + phone + ". " + role.toString();
    }

}
