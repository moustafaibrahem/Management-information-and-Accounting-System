package sample.dto;

import java.util.Objects;

public class EmployeeDTO {
    private  long employeeID;
    private  long codeID;
    private String name;
    private String phone;
    private double basicSalary;
    private long numberOfHours;
    private long departmentID;
    private String dateOfEmployment;

    public EmployeeDTO() {
        this.employeeID = 0;
    }

    public EmployeeDTO(long codeID) {
        this.codeID = codeID;
    }

    public EmployeeDTO(long codeID, String name) {
        this.codeID = codeID;
        this.name = name;
    }

    public EmployeeDTO(String name, String phone) {
        this.employeeID = 0;
        this.name = name;
        this.phone = phone;
    }

    public EmployeeDTO(long codeID, String name, String phone, double basicSalary, long numberOfHours,long departmentID, String dateOfEmployment) {
        this.codeID = codeID;
        this.name = name;
        this.phone = phone;
        this.basicSalary = basicSalary;
        this.numberOfHours = numberOfHours;
        this.departmentID = departmentID;
        this.dateOfEmployment = dateOfEmployment;
    }

    public EmployeeDTO(long employeeID, long codeID, String name, String phone, double basicSalary,long numberOfHours, long departmentID, String dateOfEmployment) {
        this.employeeID = employeeID;
        this.codeID = codeID;
        this.name = name;
        this.phone = phone;
        this.basicSalary = basicSalary;
        this.numberOfHours = numberOfHours;
        this.departmentID = departmentID;
        this.dateOfEmployment = dateOfEmployment;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
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

    public long getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(long departmentID) {
        this.departmentID = departmentID;
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
        EmployeeDTO that = (EmployeeDTO) o;
        return employeeID == that.employeeID && codeID == that.codeID && Double.compare(that.basicSalary, basicSalary) == 0 && numberOfHours == that.numberOfHours && departmentID == that.departmentID && name.equals(that.name) && phone.equals(that.phone) && dateOfEmployment.equals(that.dateOfEmployment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID, codeID, name, phone, basicSalary, numberOfHours, departmentID, dateOfEmployment);
    }
}
