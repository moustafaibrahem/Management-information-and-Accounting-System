package sample.common.database;

public class AccountingQueries {

    //Accounting
    public static final String INSERT_ACCOUNTING = "INSERT INTO accountings(emp_code, status, x_hours) VALUES (?,?,?)";
    public static final String SELECT_ACCOUNTING_DETAILS = "CALL get_monthly_accounting_details(?,?);"; // empCode , searchDate

    //Admin
    public static final String SELECT_ADMIN = "SELECT id FROM admin WHERE  username = ? and  password = ?";


    //departments
    public static final String INSERT_DEPARTMENT = "INSERT INTO departments(name) VALUES (?)";
    public static final String SELECT_ALL_DEPARTMENTS = "SELECT id, name FROM departments";
    public static final String SELECT_ALL_DEPARTMENTS_AND_COUNT_OF_EMPLOYEES = "CALL get_department_employees_number()";
    public static final String UPDATE_DEPARTMENT = "UPDATE departments SET name = ? WHERE id = ?";

    //Employee
    public static final String INSERT_EMPLOYEE = "INSERT INTO employees(emp_code, name, phone, basic_salary, number_hours,department_id,date_of_employment) VALUES (?,?,?,?,?,?,?)";
    public static final String SELECT_ALL_EMPLOYEES = "CALL get_employees()";
    public static final String GET_EMPLOYEE_AND_DEPT_BY_CODE_ID = "CALL get_employeeAndDept_byCodeID(?)"; // empCode
    public static final String GET_EMPLOYEE_CODE_ID = "CALL get_employee_byCodeID(?)"; // empCode
    public static final String UPDATE_EMPLOYEE = "UPDATE employees SET name = ?,phone = ?,basic_salary = ?,number_hours = ?,department_id = ? WHERE emp_code = ? ";
    public static final String DELETE_EMPLOYEE = "UPDATE employees SET acvtive = 0 WHERE emp_code = ?";



    //HourPrice
    public static final String INSERT_HOUR_PRICE = "CALL set_hour_price(?)"; //HourPrice

    //Loan
    public static final String INSERT_LOAN = "CALL set_loan_employee(?,?)"; // empCode , money
    public static final String SELECT_LOAN_DETAILS = "CALL get_monthly_loan_details(?,?);"; // empCode , searchDate

    //MonthlyLoans
    public static final String SELECT_MONTHLY_LOANS_FOR_EMPLOYEE = "CALL get_monthly_loans(?)";

    //Loans Repayment
    public static final String INSERT_LOAN_REPAYMENT ="CALL set_loans_repayment(?,?)"; // monthlyLoanID,money
    public static final String SELECT_LOAN_REPAYMENT_DETAILS = "CALL get_monthly_loan_repayment_details(?,?)"; // empCode , searchDate

    //MonthlyReport
    public static final String SELECT_MONTHLY_REPORT = "CALL get_monthly_report(?)";
    public static final String SELECT_EMPLOYEE_HISTORY = "CALL get_employee_history(?)";
    public static final String SELECT_MONTHLY_BONUS_AND_DISCOUNT = "SELECT bonus_money, discount_money FROM monthly_report mr WHERE mr.emp_id = ? and Month(date_month)=MONTH(?) and YEAR(date_month)=YEAR(?) ";


    //Salary_details
    public static final String INSERT_TAKEN_SALARY = "CALL set_salary_employee(?,?)"; //salaryID , money
    public static final String SELECT_SALARY_DETAILS = "CALL get_monthly_salary_details(?,?);"; // empCode , searchDate


    //Salary
    public static final String INSERT_SALARY = "CALL set_salaries(?) "; // empCode
    public static final String SELECT_SALARY_ID_FOR_CURRENT_MONTH = "SELECT id FROM salaries WHERE emp_id = ? and Month(date_month)=MONTH(CURDATE()) and YEAR(date_month)=YEAR(CURDATE())";
    public static final String SELECT_SALARIES_FOR_EMPLOYEE = "CALL get_monthly_salary(?)"; // empCode

}