package sample.common.bao;


import sample.bao.accounting.AccountingBAO;
import sample.bao.accounting.AccountingBAOImpl;
import sample.bao.accountingdetails.AccountingDetailsBAO;
import sample.bao.accountingdetails.AccountingDetailsBAOImpl;
import sample.bao.admin.AdminBAO;
import sample.bao.admin.AdminBAOImpl;
import sample.bao.department.DepartmentBAO;
import sample.bao.department.DepartmentBAOImpl;
import sample.bao.departmentandemployeecount.DepartmentAndEmployeeCountBAO;
import sample.bao.departmentandemployeecount.DepartmentAndEmployeeCountBAOImpl;
import sample.bao.employee.EmployeeBAO;
import sample.bao.employee.EmployeeBAOImpl;
import sample.bao.employeeanddepartment.EmployeeANDDepartmentBAO;
import sample.bao.employeeanddepartment.EmployeeANDDepartmentBAOImpl;
import sample.bao.hourprice.HourPriceBAO;
import sample.bao.hourprice.HourPriceBAOImpl;
import sample.bao.loan.LoanBAO;
import sample.bao.loan.LoanBAOImpl;
import sample.bao.loandetails.LoanDetailsBAO;
import sample.bao.loandetails.LoanDetailsBAOImpl;
import sample.bao.loansrepayment.LoansRepaymentBAO;
import sample.bao.loansrepayment.LoansRepaymentBAOImpl;
import sample.bao.loansrepaymentdetails.LoansRepaymentDetailsBAO;
import sample.bao.loansrepaymentdetails.LoansRepaymentDetailsBAOImpl;
import sample.bao.monthlyloans.MonthlyLoansBAO;
import sample.bao.monthlyloans.MonthlyLoansBAOImpl;
import sample.bao.monthlyreport.MonthlyReportBAO;
import sample.bao.monthlyreport.MonthlyReportBAOImpl;
import sample.bao.monthlysalaries.MonthlySalariesBAO;
import sample.bao.monthlysalaries.MonthlySalariesBAOImpl;
import sample.bao.salarydetails.SalaryDetailsBAO;
import sample.bao.salarydetails.SalaryDetailsBAOImpl;
import sample.bao.salaries.SalariesBAO;
import sample.bao.salaries.SalariesBAOImpl;
import sample.bao.salariesandsalarydetails.SalariesANDSalaryDetailsBAO;
import sample.bao.salariesandsalarydetails.SalariesANDSalaryDetailsBAOImpl;

public class AccountingBAOFactory {
    //BAO Factory
    public static AccountingBAO createAccountingBAOImpl(){return new AccountingBAOImpl();}
    public static AdminBAO createAdminBAOImpl(){return new AdminBAOImpl();}
    public static DepartmentBAO createDepartmentBAOImpl(){return new DepartmentBAOImpl();}
    public static EmployeeBAO createEmployeeBAOImpl(){return new EmployeeBAOImpl();}
    public static HourPriceBAO createHourPriceBAOImpl() {return new HourPriceBAOImpl();}
    public static LoanBAO createLoanBAOImpl(){return new LoanBAOImpl();}
    public static MonthlyReportBAO createMonthlyReportBAOImpl(){return new MonthlyReportBAOImpl();}
    public static SalaryDetailsBAO createSalaryDetailsBAOImpl(){return new SalaryDetailsBAOImpl();}
    public static SalariesBAO createSalarysBAOImpl(){return new SalariesBAOImpl();}
    public static SalariesANDSalaryDetailsBAO createSalarysDtoSalaryDetailsBAOImpl(){return new SalariesANDSalaryDetailsBAOImpl();}
    public static EmployeeANDDepartmentBAO createEmployeeANDDepartmentBAOImpl(){return new EmployeeANDDepartmentBAOImpl();}
    public static AccountingDetailsBAO createAccountingDetailsBAOImpl(){return new AccountingDetailsBAOImpl();}
    public static LoanDetailsBAO createLoanDetailsBAOImpl(){return new LoanDetailsBAOImpl();}
    public static MonthlySalariesBAO createMonthlySalariesBAOImpl(){return new MonthlySalariesBAOImpl();}
    public static DepartmentAndEmployeeCountBAO createDepartmentAndEmployeeCountBAOImpl(){return new DepartmentAndEmployeeCountBAOImpl();}
    public static MonthlyLoansBAO createMonthlyLoansBAOImpl(){return new MonthlyLoansBAOImpl();}
    public static LoansRepaymentBAO createLoansRepaymentBAOImpl(){return new LoansRepaymentBAOImpl();}
    public static LoansRepaymentDetailsBAO createLoansRepaymentDetailsBAOImpl(){return new LoansRepaymentDetailsBAOImpl();}

}