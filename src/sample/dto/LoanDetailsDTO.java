package sample.dto;

import java.util.Objects;

public class LoanDetailsDTO {
    private String month;
    private double takenMoney;
    private String createdAt;

    public LoanDetailsDTO() {
    }

    public LoanDetailsDTO(String month, double takenMoney, String createdAt) {
        this.month = month;
        this.takenMoney = takenMoney;
        this.createdAt = createdAt;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getTakenMoney() {
        return takenMoney;
    }

    public void setTakenMoney(double takenMoney) {
        this.takenMoney = takenMoney;
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
        LoanDetailsDTO that = (LoanDetailsDTO) o;
        return Double.compare(that.takenMoney, takenMoney) == 0 && month.equals(that.month) && createdAt.equals(that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, takenMoney, createdAt);
    }
}
