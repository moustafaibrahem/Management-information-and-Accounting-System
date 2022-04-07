package sample.dto;

import java.util.Objects;

public class DepartmentDTO {
    private long departmentID;
    private String departmentName;

    public DepartmentDTO() {
        departmentID = 0;
    }

    public DepartmentDTO(String departmentName) {
        this.departmentName = departmentName;
    }

    public DepartmentDTO(long departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }

    public long getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(long departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentDTO that = (DepartmentDTO) o;
        return departmentID == that.departmentID && departmentName.equals(that.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentID, departmentName);
    }
}
