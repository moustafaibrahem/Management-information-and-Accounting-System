package sample.Controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.bao.admin.AdminBAO;
import sample.common.bao.AccountingBAOFactory;
import sample.common.database.ConnectionFactory;
import sample.dto.AdminDTO;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public TextField txtUsername;
    public PasswordField txtPassword;
    public Button btnCheckDataBase;
    public Button btnLogin;
    public boolean flag;

    AdminBAO adminBAO = AccountingBAOFactory.createAdminBAOImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        flag = false;
    }

    public void btnCheckDataBase(ActionEvent actionEvent) {
        try {
            Connection connection = ConnectionFactory.createConnection();
            if (connection != null) {
                flag = true;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("تحقق من قاعدة البيانات");
                alert.setContentText("قاعدة البيانات متصلة!");
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("تحقق من قاعدة البيانات");
                alert.setContentText("قاعدة البيانات غير متصلة");
                alert.show();
            }
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void btnLogin(ActionEvent actionEvent) throws IOException {
        if (flag){

            AdminDTO adminDTO = adminBAO.search(txtUsername.getText(),txtPassword.getText());
            if (adminDTO.getPassword()== null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("خطأ");
                alert.setContentText("اسم المستخدم او كلمة السر غير صحيحه");
                alert.show();
            }
            else {
                ((Node) actionEvent.getSource()).getScene().getWindow().hide();
                Stage primaryStage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Object root = loader.load(getClass().getResource("/sample/Views/MainHome.fxml").openStream());
                Image image = new Image("sample/common/icons/icons8-accounting-64.png");
                primaryStage.getIcons().add(image);
                primaryStage.setTitle("الرئيسية");
                primaryStage.setScene(new Scene((Parent) root,986,635));
                MainHomeController Controller = loader.getController();
                Controller.initValue(adminDTO);
                primaryStage.show();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("تحقق من قاعدة البيانات");
            alert.setContentText("يجب التحقق من اتصال قاعدة البيانات اولا‘");
            alert.show();
        }
    }

}
