package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sample.bao.accountingdetails.AccountingDetailsBAO;
import sample.bao.employee.EmployeeBAO;
import sample.bao.employeeanddepartment.EmployeeANDDepartmentBAO;
import sample.bao.loandetails.LoanDetailsBAO;
import sample.bao.monthlyreport.MonthlyReportBAO;
import sample.bao.salariesandsalarydetails.SalariesANDSalaryDetailsBAO;
import sample.common.bao.AccountingBAOFactory;
import sample.common.util.Constants;
import sample.dto.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import static sample.common.util.Constants.numericOnly;

public class EmployeeController implements Initializable {

    public TableView<EmployeeANDDepartmentDTO> tvEmployee;
    public TableColumn<EmployeeANDDepartmentDTO, Long> colNumberOfHours;
    public TableColumn<EmployeeANDDepartmentDTO, Double> colMonthlySalary;
    public TableColumn<EmployeeANDDepartmentDTO, String> colPhone;
    public TableColumn<EmployeeANDDepartmentDTO, String> colDate;
    public TableColumn<EmployeeANDDepartmentDTO, String> colDepartment;
    public TableColumn<EmployeeANDDepartmentDTO, String> colName;
    public TableColumn<EmployeeANDDepartmentDTO, Long> colID;
    public TextField txtSearchEmployee;

    public TableView<SalariesANDSalaryDetailsDTO> tvSalaryDetails;
    public TableColumn<SalariesANDSalaryDetailsDTO, Double> colCurrentSalary;
    public TableColumn<SalariesANDSalaryDetailsDTO, String> colPaidDate;
    public TableColumn<SalariesANDSalaryDetailsDTO, Double> colSalaryPaid;
    public TableColumn<SalariesANDSalaryDetailsDTO, String> colMonthSalary;

    public Label lblDiscount;
    public Label lblBonus;

    public TableView<AccountingDetailsDTO> tvBonus;
    public TableColumn<AccountingDetailsDTO, String> colStatusDate;
    public TableColumn<AccountingDetailsDTO, String> colStatus;
    public TableColumn<AccountingDetailsDTO, Integer> colNumberHours;
    public TableColumn<AccountingDetailsDTO, String> colMonth;


    public Label lblBorrow;

    public TableView<LoanDetailsDTO> tvBorrow;
    public TableColumn<LoanDetailsDTO, String> colBorrowDate;
    public TableColumn<LoanDetailsDTO, Double> colBorrow;
    public TableColumn<LoanDetailsDTO, String> colMonthBorrow;

    public TableView <MonthlyReportDTO>tvMonthlyReport;
    public TableColumn <MonthlyReportDTO, Long> colRID;
    public TableColumn <MonthlyReportDTO, String> colRName;
    public TableColumn <MonthlyReportDTO, String> colRDeptName;
    public TableColumn <MonthlyReportDTO, String> colRHiringDate;
    public TableColumn <MonthlyReportDTO, Double> colRBasicSalary;
    public TableColumn <MonthlyReportDTO, Double> colRMonthlySalary;
    public TableColumn <MonthlyReportDTO, Double> colRBonus;
    public TableColumn <MonthlyReportDTO, Double> colRDiscount;
    public TableColumn <MonthlyReportDTO, Double> colRLoan;
    public TableColumn <MonthlyReportDTO,String> colRDate;

    public JFXButton btnSearchSalaries;
    public DatePicker dpDate;
    public TextField txtCodeSalaries;

    private Stage Stage;
    FXMLLoader loader;
    Alert alert;
    Constants constants = new Constants();
    boolean isRowSelected, isSearched;
    private boolean isDateSelected;

    EmployeeANDDepartmentDTO employeeANDDepartmentDTO = new EmployeeANDDepartmentDTO();
    MonthlyReportDTO monthlyReportDTO = new MonthlyReportDTO();

    EmployeeBAO employeeBAO = AccountingBAOFactory.createEmployeeBAOImpl();
    EmployeeANDDepartmentBAO employeeANDDepartmentBAO = AccountingBAOFactory.createEmployeeANDDepartmentBAOImpl();
    SalariesANDSalaryDetailsBAO salariesANDSalaryDetailsBAO = AccountingBAOFactory.createSalarysDtoSalaryDetailsBAOImpl();
    AccountingDetailsBAO accountingDetailsBAO = AccountingBAOFactory.createAccountingDetailsBAOImpl();
    LoanDetailsBAO loanDetailsBAO = AccountingBAOFactory.createLoanDetailsBAOImpl();
    MonthlyReportBAO monthlyReportBAO = AccountingBAOFactory.createMonthlyReportBAOImpl();
    ObservableList<MonthlyReportDTO> monthlyReportObservableList = FXCollections.observableArrayList();

    ObservableList<EmployeeANDDepartmentDTO> employeeANDDepartmentObservableList;
    ObservableList<SalariesANDSalaryDetailsDTO> salarysANDSalaryDetailsObservableList;
    ObservableList<AccountingDetailsDTO> accountingDetailsObservableList;
    ObservableList<LoanDetailsDTO> loanDetailsObservableList;

    public void showEmployeeList() throws SQLException {
        employeeANDDepartmentObservableList = employeeANDDepartmentBAO.listAll();
        colID.setCellValueFactory(new PropertyValueFactory<>("codeID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDepartment.setCellValueFactory(new PropertyValueFactory<>("departmentName"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("dateOfEmployment"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colMonthlySalary.setCellValueFactory(new PropertyValueFactory<>("basicSalary"));
        colNumberOfHours.setCellValueFactory(new PropertyValueFactory<>("numberOfHours"));
        tvEmployee.setItems(employeeANDDepartmentObservableList);
    }

    public void showSalarysANDSalaryDetails(int empCode, String date) {
        salarysANDSalaryDetailsObservableList = salariesANDSalaryDetailsBAO.search(empCode, date);
        colMonthSalary.setCellValueFactory(new PropertyValueFactory<>("month"));
        colSalaryPaid.setCellValueFactory(new PropertyValueFactory<>("takenSalary"));
        colPaidDate.setCellValueFactory(new PropertyValueFactory<>("createdAt"));
        colCurrentSalary.setCellValueFactory(new PropertyValueFactory<>("monthlySalary"));
        tvSalaryDetails.setItems(salarysANDSalaryDetailsObservableList);
    }

    public void showAccountingDetails(int empCode, String date) {
        accountingDetailsObservableList = accountingDetailsBAO.search(empCode, date);
        colMonth.setCellValueFactory(new PropertyValueFactory<>("month"));
        colNumberHours.setCellValueFactory(new PropertyValueFactory<>("hours"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colStatusDate.setCellValueFactory(new PropertyValueFactory<>("createdAt"));
        tvBonus.setItems(accountingDetailsObservableList);
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
        tvBorrow.setItems(loanDetailsObservableList);
    }

    public void showMonthlyReport(int id) throws SQLException {
        monthlyReportObservableList = monthlyReportBAO.search((int) employeeANDDepartmentDTO.getCodeID());
        colRID.setCellValueFactory(new PropertyValueFactory<>("empCode"));
        colRName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colRDeptName.setCellValueFactory(new PropertyValueFactory<>("depName"));
        colRHiringDate.setCellValueFactory(new PropertyValueFactory<>("dateOfEmployment"));
        colRBasicSalary.setCellValueFactory(new PropertyValueFactory<>("basicSalary"));
        colRMonthlySalary.setCellValueFactory(new PropertyValueFactory<>("monthlySalary"));
        colRBonus.setCellValueFactory(new PropertyValueFactory<>("monthlyBonus"));
        colRDiscount.setCellValueFactory(new PropertyValueFactory<>("monthlyDiscount"));
        colRLoan.setCellValueFactory(new PropertyValueFactory<>("monthlyBorrowedMoney"));
        colRDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tvMonthlyReport.setItems(monthlyReportObservableList);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        numericOnly(txtSearchEmployee);
        employeeANDDepartmentDTO = null;
        isRowSelected = false;
        isSearched = false;
        try {
            showEmployeeList();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void search(ActionEvent actionEvent) throws SQLException {
        isSearched = false;
        int searchedCode = Integer.parseInt(txtSearchEmployee.getText());
        if (searchedCode > 0) {
            employeeANDDepartmentDTO = employeeANDDepartmentBAO.search(String.valueOf(searchedCode));
            txtCodeSalaries.setText(employeeANDDepartmentDTO.getName());
        }
        if (employeeANDDepartmentDTO == null) {

            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("البحث عن موظف");
            alert.setContentText("لم يتم ايجاد الموظف المرجو");
        } else {
            isSearched = true;
            clearTableView();
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("البحث عن موظف");
            alert.setContentText("تم ايجاد الموظف\n" + "الاسم : " + employeeANDDepartmentDTO.getName() + "\nالقسم : " + employeeANDDepartmentDTO.getDepartmentName());
            showMonthlyReport((int) employeeANDDepartmentDTO.getCodeID());

        }
        alert.show();
    }

    public void getSelectedRow() throws SQLException {
        isRowSelected = true;
        clearTableView();
        employeeANDDepartmentDTO = tvEmployee.getSelectionModel().getSelectedItem();
        txtCodeSalaries.setText(employeeANDDepartmentDTO.getName());
        showMonthlyReport((int) employeeANDDepartmentDTO.getCodeID());

    }

    public void addEmployee(ActionEvent actionEvent) throws IOException {
        loader = constants.loadPage("AddAndEditEmployee", "اضافة موظف");
        AddAndEditEmployeeController addAndEditEmployeeController = loader.getController();
        addAndEditEmployeeController.initValue(employeeANDDepartmentDTO, true);
    }

    public void editEmployee(ActionEvent actionEvent) throws IOException {
        if (isRowSelected || isSearched) {
            loader = constants.loadPage("AddAndEditEmployee", "تعديل موظف");
            AddAndEditEmployeeController addAndEditEmployeeController = loader.getController();
            addAndEditEmployeeController.initValue(employeeANDDepartmentDTO, false);
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("تعديل موظف");
            alert.setContentText("يجب تحديد موظف اولا من الجدول او البحث عن الموظف عن طريق الكود");
            alert.show();
        }

    }

    public void deleteEmployee(ActionEvent actionEvent) {
        if (isRowSelected || isSearched) {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("حذف الموظف");
            alert.setContentText("هل انت متأكد من حذف هذا الموظف ؟");
            ButtonType okButton = new ButtonType("نعم", ButtonBar.ButtonData.YES);
            ButtonType noButton = new ButtonType("لا", ButtonBar.ButtonData.NO);
            ButtonType cancelButton = new ButtonType("الغاء", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(okButton, noButton, cancelButton);
            alert.showAndWait().ifPresent(type -> {
                if (type == okButton) {
                    boolean flagResultOfDelete = false;
                    flagResultOfDelete = employeeBAO.delete(String.valueOf(employeeANDDepartmentDTO.getCodeID()));
                    if (flagResultOfDelete) {
                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("حذف الموظف");
                        alert.setContentText("تم حذف الموظف بنجاح");
                        try {
                            showEmployeeList();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("حذف الموظف");
                    alert.setContentText("لم يتم حذف الموظف");
                }
            });
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("حذف الموظف");
            alert.setContentText("يجب تحديد موظف اولا من الجدول او البحث عن الموظف عن طريق الكود");
        }
        alert.show();
    }

    public void getDP(ActionEvent actionEvent) {
        isDateSelected = true;
    }

    public void searchSalaries(ActionEvent actionEvent) {
        if ((isRowSelected || isSearched) && isDateSelected) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String selectedDate = dpDate.getValue().format(formatter);
            String date = LocalDate.now().format(formatter);
            showSalarysANDSalaryDetails(Math.toIntExact(employeeANDDepartmentDTO.getCodeID()), selectedDate);
            showAccountingDetails(Math.toIntExact(employeeANDDepartmentDTO.getCodeID()), selectedDate);
            showLoanDetails(Math.toIntExact(employeeANDDepartmentDTO.getCodeID()), selectedDate);
            monthlyReportDTO = monthlyReportBAO.search(Math.toIntExact(employeeANDDepartmentDTO.getCodeID()), selectedDate);
            lblBonus.setText(String.valueOf((int) monthlyReportDTO.getMonthlyBonus()));
            lblDiscount.setText(String.valueOf((int) monthlyReportDTO.getMonthlyDiscount()));
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("تفاصيل الراتب");
            alert.setContentText("يجب تحديد موظف اولا من الجدول او البحث عن الموظف عن طريق الكود واختيار التاريخ");
            alert.show();
        }

    }

    private void clearTableView() {
        tvSalaryDetails.getItems().clear();
        tvBonus.getItems().clear();
        tvBorrow.getItems().clear();
        tvMonthlyReport.getItems().clear();
        lblDiscount.setText("");
        lblBorrow.setText("");
        lblBonus.setText("");
    }

    public void exportEmployeeToExcel(ActionEvent actionEvent) throws IOException {
        if (!tvEmployee.getItems().isEmpty()) {
            try {
                XSSFWorkbook wb = new XSSFWorkbook();
                XSSFSheet sheet = wb.createSheet("Employee Report");

                XSSFRow header = sheet.createRow(0);
                for (int j = 0; j < tvEmployee.getColumns().size(); j++) {
                    header.createCell(j).setCellValue(tvEmployee.getColumns().get(j).getText());
                }

                for (int i = 0; i < tvEmployee.getItems().size(); i++) {
                    header = sheet.createRow(i + 1);
                    for (int j = 0; j < tvEmployee.getColumns().size(); j++) {
                        if (tvEmployee.getColumns().get(j).getCellData(i) != null) {
                            header.createCell(j).setCellValue(tvEmployee.getColumns().get(j).getCellData(i).toString());
                            sheet.autoSizeColumn(j);
                        } else {
                            header.createCell(j).setCellValue("");
                        }
                    }
                }

                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.xlsx");
                fileChooser.getExtensionFilters().add(extFilter);

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Views/Report.fxml"));
                Parent root1 = loader.load();
                ReportController controller = loader.getController();
                Stage stage = new Stage();
                stage.initModality(Modality.WINDOW_MODAL);
                stage.setScene(new Scene(root1));

                File file = fileChooser.showSaveDialog(Stage);
                FileOutputStream outputStream = new FileOutputStream(file.getAbsolutePath());
                wb.write(outputStream);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("استخراج ملف اكسيل");
                alert.setContentText("تم الاستخراج بنجاح!");
                alert.show();

                outputStream.close();
                wb.close();

            } catch (FileNotFoundException e) {

            }
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("استخراج تقرير الي ملف اكسيل");
            alert.setContentText("لا يوجد موظفين حاليا للاستخراج");
            alert.show();
        }

    }

    public void exportDetailsToExcel(ActionEvent actionEvent) throws IOException {
        if (isRowSelected || isDateSelected) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String selectedDate = dpDate.getValue().format(formatter);
                XSSFWorkbook wb = new XSSFWorkbook();
                XSSFSheet sheet = wb.createSheet("Details Report");

                int row = 0;
                int column = 0;
                XSSFRow header = sheet.createRow(row++);
                header.createCell(column++).setCellValue("التاريخ");
                header.createCell(column++).setCellValue("الراتب الاساسي");
                header.createCell(column++).setCellValue("القسم");
                header.createCell(column++).setCellValue("الاسم");
                header.createCell(column++).setCellValue("الكود");
                header = sheet.createRow(row++);
                column=0;
                header.createCell(column++).setCellValue(selectedDate);
                header.createCell(column++).setCellValue(employeeANDDepartmentDTO.getBasicSalary());
                header.createCell(column++).setCellValue(employeeANDDepartmentDTO.getDepartmentName());
                header.createCell(column++).setCellValue(employeeANDDepartmentDTO.getName());
                header.createCell(column++).setCellValue(employeeANDDepartmentDTO.getCodeID());
                header = sheet.createRow(row++);
                header = sheet.createRow(row++);
                column=0;
                header.createCell(column++).setCellValue(" تفاصيل الراتب لتاريخ "+selectedDate);
                header = sheet.createRow(row++);
                for (int j = 0; j < tvSalaryDetails.getColumns().size(); j++) {
                    header.createCell(j).setCellValue(tvSalaryDetails.getColumns().get(j).getText());
                }
                for (int i = 0; i < tvSalaryDetails.getItems().size(); i++) {
                    header = sheet.createRow(row++);
                    for (int j = 0; j < tvSalaryDetails.getColumns().size(); j++) {
                        if (tvSalaryDetails.getColumns().get(j).getCellData(i) != null) {
                            header.createCell(j).setCellValue(tvSalaryDetails.getColumns().get(j).getCellData(i).toString());
                            sheet.autoSizeColumn(j);
                        } else {
                            header.createCell(j).setCellValue("");
                        }
                    }
                }
                header = sheet.createRow(row++);
                header = sheet.createRow(row++);
                column=0;
                header.createCell(column++).setCellValue(" تفاصيل المكافأت والخصومات لتاريخ "+selectedDate);
                header = sheet.createRow(row++);
                column=0;
                header.createCell(column++).setCellValue("خصومات");
                header.createCell(column++).setCellValue("مكافأت");
                header = sheet.createRow(row++);
                column=0;
                header.createCell(column++).setCellValue(lblDiscount.getText());
                header.createCell(column++).setCellValue(lblBonus.getText());
                header = sheet.createRow(row++);
                for (int j = 0; j < tvBonus.getColumns().size(); j++) {
                    header.createCell(j).setCellValue(tvBonus.getColumns().get(j).getText());
                }
                for (int i = 0; i < tvBonus.getItems().size(); i++) {
                    header = sheet.createRow(row++);
                    for (int j = 0; j < tvBonus.getColumns().size(); j++) {
                        if (tvBonus.getColumns().get(j).getCellData(i) != null) {
                            header.createCell(j).setCellValue(tvBonus.getColumns().get(j).getCellData(i).toString());
                            sheet.autoSizeColumn(j);
                        } else {
                            header.createCell(j).setCellValue("");
                        }
                    }
                }
                header = sheet.createRow(row++);
                header = sheet.createRow(row++);
                column=0;
                header.createCell(column++).setCellValue(" تفاصيل السلف لتاريخ "+selectedDate);
                header = sheet.createRow(row++);
                column=0;
                header.createCell(column++).setCellValue("السلف");
                header = sheet.createRow(row++);
                column=0;
                header.createCell(column++).setCellValue(lblBorrow.getText());
                header = sheet.createRow(row++);
                for (int j = 0; j < tvBorrow.getColumns().size(); j++) {
                    header.createCell(j).setCellValue(tvBorrow.getColumns().get(j).getText());
                }
                for (int i = 0; i < tvBorrow.getItems().size(); i++) {
                    header = sheet.createRow(row++);
                    for (int j = 0; j < tvBorrow.getColumns().size(); j++) {
                        if (tvBorrow.getColumns().get(j).getCellData(i) != null) {
                            header.createCell(j).setCellValue(tvBorrow.getColumns().get(j).getCellData(i).toString());
                            sheet.autoSizeColumn(j);
                        } else {
                            header.createCell(j).setCellValue("");
                        }
                    }
                }

                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.xlsx");
                fileChooser.getExtensionFilters().add(extFilter);

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Views/Report.fxml"));
                Parent root1 = loader.load();
                ReportController controller = loader.getController();
                Stage stage = new Stage();
                stage.initModality(Modality.WINDOW_MODAL);
                stage.setScene(new Scene(root1));

                File file = fileChooser.showSaveDialog(Stage);
                FileOutputStream outputStream = new FileOutputStream(file.getAbsolutePath());
                wb.write(outputStream);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("استخراج ملف اكسيل");
                alert.setContentText("تم الاستخراج بنجاح!");
                alert.show();

                outputStream.close();
                wb.close();

            } catch (FileNotFoundException e) {

            }
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("استخراج تقرير الي ملف اكسيل");
            alert.setContentText("لا يوجد موظفين حاليا للاستخراج");
            alert.show();
        }
    }

    public void exportEmployeeHistoryToExcel(ActionEvent actionEvent) throws IOException{
        if ((isRowSelected ||isSearched )&& !tvMonthlyReport.getItems().isEmpty()){
            try {
                XSSFWorkbook wb = new XSSFWorkbook();
                XSSFSheet sheet = wb.createSheet("History Report");

                XSSFRow header = sheet.createRow(0);
                for (int j = 0; j < tvMonthlyReport.getColumns().size(); j++) {
                    header.createCell(j).setCellValue(tvMonthlyReport.getColumns().get(j).getText());
                }

                for (int i = 0; i < tvMonthlyReport.getItems().size(); i++) {
                    header = sheet.createRow(i + 1);
                    for (int j = 0; j < tvMonthlyReport.getColumns().size(); j++) {
                        if(tvMonthlyReport.getColumns().get(j).getCellData(i) != null) {
                            header.createCell(j).setCellValue(tvMonthlyReport.getColumns().get(j).getCellData(i).toString());
                            sheet.autoSizeColumn(j);
                        }
                        else {
                            header.createCell(j).setCellValue("");
                        }
                    }
                }

                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.xlsx");
                fileChooser.getExtensionFilters().add(extFilter);

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Views/Report.fxml"));
                Parent root1 = loader.load();
                ReportController controller =loader.getController();
                Stage stage = new Stage();
                stage.initModality(Modality.WINDOW_MODAL);
                stage.setScene(new Scene(root1));

                File file = fileChooser.showSaveDialog(Stage);
                FileOutputStream outputStream = new FileOutputStream(file.getAbsolutePath());
                wb.write(outputStream);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("استخراج ملف اكسيل");
                alert.setContentText("تم الاستخراج بنجاح!");
                alert.show();

                outputStream.close();
                wb.close();

            } catch (FileNotFoundException e) {

            }
        }
        else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("استخراج تقرير الي ملف اكسيل");
            alert.setContentText("يجب تحديد التاريخ اولا");
            alert.show();
        }
    }
}
