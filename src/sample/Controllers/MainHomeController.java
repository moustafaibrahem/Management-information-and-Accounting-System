package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import sample.dto.AdminDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainHomeController implements Initializable{


    public JFXButton btnHome;
    public JFXButton btnEmployee;
    public JFXButton btnDepartment;
    public JFXButton btnAccounting;
    public JFXButton btnBonus;
    public JFXButton btnBorrow;
    public JFXButton btnReport;
    public BorderPane bp;
    public AnchorPane ap;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadPage("Main");
    }

    public void initValue(AdminDTO adminDTO) {

    }


    public void showMainView(ActionEvent actionEvent) {
        loadPage("Main");
    }


    public void showEmployeeView(ActionEvent actionEvent) {
        loadPage("Employee");
    }

    public void showDepartmentView(ActionEvent actionEvent) {
        loadPage("Department");
    }

    public void showAccountingView(ActionEvent actionEvent) {
        loadPage("Accounting");
    }

    public void showBonusAndDiscountView(ActionEvent actionEvent) {
        loadPage("BonusAndDiscount");
    }

    public void showLoanView(ActionEvent actionEvent) {
        loadPage("Borrow");
    }

    public void showReports(ActionEvent actionEvent) {
        loadPage("Report");
    }

    private void loadPage(String page){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/sample/Views/"+page+".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        bp.setCenter(root);
    }

}
