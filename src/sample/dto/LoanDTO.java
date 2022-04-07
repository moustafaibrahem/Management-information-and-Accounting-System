package sample.dto;

import java.util.Objects;

public class LoanDTO {
    private long loanID;
    private long employeeID;
    private double borrowedMoney;
    private String createdAt;

    public LoanDTO() {
        loanID = 0;
    }

    public LoanDTO(long employeeID, double borrowedMoney, String createdAt) {
        this.employeeID = employeeID;
        this.borrowedMoney = borrowedMoney;
        this.createdAt = createdAt;
    }

    public LoanDTO(long loanID, long employeeID, double borrowedMoney, String createdAt) {
        this.loanID = loanID;
        this.employeeID = employeeID;
        this.borrowedMoney = borrowedMoney;
        this.createdAt = createdAt;
    }

    public long getLoanID() {
        return loanID;
    }

    public void setLoanID(long loanID) {
        this.loanID = loanID;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public double getBorrowedMoney() {
        return borrowedMoney;
    }

    public void setBorrowedMoney(double borrowedMoney) {
        this.borrowedMoney = borrowedMoney;
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
        LoanDTO loanDto = (LoanDTO) o;
        return loanID == loanDto.loanID && employeeID == loanDto.employeeID && Double.compare(loanDto.borrowedMoney, borrowedMoney) == 0 && createdAt.equals(loanDto.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanID, employeeID, borrowedMoney, createdAt);
    }
}
