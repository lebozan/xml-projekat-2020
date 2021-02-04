package ftn.xml.ServisOrganVlasti.dto;

public class UserRoleDTO {
    String username;
    String role;

    public UserRoleDTO() {
        super();
    }
    public UserRoleDTO(String username, String role) {
        super();
        this.username = username;
        this.role = role;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
