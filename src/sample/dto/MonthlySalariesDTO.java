package sample.dto;

import java.util.Objects;

public class MonthlySalariesDTO {
    private long salarysID;
    private String month;
    private double takenSalary;
    private double monthlySalary;

    public MonthlySalariesDTO() {
    }

    public MonthlySalariesDTO(long salarysID, String month, double takenSalary, double monthlySalary) {
        this.salarysID = salarysID;
        this.month = month;
        this.takenSalary = takenSalary;
        this.monthlySalary = monthlySalary;
    }

    public long getSalarysID() {
        return salarysID;
    }

    public void setSalarysID(long salarysID) {
        this.salarysID = salarysID;
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
        MonthlySalariesDTO that = (MonthlySalariesDTO) o;
        return salarysID == that.salarysID && Double.compare(that.takenSalary, takenSalary) == 0 && Double.compare(that.monthlySalary, monthlySalary) == 0 && Objects.equals(month, that.month);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salarysID, month, takenSalary, monthlySalary);
    }
}
