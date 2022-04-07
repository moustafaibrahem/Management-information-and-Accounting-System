package sample.dto;

import java.util.Date;
import java.util.Objects;

public class SalaryDetailsDTO {
    private long salaryDetailsID;
    private long salarysID;
    private double takenSalary;
    private String createdAt;

    public SalaryDetailsDTO() {
        salaryDetailsID= 0;
    }

    public SalaryDetailsDTO(long salarysID, double takenSalary, String createdAt) {
        this.salarysID = salarysID;
        this.takenSalary = takenSalary;
        this.createdAt = createdAt;
    }

    public SalaryDetailsDTO(long salaryDetailsID, long salarysID, double takenSalary, String createdAt) {
        this.salaryDetailsID = salaryDetailsID;
        this.salarysID = salarysID;
        this.takenSalary = takenSalary;
        this.createdAt = createdAt;
    }

    public long getSalaryDetailsID() {
        return salaryDetailsID;
    }

    public void setSalaryDetailsID(long salaryDetailsID) {
        this.salaryDetailsID = salaryDetailsID;
    }

    public long getSalarysID() {
        return salarysID;
    }

    public void setSalarysID(long salarysID) {
        this.salarysID = salarysID;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalaryDetailsDTO that = (SalaryDetailsDTO) o;
        return salaryDetailsID == that.salaryDetailsID && salarysID == that.salarysID && Double.compare(that.takenSalary, takenSalary) == 0 && createdAt.equals(that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salaryDetailsID, salarysID, takenSalary, createdAt);
    }
}
