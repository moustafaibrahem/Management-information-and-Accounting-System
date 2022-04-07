package sample.dto;

import java.util.Objects;

public class SalariesANDSalaryDetailsDTO {
    private String month;
    private double takenSalary;
    private String createdAt;
    private double monthlySalary;

    public SalariesANDSalaryDetailsDTO() {
    }

    public SalariesANDSalaryDetailsDTO(String month, double takenSalary, String createdAt, double monthlySalary) {
        this.month = month;
        this.takenSalary = takenSalary;
        this.createdAt = createdAt;
        this.monthlySalary = monthlySalary;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalariesANDSalaryDetailsDTO that = (SalariesANDSalaryDetailsDTO) o;
        return Double.compare(that.takenSalary, takenSalary) == 0 && Double.compare(that.monthlySalary, monthlySalary) == 0 && month.equals(that.month) && createdAt.equals(that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, takenSalary, createdAt, monthlySalary);
    }
}
