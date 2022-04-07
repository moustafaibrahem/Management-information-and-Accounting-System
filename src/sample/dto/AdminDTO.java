package sample.dto;

import java.util.Objects;

public class AdminDTO {
    private long adminID;
    private String username;
    private String password;

    public AdminDTO() {
        username = null;
    }

    public AdminDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AdminDTO(long adminID, String username, String password) {
        this.adminID = adminID;
        this.username = username;
        this.password = password;
    }

    public long getAdminID() {
        return adminID;
    }

    public void setAdminID(long adminID) {
        this.adminID = adminID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminDTO adminDto = (AdminDTO) o;
        return adminID == adminDto.adminID && username.equals(adminDto.username) && password.equals(adminDto.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminID, username, password);
    }
}
