package sample.dto;

import java.util.Objects;

public class LoansRepaymentDTO {
    private long id;
    private long loanID;
    private double repaidMoney;
    private String date;

    public LoansRepaymentDTO() {
        this.id = 0;
    }

    public LoansRepaymentDTO(long loanID, double repaidMoney) {
        this.loanID = loanID;
        this.repaidMoney = repaidMoney;
    }

    public LoansRepaymentDTO(long id, long loanID, double repaidMoney, String date) {
        this.id = id;
        this.loanID = loanID;
        this.repaidMoney = repaidMoney;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLoanID() {
        return loanID;
    }

    public void setLoanID(long loanID) {
        this.loanID = loanID;
    }

    public double getRepaidMoney() {
        return repaidMoney;
    }

    public void setRepaidMoney(double repaidMoney) {
        this.repaidMoney = repaidMoney;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoansRepaymentDTO that = (LoansRepaymentDTO) o;
        return id == that.id && loanID == that.loanID && Double.compare(that.repaidMoney, repaidMoney) == 0 && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loanID, repaidMoney, date);
    }
}
