package sample.dto;

import java.util.Objects;

public class AccountingDetailsDTO {
    private String month;
    private int hours;
    private String status;
    private String createdAt;

    public AccountingDetailsDTO() {
    }

    public AccountingDetailsDTO(String month, int hours, String status, String createdAt) {
        this.month = month;
        this.hours = hours;
        this.status = status;
        this.createdAt = createdAt;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        AccountingDetailsDTO that = (AccountingDetailsDTO) o;
        return hours == that.hours && month.equals(that.month) && status.equals(that.status) && createdAt.equals(that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, hours, status, createdAt);
    }
}
