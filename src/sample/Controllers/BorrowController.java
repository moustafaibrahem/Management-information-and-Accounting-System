package sample.Controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.bao.employee.EmployeeBAO;
import sample.bao.loan.LoanBAO;
import sample.bao.loandetails.LoanDetailsBAO;
import sample.bao.loansrepayment.LoansRepaymentBAO;
import sample.bao.loansrepaymentdetails.LoansRepaymentDetailsBAO;
import sample.bao.monthlyloans.MonthlyLoansBAO;
import sample.common.bao.AccountingBAOFactory;
import sample.dto.*;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import static sample.common.util.Constants.numericOnly;

public class BorrowController implements Initializable {
    public TextField txtBorrowMoney;
    public TextField txtDateForRepayment;
    public TextField txtNameForRepayment;
    public TextField txtSearchForSetLoan;
    public TextField txtSearchForRepayment;
    public TextField txtRepaymentMoney;

    public TableView<MonthlyLoansDTO> tvBorrow;
    public TableColumn<MonthlyLoansDTO, Double> colBorrowMoney;
    public TableColumn<MonthlyLoansDTO, Double> colBorrowPaid;
    public TableColumn<MonthlyLoansDTO, String> colMonth;
    public TableColumn<MonthlyLoansDTO, Long> colID;

    public TextField txtNameLoansRepayment;

    public Label lblBorrow;
    public TableView<LoanDetailsDTO> tvBorrowForMonth;
    public TableColumn<LoanDetailsDTO, String> colBorrowDate;
    public TableColumn<LoanDetailsDTO, Double> colBorrow;
    public TableColumn<LoanDetailsDTO, String> colMonthBorrow;

    public TableView<LoansRepaymentDetailsDTO> tvLoanRepayment;
    public TableColumn<LoansRepaymentDetailsDTO, Double> colRemainingAmount;
    public TableColumn<LoansRepaymentDetailsDTO, String> colDateOfRepayment;
    public TableColumn<LoansRepaymentDetailsDTO, Double> colRepaymentMoney;
    public TableColumn<LoansRepaymentDetailsDTO, String> colMonthRepayment;
    public DatePicker dpDate;


    Alert alert;
    private boolean isSearchedForSetLoan = false;
    private boolean isSearchedForRepayment = false;
    private boolean isRowSelected = false;
    private boolean isDateSelected = false;

    EmployeeDTO employeeDTO;
    LoanDTO loanDTO;
    MonthlyLoansDTO monthlyLoansDTO;
    LoansRepaymentDTO loansRepaymentDTO;
    EmployeeBAO employeeBAO = AccountingBAOFactory.createEmployeeBAOImpl();
    LoanBAO loanBAO = AccountingBAOFactory.createLoanBAOImpl();
    MonthlyLoansBAO monthlyLoansBAO = AccountingBAOFactory.createMonthlyLoansBAOImpl();
    LoansRepaymentBAO loansRepaymentBAO = AccountingBAOFactory.createLoansRepaymentBAOImpl();
    LoanDetailsBAO loanDetailsBAO = AccountingBAOFactory.createLoanDetailsBAOImpl();
    LoansRepaymentDetailsBAO loansRepaymentDetailsBAO = AccountingBAOFactory.createLoansRepaymentDetailsBAOImpl();
    ObservableList<MonthlyLoansDTO> monthlyLoansObservableList;
    ObservableList<LoanDetailsDTO> loanDetailsObservableList;
    ObservableList<LoansRepaymentDetailsDTO> loansRepaymentDetailsObservableList;

    public void showMonthlyLoans(int empCode) {
        monthlyLoansObservableList = monthlyLoansBAO.search(empCode);
        colID.setCellValueFactory(new PropertyValueFactory<>("loanID"));
        colMonth.setCellValueFactory(new PropertyValueFactory<>("month"));
        colBorrowPaid.setCellValueFactory(new PropertyValueFactory<>("repaidMoney"));
        colBorrowMoney.setCellValueFactory(new PropertyValueFactory<>("monthlyLoan"));
        tvBorrow.setItems(monthlyLoansObservableList);
    }

    public void showLoanDetails(int empCode, String date) {
        loanDetailsObservableList = loanDetailsBAO.search(empCode, date);
        colMonthBorrow.setCellValueFactory(new PropertyValueFactory<>("month"));
        colBorrow.setCellValueFactory(new PropertyValueFactory<>("takenMoney"));
        colBorrowDate.setCellValueFactory(new PropertyValueFactory<>("createdAt"));
        double allTakenMoney = 0.0;
        for (LoanDetailsDTO item : loanDetailsObservableList) {
            allTakenMoney += item.getTakenMoney();
        }
        lblBorrow.setText(String.valueOf((int) allTakenMoney));
        tvBorrowForMonth.setItems(loanDetailsObservableList);
    }

    public void showLoansRepaymentDetails(int empCode, String date) {
        loansRepaymentDetailsObservableList = loansRepaymentDetailsBAO.search(empCode, date);
        colMonthRepayment.setCellValueFactory(new PropertyValueFactory<>("month"));
        colRepaymentMoney.setCellValueFactory(new PropertyValueFactory<>("repaidMoney"));
        colDateOfRepayment.setCellValueFactory(new PropertyValueFactory<>("createdAt"));
        colRemainingAmount.setCellValueFactory(new PropertyValueFactory<>("borrowedMoney"));
        tvLoanRepayment.setItems(loansRepaymentDetailsObservableList);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        numericOnly(txtSearchForSetLoan);
        numericOnly(txtBorrowMoney);
        numericOnly(txtSearchForRepayment);
        numericOnly(txtRepaymentMoney);
        loanDTO = new LoanDTO();
        loansRepaymentDTO = new LoansRepaymentDTO();
    }

    public void searchForSetLoan(ActionEvent actionEvent) {
        isSearchedForSetLoan = false;
        int searchedCode = 0;
        try {
            searchedCode = Integer.parseInt(txtSearchForSetLoan.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (searchedCode > 0) {
            employeeDTO = employeeBAO.search(String.valueOf(searchedCode));
        }
        if (employeeDTO == null) {

            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("البحث عن موظف");
            alert.setContentText("لم يتم ايجاد الموظف المرجو");
        } else {
            isSearchedForSetLoan = true;
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("البحث عن موظف");
            alert.setContentText("تم ايجاد الموظف\n" + "الاسم : " + employeeDTO.getName());
            txtNameLoansRepayment.setText(employeeDTO.getName());
            clearTableView();
        }
        alert.show();
    }

    public void setLoan(ActionEvent actionEvent) {
        int borrowMoney = 0, result = -1;
        boolean flag = false;
        try {
            borrowMoney = Integer.parseInt(txtBorrowMoney.getText());
        } catch (NumberFormatException e) {
            borrowMoney = 0;
        }
        if (!isSearchedForSetLoan || borrowMoney == 0) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("وضع سلفة");
            alert.setContentText("يجب البحث عن الموظف عن طريق الكود اولا و كتابة مبلغ اكبر من الصفر");
            alert.show();
        } else {
            loanDTO.setEmployeeID(employeeDTO.getCodeID());
            loanDTO.setBorrowedMoney(Double.parseDouble(txtBorrowMoney.getText()));
            flag = true;
            result = loanBAO.save(loanDTO);
        }
        if (result == 1 && flag) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("وضع سلفة");
            alert.setContentText("تم وضع السلفه بنجاح");
            alert.showAndWait();
            clear();
        } else if (result == -1 && flag) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("وضع سلفة");
            alert.setContentText("حدث خطأ ما الرجاء مراجعه المدخلات والتأكد من قاعدة البيانات");
            alert.showAndWait();
        }
    }

    public void cancel(ActionEvent actionEvent) {
        clear();
    }

    public void searchForEmployeeLoan(ActionEvent actionEvent) {
        isSearchedForRepayment = false;
        int searchedCode = 0;
        try {
            searchedCode = Integer.parseInt(txtSearchForRepayment.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if (searchedCode > 0) {
            employeeDTO = employeeBAO.search(String.valueOf(searchedCode));
        }
        if (employeeDTO == null) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("البحث عن موظف");
            alert.setContentText("لم يتم ايجاد الموظف المرجو");
        } else {
            isSearchedForRepayment = true;
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("البحث عن موظف");
            alert.setContentText("تم ايجاد الموظف\n" + "الاسم : " + employeeDTO.getName());
            txtNameForRepayment.setText(employeeDTO.getName());
            txtNameLoansRepayment.setText(employeeDTO.getName());
            showMonthlyLoans((int) employeeDTO.getCodeID());
            clearTableView();
        }
        alert.show();
    }

    public void getSelectedRow(MouseEvent mouseEvent) {
        isRowSelected = true;
        monthlyLoansDTO = tvBorrow.getSelectionModel().getSelectedItem();
        txtDateForRepayment.setText(monthlyLoansDTO.getMonth());

    }

    public void setLoanRepayment(ActionEvent actionEvent) {
        int result = 0;
        boolean flag = false;
        if (!isSearchedForRepayment || !isRowSelected) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("تسديد السلفة");
            alert.setContentText("يجب البحث عن الموظف عن طريق الكود اولا واختيار الشهر المرجو سداده");
            alert.show();
        } else {
            double repayment = 0.0;
            try {
                repayment = Double.parseDouble(txtRepaymentMoney.getText());
            } catch (NumberFormatException e) {
                repayment = 0.0;
            }
            if (Double.compare(repayment, 0.0) <= 0) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("تسديد السلفة");
                alert.setContentText("الرجاء ادخال رقم اكبر من الصفر");
                alert.show();
            } else if (Double.compare(repayment, (monthlyLoansDTO.getMonthlyLoan() - monthlyLoansDTO.getRepaidMoney())) > 0) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("تسديد السلفة");
                alert.setContentText("الرجاء عدم ادخال مبلغ اكبر من مبلغ السلفة");
                alert.show();
            } else {
                flag = true;
                loansRepaymentDTO.setLoanID(monthlyLoansDTO.getLoanID());
                loansRepaymentDTO.setRepaidMoney(repayment);
                result = loansRepaymentBAO.save(loansRepaymentDTO);
            }

            if (result == -1 && flag) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("تسديد السلفة");
                alert.setContentText("حدث خطأ ما الرجاء مراجعه المدخلات");
                alert.showAndWait();
            } else if (result == 1 && flag) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("تسديد السلفة");
                alert.setContentText("تم تسديد المبلغ بنجاح");
                alert.showAndWait();
                txtRepaymentMoney.clear();
                isRowSelected = false;
                showMonthlyLoans(Math.toIntExact(employeeDTO.getCodeID()));
            }
        }
    }

    public void getDP(ActionEvent actionEvent) {
        isDateSelected = true;
    }

    public void searchForDetailsRepayment(ActionEvent actionEvent) {
        if ((isSearchedForRepayment || isSearchedForSetLoan) && isDateSelected) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String selectedDate = dpDate.getValue().format(formatter);
            showLoanDetails(Math.toIntExact(employeeDTO.getCodeID()), selectedDate);
            showLoansRepaymentDetails(Math.toIntExact(employeeDTO.getCodeID()), selectedDate);
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("تفاصيل الراتب");
            alert.setContentText("يجب تحديد موظف اولا من الجدول او البحث عن الموظف عن طريق الكود واختيار التاريخ");
            alert.show();
        }
    }

    private void clear() {
        txtSearchForSetLoan.clear();
        txtBorrowMoney.clear();
        txtSearchForRepayment.clear();
        txtRepaymentMoney.clear();
        txtNameForRepayment.clear();
        txtDateForRepayment.clear();
        isSearchedForSetLoan = false;
        isSearchedForRepayment = false;
    }

    private void clearTableView() {
        tvLoanRepayment.getItems().clear();
        tvBorrowForMonth.getItems().clear();
        isDateSelected = false;
        lblBorrow.setText("");
    }
}
