package sample.bao.monthlyreport;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.common.dao.AccountingDAOFactory;
import sample.dao.monthlyreport.MonthlyReportDAO;
import sample.dto.MonthlyReportDTO;

public class MonthlyReportBAOImpl implements MonthlyReportBAO{

    MonthlyReportDAO monthlyReportDAO = AccountingDAOFactory.createMonthlyReportDAOImpl();

    @Override
    public Integer save(MonthlyReportDTO monthlyReportDTO) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public MonthlyReportDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<MonthlyReportDTO> search(int id) {
        ObservableList<MonthlyReportDTO> monthlyReportObservableList = monthlyReportDAO.search(id);
        return monthlyReportObservableList;
    }

    @Override
    public ObservableList<MonthlyReportDTO> listAll() {
       return null;
    }

    @Override
    public ObservableList<MonthlyReportDTO> searchByDate(String date) {
        ObservableList<MonthlyReportDTO> monthlyReportObservableList = monthlyReportDAO.searchByDate(date);
        return monthlyReportObservableList;
    }

    @Override
    public MonthlyReportDTO search(int empCode, String date) {
        MonthlyReportDTO monthlyReportDTO = monthlyReportDAO.search(empCode,date);
        return monthlyReportDTO;
    }
}
