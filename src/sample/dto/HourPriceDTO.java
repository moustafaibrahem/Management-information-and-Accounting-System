package sample.dto;

import java.util.Date;
import java.util.Objects;

public class HourPriceDTO {
    private long hourPriceID;
    private double price;
    private String createdAt;

    public HourPriceDTO() {
    }

    public HourPriceDTO(double price, String createdAt) {
        this.price = price;
        this.createdAt = createdAt;
    }

    public HourPriceDTO(long hourPriceID, double price, String createdAt) {
        this.hourPriceID = hourPriceID;
        this.price = price;
        this.createdAt = createdAt;
    }

    public long getHourPriceID() {
        return hourPriceID;
    }

    public void setHourPriceID(long hourPriceID) {
        this.hourPriceID = hourPriceID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
        HourPriceDTO that = (HourPriceDTO) o;
        return hourPriceID == that.hourPriceID && Double.compare(that.price, price) == 0 && createdAt.equals(that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hourPriceID, price, createdAt);
    }
}
