package project.carRental.entity;

public class Role extends BasicEntity{
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return super.toString() + role + "\n"; //To change body of generated methods, choose Tools | Templates.
    }
    
}
