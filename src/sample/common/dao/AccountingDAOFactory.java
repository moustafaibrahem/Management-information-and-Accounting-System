package sample.common.dao;


import sample.dao.accounting.AccountingDAO;
import sample.dao.accounting.AccountingDAOImpl;
import sample.dao.accountingdetails.AccountingDetailsDAO;
import sample.dao.accountingdetails.AccountingDetailsDAOImpl;
import sample.dao.admin.AdminDAO;
import sample.dao.admin.AdminDAOImpl;
import sample.dao.department.DepartmentDAO;
import sample.dao.department.DepartmentDAOImpl;
import sample.dao.departmentandemployeecount.DepartmentAndEmployeeCountDAO;
import sample.dao.departmentandemployeecount.DepartmentAndEmployeeCountDAOImpl;
import sample.dao.employee.EmployeeDAO;
import sample.dao.employee.EmployeeDAOImpl;
import sample.dao.employeeanddepartment.EmployeeANDDepartmentDAO;
import sample.dao.employeeanddepartment.EmployeeANDDepartmentDAOImpl;
import sample.dao.hourprice.HourPriceDAO;
import sample.dao.hourprice.HourPriceDAOImpl;
import sample.dao.loan.LoanDAO;
import sample.dao.loan.LoanDAOImpl;
import sample.dao.loandetails.LoanDetailsDAO;
import sample.dao.loandetails.LoanDetailsDAOImpl;
import sample.dao.loansrepayment.LoansRepaymentDAO;
import sample.dao.loansrepayment.LoansRepaymentDAOImpl;
import sample.dao.loansrepaymentdetails.LoansRepaymentDetailsDAO;
import sample.dao.loansrepaymentdetails.LoansRepaymentDetailsDAOImpl;
import sample.dao.monthlyloans.MonthlyLoansDAO;
import sample.dao.monthlyloans.MonthlyLoansDAOImpl;
import sample.dao.monthlyreport.MonthlyReportDAO;
import sample.dao.monthlyreport.MonthlyReportDAOImpl;
import sample.dao.monthlysalaries.MonthlySalariesDAO;
import sample.dao.monthlysalaries.MonthlySalariesDAOImpl;
import sample.dao.salarydetails.SalaryDetailsDAO;
import sample.dao.salarydetails.SalaryDetailsDAOImpl;
import sample.dao.salaries.SalariesDAO;
import sample.dao.salaries.SalariesDAOImpl;
import sample.dao.salariesandsalarydetails.SalariesANDSalaryDetailsDAO;
import sample.dao.salariesandsalarydetails.SalariesANDSalaryDetailsDAOImpl;

public class AccountingDAOFactory {
    //DAO Factory
    public static AccountingDAO createAccountingDAOImpl(){return new AccountingDAOImpl();}
    public static AdminDAO createAdminDAOImpl(){return new AdminDAOImpl();}
    public static DepartmentDAO createDepartmentDAOImpl(){return new DepartmentDAOImpl();}
    public static EmployeeDAO createEmployeeDAOImpl(){return new EmployeeDAOImpl();}
    public static HourPriceDAO createHourPriceDAOImpl(){return new HourPriceDAOImpl();}
    public static LoanDAO createLoanDAOImpl(){return new LoanDAOImpl();}
    public static MonthlyReportDAO createMonthlyReportDAOImpl(){return new MonthlyReportDAOImpl();}
    public static SalaryDetailsDAO createSalaryDetailsDAOImpl(){return new SalaryDetailsDAOImpl();}
    public static SalariesDAO createSalarysDAOImpl(){return new SalariesDAOImpl();}
    public static SalariesANDSalaryDetailsDAO createSalarysDtoSalaryDetailsDAOImpl(){return new SalariesANDSalaryDetailsDAOImpl();}
    public static EmployeeANDDepartmentDAO createEmployeeANDDepartmentDAOImpl(){return new EmployeeANDDepartmentDAOImpl();}
    public static AccountingDetailsDAO createAccountingDetailsDAOImpl(){return new AccountingDetailsDAOImpl();}
    public static LoanDetailsDAO createLoanDetailsDAOImpl(){return new LoanDetailsDAOImpl();}
    public static MonthlySalariesDAO createMonthlySalariesImpl(){return new MonthlySalariesDAOImpl();}
    public static DepartmentAndEmployeeCountDAO createDepartmentAndEmployeeCountDAOImpl(){return new DepartmentAndEmployeeCountDAOImpl();}
    public static MonthlyLoansDAO createMonthlyLoansDAOImpl(){return new MonthlyLoansDAOImpl();}
    public static LoansRepaymentDAO createLoansRepaymentDAOImpl(){return new LoansRepaymentDAOImpl();}
    public static LoansRepaymentDetailsDAO createLoansRepaymentDetailsDAOImpl(){return new LoansRepaymentDetailsDAOImpl();}

}