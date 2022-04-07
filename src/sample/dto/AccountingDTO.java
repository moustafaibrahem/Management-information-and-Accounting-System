package sample.dto;

import java.util.Objects;

public class AccountingDTO {
    private long accountingID;
    private long employeeID;
    private int hours;
    private int status;

    public AccountingDTO() {
        accountingID = 0;
    }

    public AccountingDTO(long employeeID, int hours, int status) {
        this.employeeID = employeeID;
        this.hours = hours;
        this.status = status;
    }

    public AccountingDTO(long accountingID, long employeeID, int hours, int status) {
        this.accountingID = accountingID;
        this.employeeID = employeeID;
        this.hours = hours;
        this.status = status;
    }

    public long getAccountingID() {
        return accountingID;
    }

    public void setAccountingID(long accountingID) {
        this.accountingID = accountingID;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountingDTO that = (AccountingDTO) o;
        return accountingID == that.accountingID && employeeID == that.employeeID && hours == that.hours && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountingID, employeeID, hours, status);
    }
}
