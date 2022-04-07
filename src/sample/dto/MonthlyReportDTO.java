package sample.dto;

import java.util.Objects;

public class MonthlyReportDTO {
    private long empCode;
    private String name;
    private String depName;
    private String dateOfEmployment;
    private double basicSalary;
    private double monthlySalary;
    private double monthlyBonus;
    private double monthlyDiscount;
    private double monthlyBorrowedMoney;
    private String date;

    public MonthlyReportDTO(long empCode, String name, String depName, String dateOfEmployment, double basicSalary, double monthlySalary, double monthlyBonus, double monthlyDiscount, double monthlyBorrowedMoney, String date) {
        this.empCode = empCode;
        this.name = name;
        this.depName = depName;
        this.dateOfEmployment = dateOfEmployment;
        this.basicSalary = basicSalary;
        this.monthlySalary = monthlySalary;
        this.monthlyBonus = monthlyBonus;
        this.monthlyDiscount = monthlyDiscount;
        this.monthlyBorrowedMoney = monthlyBorrowedMoney;
        this.date = date;
    }

    public MonthlyReportDTO() {
        this.monthlyBonus = 0.0;
        this.monthlyDiscount = 0.0;
    }

    public MonthlyReportDTO(double monthlyBonus, double monthlyDiscount) {
        this.monthlyBonus = monthlyBonus;
        this.monthlyDiscount = monthlyDiscount;
    }

    public MonthlyReportDTO(String name, String depName, String dateOfEmployment, double basicSalary, double monthlySalary, double monthlyBonus, double monthlyDiscount, double monthlyBorrowedMoney) {
        this.name = name;
        this.depName = depName;
        this.dateOfEmployment = dateOfEmployment;
        this.basicSalary = basicSalary;
        this.monthlySalary = monthlySalary;
        this.monthlyBonus = monthlyBonus;
        this.monthlyDiscount = monthlyDiscount;
        this.monthlyBorrowedMoney = monthlyBorrowedMoney;
    }

    public MonthlyReportDTO(long empCode, String name, String depName, String dateOfEmployment, double basicSalary, double monthlySalary, double monthlyBonus, double monthlyDiscount, double monthlyBorrowedMoney) {
        this.empCode = empCode;
        this.name = name;
        this.depName = depName;
        this.dateOfEmployment = dateOfEmployment;
        this.basicSalary = basicSalary;
        this.monthlySalary = monthlySalary;
        this.monthlyBonus = monthlyBonus;
        this.monthlyDiscount = monthlyDiscount;
        this.monthlyBorrowedMoney = monthlyBorrowedMoney;
    }

    public long getEmpCode() {
        return empCode;
    }

    public void setEmpCode(long empCode) {
        this.empCode = empCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(String dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlyBonus() {
        return monthlyBonus;
    }

    public void setMonthlyBonus(double monthlyBonus) {
        this.monthlyBonus = monthlyBonus;
    }

    public double getMonthlyDiscount() {
        return monthlyDiscount;
    }

    public void setMonthlyDiscount(double monthlyDiscount) {
        this.monthlyDiscount = monthlyDiscount;
    }

    public double getMonthlyBorrowedMoney() {
        return monthlyBorrowedMoney;
    }

    public void setMonthlyBorrowedMoney(double monthlyBorrowedMoney) {
        this.monthlyBorrowedMoney = monthlyBorrowedMoney;
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
        MonthlyReportDTO that = (MonthlyReportDTO) o;
        return empCode == that.empCode && Double.compare(that.basicSalary, basicSalary) == 0 && Double.compare(that.monthlySalary, monthlySalary) == 0 && Double.compare(that.monthlyBonus, monthlyBonus) == 0 && Double.compare(that.monthlyDiscount, monthlyDiscount) == 0 && Double.compare(that.monthlyBorrowedMoney, monthlyBorrowedMoney) == 0 && name.equals(that.name) && depName.equals(that.depName) && dateOfEmployment.equals(that.dateOfEmployment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empCode, name, depName, dateOfEmployment, basicSalary, monthlySalary, monthlyBonus, monthlyDiscount, monthlyBorrowedMoney);
    }

    @Override
    public String toString() {
        return "MonthlyReportDTO{" +
                "Emp code=" + empCode +
                ", name='" + name + '\'' +
                ", depName='" + depName + '\'' +
                ", dateOfEmployment='" + dateOfEmployment + '\'' +
                ", basicSalary=" + basicSalary +
                ", monthlySalary=" + monthlySalary +
                ", monthlyBonus=" + monthlyBonus +
                ", monthlyDiscount=" + monthlyDiscount +
                ", monthlyBorrowedMoney=" + monthlyBorrowedMoney +
                '}';
    }
}
