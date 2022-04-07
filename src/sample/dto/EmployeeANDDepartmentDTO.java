package sample.dto;

import java.util.Date;
import java.util.Objects;

public class EmployeeANDDepartmentDTO {
    private  long codeID;
    private String name;
    private String phone;
    private double basicSalary;
    private long numberOfHours;
    private String departmentName;
    private String dateOfEmployment;

    public EmployeeANDDepartmentDTO() {
    }

    public EmployeeANDDepartmentDTO(String name) {
        this.name = name;
    }

    public EmployeeANDDepartmentDTO(long codeID, String name, String phone, double basicSalary, long numberOfHours,String departmentName, String dateOfEmployment) {
        this.codeID = codeID;
        this.name = name;
        this.phone = phone;
        this.basicSalary = basicSalary;
        this.numberOfHours = numberOfHours;
        this.departmentName = departmentName;
        this.dateOfEmployment = dateOfEmployment;
    }

    public long getCodeID() {
        return codeID;
    }

    public void setCodeID(long codeID) {
        this.codeID = codeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(String dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public long getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(long numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeANDDepartmentDTO that = (EmployeeANDDepartmentDTO) o;
        return codeID == that.codeID && Double.compare(that.basicSalary, basicSalary) == 0 && numberOfHours == that.numberOfHours && name.equals(that.name) && phone.equals(that.phone) && departmentName.equals(that.departmentName) && dateOfEmployment.equals(that.dateOfEmployment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeID, name, phone, basicSalary, numberOfHours, departmentName, dateOfEmployment);
    }
}
