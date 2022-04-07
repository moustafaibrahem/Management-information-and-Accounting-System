package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import sample.bao.department.DepartmentBAO;
import sample.common.bao.AccountingBAOFactory;
import sample.dto.DepartmentAndEmployeeCountDTO;
import sample.dto.DepartmentDTO;


public class AddAndEditDepartmentController {
    public TextField txtDepartment;

    DepartmentAndEmployeeCountDTO departmentAndEmployeeCountDTO;
    DepartmentDTO departmentDTO;
    private boolean isAddDepartment;
    private Alert alert;

    DepartmentBAO departmentBAO = AccountingBAOFactory.createDepartmentBAOImpl();

    public void initValue(DepartmentAndEmployeeCountDTO departmentAndEmployeeCountDTO, boolean isAdd) {
        this.departmentAndEmployeeCountDTO = departmentAndEmployeeCountDTO;
        isAddDepartment = isAdd;
        if (!isAddDepartment) {
            txtDepartment.setText(departmentAndEmployeeCountDTO.getDepartmentName());
        }
    }
    public void save(ActionEvent actionEvent) {
        departmentDTO = new DepartmentDTO();
        int result = 0;
        boolean flag = false;
        if (isAddDepartment){
            departmentDTO.setDepartmentName(txtDepartment.getText());
            if (departmentDTO.getDepartmentName().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("حفظ البيانات");
                alert.setContentText("الرجاء ملء جميع البيانات");
                alert.showAndWait();
            }
            else {
                flag = true;
                result = departmentBAO.save(departmentDTO);
            }

        }
        else if (!isAddDepartment){
            //edit
            departmentDTO.setDepartmentID(departmentAndEmployeeCountDTO.getDepartmentID());
            departmentDTO.setDepartmentName(txtDepartment.getText());
            if (departmentDTO.getDepartmentName().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("حفظ تعديل البيانات");
                alert.setContentText("الرجاء ملء جميع البيانات");
                alert.showAndWait();
            }
            else if (   departmentDTO.getDepartmentName().equals(departmentAndEmployeeCountDTO.getDepartmentName())){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("حفظ تعديل البيانات");
                alert.setContentText("لم يتم اجراء اي تعديل");
                alert.showAndWait();
            }
            else {
                flag = true;
                result = departmentBAO.save(departmentDTO);
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
            alert.setContentText("حدث خطأ ما الرجاء مراجعه المدخلات وعدم تكرار الاسم");
            alert.showAndWait();
        }
    }

    public void cancel(ActionEvent actionEvent) {
        clear();
    }

    private void clear(){
        txtDepartment.clear();
    }

}
