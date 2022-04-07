package sample.Controllers;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import sample.bao.department.DepartmentBAO;
import sample.bao.employee.EmployeeBAO;
import sample.common.bao.AccountingBAOFactory;
import sample.dto.DepartmentDTO;
import sample.dto.EmployeeANDDepartmentDTO;
import sample.dto.EmployeeDTO;


import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import static sample.common.util.Constants.numericOnly;

public class AddAndEditEmployeeController implements Initializable {
    public TextField txtCode;
    public TextField txtName;
    public TextField txtSalary;
    public TextField txtPhone;
    public TextField txtNumberOfHours;
    public DatePicker dpDate;
    public JFXComboBox cmbDepartment;
    Alert alert;


    DepartmentBAO departmentBAO = AccountingBAOFactory.createDepartmentBAOImpl();
    EmployeeBAO employeeBAO = AccountingBAOFactory.createEmployeeBAOImpl();

    EmployeeANDDepartmentDTO employeeANDDepartmentDTO;
    EmployeeDTO employeeDTO;

    ObservableList<DepartmentDTO> departmentObservableList;
    ObservableList<String> departmentNameObservableList = FXCollections.observableArrayList();

    boolean isAddEmployee = true;
    boolean isDepartmentSelected = false;
    boolean isDateSelected = false;

    public void initValue(EmployeeANDDepartmentDTO employeeANDDepartmentDTO, boolean isAdd) {
        this.employeeANDDepartmentDTO = employeeANDDepartmentDTO;
        isAddEmployee = isAdd;
        if (!isAddEmployee) {
            txtName.setText(employeeANDDepartmentDTO.getName());
            txtSalary.setText(String.valueOf((int)employeeANDDepartmentDTO.getBasicSalary()));
            txtPhone.setText(employeeANDDepartmentDTO.getPhone());
            txtNumberOfHours.setText(String.valueOf(employeeANDDepartmentDTO.getNumberOfHours()));
            cmbDepartment.setValue(employeeANDDepartmentDTO.getDepartmentName());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        numericOnly(txtCode);
        numericOnly(txtSalary);
        numericOnly(txtPhone);
        numericOnly(txtNumberOfHours);
        departmentObservableList = departmentBAO.listAll();
        for (DepartmentDTO item : departmentObservableList) {
            departmentNameObservableList.add(item.getDepartmentName());
        }
        cmbDepartment.setItems(departmentNameObservableList);
    }

    public void selectedDepartment(ActionEvent actionEvent) {
        isDepartmentSelected = true;

    }

    public void getDP(ActionEvent actionEvent) {
        isDateSelected = true;

    }

    public void save(ActionEvent actionEvent) {
        employeeDTO = new EmployeeDTO();
        int result = 0;
        boolean flag = false;
        if (isAddEmployee){
            employeeDTO.setName(txtName.getText());
            employeeDTO.setPhone(txtPhone.getText());
            if (employeeDTO.getName().isEmpty() || employeeDTO.getPhone().isEmpty() || !isDateSelected || !isDepartmentSelected){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("حفظ البيانات");
                alert.setContentText("الرجاء ملء جميع البيانات");
                alert.showAndWait();
            }
            else {
                flag = true;
                String admittedDate = dpDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                employeeDTO.setCodeID(Long.parseLong(txtCode.getText()));
                employeeDTO.setBasicSalary(Double.parseDouble(txtSalary.getText()));
                employeeDTO.setDateOfEmployment(admittedDate);
                employeeDTO.setNumberOfHours(Long.parseLong(txtNumberOfHours.getText()));
                for (DepartmentDTO item : departmentObservableList) {
                    if (item.getDepartmentName().equals(String.valueOf(cmbDepartment.getValue())))
                        employeeDTO.setDepartmentID(item.getDepartmentID());
                }
                result = employeeBAO.save(employeeDTO);
            }

        }
        else if (!isAddEmployee){
            //edit
            employeeDTO.setEmployeeID(employeeANDDepartmentDTO.getCodeID());
            employeeDTO.setName(txtName.getText());
            employeeDTO.setPhone(txtPhone.getText());
            for (DepartmentDTO item : departmentObservableList) {
                if (item.getDepartmentName().equals(String.valueOf(cmbDepartment.getValue())))
                    employeeDTO.setDepartmentID(item.getDepartmentID());
            }
            if (employeeDTO.getName().isEmpty() || employeeDTO.getPhone().isEmpty() || !isDepartmentSelected){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("حفظ تعديل البيانات");
                alert.setContentText("الرجاء ملء جميع البيانات");
                alert.showAndWait();
            }
            else if (   employeeDTO.getName().equals(employeeANDDepartmentDTO.getName())
                    &&  employeeDTO.getPhone().equals(employeeANDDepartmentDTO.getPhone())
                    &&  String.valueOf(cmbDepartment.getValue()).equals(employeeANDDepartmentDTO.getDepartmentName())
                    &&  Double.compare(Double.parseDouble(txtSalary.getText()),employeeANDDepartmentDTO.getBasicSalary()) == 0
                    &&  Long.parseLong(txtNumberOfHours.getText()) == employeeANDDepartmentDTO.getNumberOfHours()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("حفظ تعديل البيانات");
                alert.setContentText("لم يتم اجراء اي تعديل");
                alert.showAndWait();
            }
            else {
                flag = true;
                employeeDTO.setBasicSalary(Double.parseDouble(txtSalary.getText()));
                employeeDTO.setNumberOfHours(Long.parseLong(txtNumberOfHours.getText()));
                employeeDTO.setCodeID(employeeANDDepartmentDTO.getCodeID());
                for (DepartmentDTO item : departmentObservableList) {
                    if (item.getDepartmentName().equals(String.valueOf(cmbDepartment.getValue())))
                        employeeDTO.setDepartmentID(item.getDepartmentID());
                }
                result = employeeBAO.save(employeeDTO);
            }

        }

        if (result == 1 && flag){
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("حفظ البيانات");
            alert.setContentText("تم حفظ البيانات");
            alert.showAndWait();
            clear();
        }
        else if (result == -1 && flag){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("حفظ البيانات");
            alert.setContentText("حدث خطأ ما الرجاء مراجعه المدخلات وعدم تكرار الاسم او الكود او رقم الجوال المدخل");
            alert.showAndWait();
        }


    }

    public void cancel(ActionEvent actionEvent) {
        clear();
    }

    private void clear(){
        txtCode.clear();
        txtName.clear();
        txtPhone.clear();
        txtSalary.clear();
        txtNumberOfHours.clear();
        cmbDepartment.setValue("");
        isDateSelected = false;
        isDepartmentSelected = false;
    }
}
