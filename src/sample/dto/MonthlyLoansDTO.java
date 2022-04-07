package sample.dto;

import java.util.Objects;

public class MonthlyLoansDTO {
    private long loanID;
    private long employeeCode;
    private double monthlyLoan;
    private double repaidMoney;
    private String createdAt;
    private String month;

    public MonthlyLoansDTO() {
    }

    public MonthlyLoansDTO(long loanID, String month, double repaidMoney, double monthlyLoan) {
        this.loanID = loanID;
        this.monthlyLoan = monthlyLoan;
        this.repaidMoney = repaidMoney;
        this.month = month;
    }

    public MonthlyLoansDTO(long loanID, long employeeCode, double monthlyLoan, double repaidMoney, String createdAt, String month) {
        this.loanID = loanID;
        this.employeeCode = employeeCode;
        this.monthlyLoan = monthlyLoan;
        this.repaidMoney = repaidMoney;
        this.createdAt = createdAt;
        this.month = month;
    }

    public long getLoanID() {
        return loanID;
    }

    public void setLoanID(long loanID) {
        this.loanID = loanID;
    }

    public long getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(long employeeCode) {
        this.employeeCode = employeeCode;
    }

    public double getMonthlyLoan() {
        return monthlyLoan;
    }

    public void setMonthlyLoan(double monthlyLoan) {
        this.monthlyLoan = monthlyLoan;
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
        MonthlyLoansDTO that = (MonthlyLoansDTO) o;
        return loanID == that.loanID && employeeCode == that.employeeCode && Double.compare(that.monthlyLoan, monthlyLoan) == 0 && Double.compare(that.repaidMoney, repaidMoney) == 0 && createdAt.equals(that.createdAt) && month.equals(that.month);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanID, employeeCode, monthlyLoan, repaidMoney, createdAt, month);
    }
}
