package sample.Controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.bao.employee.EmployeeBAO;
import sample.bao.monthlysalaries.MonthlySalariesBAO;
import sample.bao.salarydetails.SalaryDetailsBAO;
import sample.common.bao.AccountingBAOFactory;
import sample.dto.EmployeeDTO;
import sample.dto.MonthlySalariesDTO;
import sample.dto.SalaryDetailsDTO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static sample.common.util.Constants.numericOnly;

public class AccountingController implements Initializable {

    public TableView<MonthlySalariesDTO> tvAccounting;
    public TableColumn<MonthlySalariesDTO, Double> colCurrentSalary;
    public TableColumn<MonthlySalariesDTO, Double> colSalaryPaid;
    public TableColumn<MonthlySalariesDTO, String> colMonth;
    public TableColumn<MonthlySalariesDTO, Long> colID;
    public TextField txtSearch;
    public TextField txtMoney;
    public TextField txtDate;
    public TextField txtName;
    public TextField txtReservedSalary;

    private boolean isSearched;
    private boolean isRowSelected;
    EmployeeDTO employeeDTO;
    SalaryDetailsDTO salaryDetailsDTO;
    MonthlySalariesDTO monthlySalariesDTO;
    EmployeeBAO employeeBAO = AccountingBAOFactory.createEmployeeBAOImpl();
    MonthlySalariesBAO monthlySalariesBAO = AccountingBAOFactory.createMonthlySalariesBAOImpl();
    SalaryDetailsBAO salaryDetailsBAO = AccountingBAOFactory.createSalaryDetailsBAOImpl();
    ObservableList<MonthlySalariesDTO> monthlySalariesObservableList;
    Alert alert;

    public void showMonthlySalariesList(int empCode) throws SQLException {
        monthlySalariesObservableList = monthlySalariesBAO.search(empCode);
        colID.setCellValueFactory(new PropertyValueFactory<>("salarysID"));
        colMonth.setCellValueFactory(new PropertyValueFactory<>("month"));
        colSalaryPaid.setCellValueFactory(new PropertyValueFactory<>("takenSalary"));
        colCurrentSalary.setCellValueFactory(new PropertyValueFactory<>("monthlySalary"));
        tvAccounting.setItems(monthlySalariesObservableList);
        double reservedSalary = 0.0;
        for (MonthlySalariesDTO item : monthlySalariesObservableList) {
            reservedSalary += item.getMonthlySalary() - item.getTakenSalary();
        }
        txtReservedSalary.setText(String.valueOf(Math.round(reservedSalary)));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        numericOnly(txtSearch);
        numericOnly(txtMoney);
        numericOnly(txtReservedSalary);
        salaryDetailsDTO = new SalaryDetailsDTO();
    }

    public void search(ActionEvent actionEvent) throws SQLException {
        tvAccounting.getItems().clear();
        isSearched = false;
        int searchedCode = 0;
        try {
            searchedCode = Integer.parseInt(txtSearch.getText());
        } catch (NumberFormatException e) {
            searchedCode = 0;
        }

        if (searchedCode > 0) {
            employeeDTO = employeeBAO.search(String.valueOf(searchedCode));
        }
        if (employeeDTO == null) {

            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("?????????? ???? ????????");
            alert.setContentText("???? ?????? ?????????? ???????????? ????????????");
        }
        else {
            isSearched = true;
            showMonthlySalariesList(Math.toIntExact(employeeDTO.getCodeID()));
            txtName.setText(employeeDTO.getName());
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("?????????? ???? ????????");
            alert.setContentText("???? ?????????? ????????????\n" + "?????????? : " + employeeDTO.getName());
        }
        alert.show();
    }

    public void getSelectedRow() {
        isRowSelected = true;
        monthlySalariesDTO = tvAccounting.getSelectionModel().getSelectedItem();
        txtDate.setText(monthlySalariesDTO.getMonth());
    }

    public void setMoney(ActionEvent actionEvent) throws SQLException {
        int result = 0;
        boolean flag = false;
        if (!isSearched || !isRowSelected) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("?????????? ????????");
            alert.setContentText("?????? ?????????? ???? ???????????? ???? ???????? ?????????? ???????? ?????????????? ?????????? ???????????? ??????????");
            alert.show();
        } else {
            if (Double.parseDouble(txtMoney.getText()) <= 0) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("?????????? ????????");
                alert.setContentText("???????????? ?????????? ?????? ???????? ???? ??????????");
                alert.show();
            } else if (Double.compare(Double.parseDouble(txtMoney.getText()), (monthlySalariesDTO.getMonthlySalary() - monthlySalariesDTO.getTakenSalary())) > 0) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("?????????? ????????");
                alert.setContentText("???????????? ?????? ?????????? ???????? ???????? ???? ?????????????? ????");
                alert.show();
            } else {
                flag = true;
                salaryDetailsDTO.setSalarysID(monthlySalariesDTO.getSalarysID());
                salaryDetailsDTO.setTakenSalary(Double.parseDouble(txtMoney.getText()));
                result = salaryDetailsBAO.save(salaryDetailsDTO);
            }

            if (result == -1 && flag) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("?????????? ????????");
                alert.setContentText("?????? ?????? ???? ???????????? ???????????? ????????????????");
                alert.showAndWait();
            } else if (result == 1 && flag) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("?????????? ????????");
                alert.setContentText("???? ?????????? ???????????? ??????????");
                alert.showAndWait();
                txtMoney.clear();
                isRowSelected = false;
                showMonthlySalariesList(Math.toIntExact(employeeDTO.getCodeID()));
            }
        }


    }
}
