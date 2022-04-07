package sample.dto;

import java.util.Objects;

public class DepartmentAndEmployeeCountDTO {
    private long departmentID;
    private String departmentName;
    private long countEmployee;

    public DepartmentAndEmployeeCountDTO() {
    }

    public DepartmentAndEmployeeCountDTO(long departmentID, String departmentName, long countEmployee) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.countEmployee = countEmployee;
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

    public long getCountEmployee() {
        return countEmployee;
    }

    public void setCountEmployee(long countEmployee) {
        this.countEmployee = countEmployee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentAndEmployeeCountDTO that = (DepartmentAndEmployeeCountDTO) o;
        return departmentID == that.departmentID && countEmployee == that.countEmployee && departmentName.equals(that.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentID, departmentName, countEmployee);
    }
}
