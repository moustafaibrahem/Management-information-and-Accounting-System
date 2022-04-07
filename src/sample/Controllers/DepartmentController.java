package sample.Controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.bao.departmentandemployeecount.DepartmentAndEmployeeCountBAO;
import sample.common.bao.AccountingBAOFactory;
import sample.common.util.Constants;
import sample.dto.DepartmentAndEmployeeCountDTO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DepartmentController implements Initializable {
    public TableView<DepartmentAndEmployeeCountDTO> tvDepartment;
    public TableColumn<DepartmentAndEmployeeCountDTO,Integer> colCountEmployee;
    public TableColumn<DepartmentAndEmployeeCountDTO,String> colName;

    private boolean isRowSelected;
    FXMLLoader loader;
    Alert alert;
    Constants constants = new Constants();

    DepartmentAndEmployeeCountDTO departmentAndEmployeeCountDTO;
    ObservableList<DepartmentAndEmployeeCountDTO> departmentAndEmployeeCountObservableList;
    DepartmentAndEmployeeCountBAO departmentAndEmployeeCountBAO = AccountingBAOFactory.createDepartmentAndEmployeeCountBAOImpl();


    public void showEmployeeList() throws SQLException {
        departmentAndEmployeeCountObservableList = departmentAndEmployeeCountBAO.listAll();
        colName.setCellValueFactory(new PropertyValueFactory<>("departmentName"));
        colCountEmployee.setCellValueFactory(new PropertyValueFactory<>("countEmployee"));
        tvDepartment.setItems(departmentAndEmployeeCountObservableList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            showEmployeeList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getSelectedRow() {
        isRowSelected = true;
        departmentAndEmployeeCountDTO = tvDepartment.getSelectionModel().getSelectedItem();
    }

    public void addDepartment(ActionEvent actionEvent) throws IOException {
        loader = constants.loadPage("AddAndEditDepartment","اضافة قسم");
        AddAndEditDepartmentController addAndEditDepartmentController=loader.getController();
        addAndEditDepartmentController.initValue(departmentAndEmployeeCountDTO,true);
    }

    public void editDepartment(ActionEvent actionEvent) throws IOException {
        if (isRowSelected) {
            loader = constants.loadPage("AddAndEditDepartment","تعديل قسم");
            AddAndEditDepartmentController addAndEditDepartmentController=loader.getController();
            addAndEditDepartmentController.initValue(departmentAndEmployeeCountDTO,false);
        }
        else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("تعديل قسم");
            alert.setContentText("يجب تحديد القسم اولا من الجدول");
            alert.show();
        }
    }
}
