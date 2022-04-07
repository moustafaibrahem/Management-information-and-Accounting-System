package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import sample.bao.employeeanddepartment.EmployeeANDDepartmentBAO;
import sample.bao.hourprice.HourPriceBAO;
import sample.bao.salaries.SalariesBAO;
import sample.common.bao.AccountingBAOFactory;
import sample.dto.EmployeeANDDepartmentDTO;
import sample.dto.HourPriceDTO;
import sample.dto.SalariesDTO;

import static sample.common.util.Constants.numericOnly;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;


public class MainController implements Initializable {

    public Tab tabHome;
    public JFXButton btnAddSalary;
    public Tab tabHour;
    public TextField txtHour;
    public JFXButton btnCancel;
    public JFXButton btnSave;

    HourPriceDTO hourPriceDTO = new HourPriceDTO();

    HourPriceBAO hourPriceBAO = AccountingBAOFactory.createHourPriceBAOImpl();
    SalariesBAO salariesBAO = AccountingBAOFactory.createSalarysBAOImpl();
    EmployeeANDDepartmentBAO employeeANDDepartmentBAO = AccountingBAOFactory.createEmployeeANDDepartmentBAOImpl();

    ObservableList<EmployeeANDDepartmentDTO> employeeANDDepartmentObservableList;
    SalariesDTO salariesDTO;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        numericOnly(txtHour);
    }

    public void setNewHourPrice(ActionEvent actionEvent) {
        int result = 0;
        hourPriceDTO.setPrice(Double.parseDouble(txtHour.getText()));
        result = hourPriceBAO.save(hourPriceDTO);

        Alert alert;
        if (result == 1) {
            txtHour.clear();
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ادخال سعر ساعه جديد");
            alert.setContentText("تم تجديد سعر الساعه بنجاح!");
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ادخال سعر ساعه جديد");
            alert.setContentText("يجب التحقق من ادخال رقم صحيح أكبر من الصفر");
        }
        alert.show();
    }

    public void clearTxt(ActionEvent actionEvent) {
        txtHour.clear();
    }

    public void setSalaries(ActionEvent actionEvent) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = LocalDate.now().format(formatter);
        int result = -1;
        salariesDTO = new SalariesDTO();
        employeeANDDepartmentObservableList = employeeANDDepartmentBAO.listAll();
        for (EmployeeANDDepartmentDTO item : employeeANDDepartmentObservableList) {
            result = -1;
            salariesDTO.setEmployeeID(item.getCodeID());
            result = salariesBAO.save(salariesDTO);
        }
        if (result == 1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("تنزيل الرواتب");
            alert.setContentText("تم تنزيل الرواتب بنجاح لشهر " + date);
            alert.show();
        }
    }
}
