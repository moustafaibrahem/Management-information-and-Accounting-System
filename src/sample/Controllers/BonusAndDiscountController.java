package sample.Controllers;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import sample.bao.accounting.AccountingBAO;
import sample.bao.employee.EmployeeBAO;
import sample.common.bao.AccountingBAOFactory;
import sample.dto.AccountingDTO;
import sample.dto.EmployeeDTO;

import java.net.URL;
import java.util.ResourceBundle;

import static sample.common.util.Constants.numericOnly;

public class BonusAndDiscountController implements Initializable {
    public TextField txtNumberHours;
    public TextField txtSearch;
    public JFXComboBox cmbBonusOrDiscount;
    Alert alert;

    private boolean isSearched = false;
    private boolean isBonusOrDiscountSelected = false;

    EmployeeDTO employeeDTO;
    AccountingDTO accountingDTO;
    EmployeeBAO employeeBAO = AccountingBAOFactory.createEmployeeBAOImpl();
    AccountingBAO accountingBAO = AccountingBAOFactory.createAccountingBAOImpl();
    ObservableList<String> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        numericOnly(txtSearch);
        numericOnly(txtNumberHours);
        list.add("مكافأة");
        list.add("خصم");
        cmbBonusOrDiscount.setItems(FXCollections.observableArrayList(list));
    }

    public void search(ActionEvent actionEvent) {
        isSearched = false;
        int searchedCode = 0;
        try {
            searchedCode = Integer.parseInt(txtSearch.getText());
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
            isSearched = true;
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("البحث عن موظف");
            alert.setContentText("تم ايجاد الموظف\n" + "الاسم : " + employeeDTO.getName());
        }
        alert.show();
    }


    public void selectedBonusOrDiscount(ActionEvent actionEvent) {
        isBonusOrDiscountSelected = true;
    }

    public void save(ActionEvent actionEvent) {
        int numberOfHour = 0,result = -1;
        boolean flag = false;
        try {
            numberOfHour = Integer.parseInt(txtNumberHours.getText());
        } catch (NumberFormatException e) {
            numberOfHour = 0;
        }
        if (!isSearched || !isBonusOrDiscountSelected || numberOfHour == 0) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("اضافة مكافأه او خصم");
            alert.setContentText("يجب البحث عن الموظف عن طريق الكود اولا واختيار الحاله و كتابة رقم اكبر من الصفر");
            alert.show();
        } else {
            accountingDTO = new AccountingDTO();
            accountingDTO.setEmployeeID(Long.parseLong(txtSearch.getText()));
            accountingDTO.setHours(Integer.parseInt(txtNumberHours.getText()));
            accountingDTO.setStatus(cmbBonusOrDiscount.getValue().equals("مكافأة") ? 1 : 0);
            flag = true;
            result = accountingBAO.save(accountingDTO);
        }
        if (result == 1 && flag){
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("اضافة مكافأه او خصم");
            alert.setContentText("تم اضافة ال"+cmbBonusOrDiscount.getValue()+" بنجاح");
            alert.showAndWait();
            clear();
        }
        else if (result == -1 && flag) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("اضافة مكافأه او خصم");
            alert.setContentText("حدث خطأ ما الرجاء مراجعه المدخلات والتأكد من قاعدة البيانات");
            alert.showAndWait();
        }

    }

    public void cancel(ActionEvent actionEvent) {
        clear();
    }

    private void clear() {
        txtSearch.clear();
        txtNumberHours.clear();
        cmbBonusOrDiscount.setValue("");
        isSearched = false;
        isBonusOrDiscountSelected = false;
    }
}
