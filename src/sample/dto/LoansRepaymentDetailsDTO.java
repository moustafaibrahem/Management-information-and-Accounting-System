package sample.dto;

import java.util.Objects;

public class LoansRepaymentDetailsDTO {
    private String month;
    private double borrowedMoney;
    private double repaidMoney;
    private String createdAt;

    public LoansRepaymentDetailsDTO() {
    }

    public LoansRepaymentDetailsDTO(String month, double borrowedMoney, double repaidMoney, String createdAt) {
        this.month = month;
        this.borrowedMoney = borrowedMoney;
        this.repaidMoney = repaidMoney;
        this.createdAt = createdAt;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getBorrowedMoney() {
        return borrowedMoney;
    }

    public void setBorrowedMoney(double borrowedMoney) {
        this.borrowedMoney = borrowedMoney;
    }

    public double getRepaidMoney() {
        return repaidMoney;
    }

    public void setRepaidMoney(double repaidMoney) {
        this.repaidMoney = repaidMoney;
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
        LoansRepaymentDetailsDTO that = (LoansRepaymentDetailsDTO) o;
        return Double.compare(that.borrowedMoney, borrowedMoney) == 0 && Double.compare(that.repaidMoney, repaidMoney) == 0 && month.equals(that.month) && createdAt.equals(that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, borrowedMoney, repaidMoney, createdAt);
    }
}
