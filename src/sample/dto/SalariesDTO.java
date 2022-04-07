package sample.dto;

import java.util.Objects;

public class SalariesDTO {
    private long salaryID;
    private long employeeID;
    private double monthlySalary;
    private double takenSalary;
    private String createdAt;
    private String month;

    public SalariesDTO() {
        this.salaryID = 0;
    }

    public SalariesDTO(long salaryID) {
        this.salaryID = salaryID;
    }

    public SalariesDTO(long employeeID, double monthlySalary, double takenSalary, String createdAt, String month) {
        this.employeeID = employeeID;
        this.monthlySalary = monthlySalary;
        this.takenSalary = takenSalary;
        this.createdAt = createdAt;
        this.month = month;
    }

    public SalariesDTO(long salaryID, long employeeID, double monthlySalary, double takenSalary, String createdAt, String month) {
        this.salaryID = salaryID;
        this.employeeID = employeeID;
        this.monthlySalary = monthlySalary;
        this.takenSalary = takenSalary;
        this.createdAt = createdAt;
        this.month = month;
    }

    public long getSalaryID() {
        return salaryID;
    }

    public void setSalaryID(long salaryID) {
        this.salaryID = salaryID;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double getTakenSalary() {
        return takenSalary;
    }

    public void setTakenSalary(double takenSalary) {
        this.takenSalary = takenSalary;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalariesDTO that = (SalariesDTO) o;
        return salaryID == that.salaryID && employeeID == that.employeeID && Double.compare(that.monthlySalary, monthlySalary) == 0 && Double.compare(that.takenSalary, takenSalary) == 0 && createdAt.equals(that.createdAt) && month.equals(that.month);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salaryID, employeeID, monthlySalary, takenSalary, createdAt, month);
    }
}
