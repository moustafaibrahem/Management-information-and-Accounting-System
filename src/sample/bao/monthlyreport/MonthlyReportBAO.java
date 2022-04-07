package sample.bao.monthlyreport;


import javafx.collections.ObservableList;
import sample.common.bao.AccountingBAOIf;
import sample.dto.MonthlyReportDTO;

public interface MonthlyReportBAO extends AccountingBAOIf<MonthlyReportDTO> {
    public ObservableList<MonthlyReportDTO> searchByDate(String date);
    public MonthlyReportDTO search(int empCode, String date);
}
