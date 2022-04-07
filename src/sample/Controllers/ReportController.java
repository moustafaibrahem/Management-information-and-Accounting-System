package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sample.bao.monthlyreport.MonthlyReportBAO;
import sample.common.bao.AccountingBAOFactory;
import sample.dto.MonthlyReportDTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ReportController implements Initializable {

    public DatePicker dpDate;
    public TableView <MonthlyReportDTO>tvMonthlyReport;
    public TableColumn <MonthlyReportDTO, Long> colID;
    public TableColumn <MonthlyReportDTO, String> colName;
    public TableColumn <MonthlyReportDTO, String> colDeptName;
    public TableColumn <MonthlyReportDTO, String> colHiringDate;
    public TableColumn <MonthlyReportDTO, Double> colBasicSalary;
    public TableColumn <MonthlyReportDTO, Double> colMonthlySalary;
    public TableColumn <MonthlyReportDTO, Double> colBonus;
    public TableColumn <MonthlyReportDTO, Double> colDiscount;
    public TableColumn <MonthlyReportDTO, Double> colLoan;
    Stage Stage;

    private boolean isDateSelected;
    MonthlyReportBAO monthlyReportBAO = AccountingBAOFactory.createMonthlyReportBAOImpl();
    ObservableList<MonthlyReportDTO> monthlyReportObservableList = FXCollections.observableArrayList();
    Alert alert;

    public void showMonthlyReport(String date) throws SQLException {
        monthlyReportObservableList = monthlyReportBAO.searchByDate(date);
        colID.setCellValueFactory(new PropertyValueFactory<>("empCode"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDeptName.setCellValueFactory(new PropertyValueFactory<>("depName"));
        colHiringDate.setCellValueFactory(new PropertyValueFactory<>("dateOfEmployment"));
        colBasicSalary.setCellValueFactory(new PropertyValueFactory<>("basicSalary"));
        colMonthlySalary.setCellValueFactory(new PropertyValueFactory<>("monthlySalary"));
        colBonus.setCellValueFactory(new PropertyValueFactory<>("monthlyBonus"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("monthlyDiscount"));
        colLoan.setCellValueFactory(new PropertyValueFactory<>("monthlyBorrowedMoney"));
        tvMonthlyReport.setItems(monthlyReportObservableList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }


    public void getDP(ActionEvent actionEvent) throws SQLException {
        monthlyReportObservableList.clear();
        tvMonthlyReport.getItems().clear();
        isDateSelected = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String selectedDate = dpDate.getValue().format(formatter);
        showMonthlyReport(selectedDate);
        if (!monthlyReportObservableList.isEmpty()){
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ايجاد التقرير الشهري");
            alert.setContentText("تم ايجاد التقرير الشهري بنجاح");
            alert.show();
        }
        else{
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ايجاد التقرير الشهري");
            alert.setContentText("لم يتم ايجاد التقرير الشهري الرجاء اختيار شهر مسبق");
            alert.show();
        }
    }

    public void exportExcel(ActionEvent actionEvent) throws IOException {
       if (isDateSelected && !tvMonthlyReport.getItems().isEmpty()){
           try {
               XSSFWorkbook wb = new XSSFWorkbook();
               XSSFSheet sheet = wb.createSheet("Monthly Report");

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
