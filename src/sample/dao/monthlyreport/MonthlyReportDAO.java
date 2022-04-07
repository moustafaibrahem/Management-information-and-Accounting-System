package sample.dao.monthlyreport;

import javafx.collections.ObservableList;
import sample.common.dao.AccountingDAOIf;
import sample.dto.MonthlyReportDTO;

public interface MonthlyReportDAO extends AccountingDAOIf<MonthlyReportDTO> {
    public ObservableList<MonthlyReportDTO> searchByDate(String date);
    public MonthlyReportDTO search(int empCode, String date);
}
