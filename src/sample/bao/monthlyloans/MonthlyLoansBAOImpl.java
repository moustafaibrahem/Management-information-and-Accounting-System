package sample.bao.monthlyloans;

import javafx.collections.ObservableList;
import sample.common.dao.AccountingDAOFactory;
import sample.dao.monthlyloans.MonthlyLoansDAO;
import sample.dto.MonthlyLoansDTO;

public class MonthlyLoansBAOImpl implements MonthlyLoansBAO{

    MonthlyLoansDAO monthlyLoansDAO = AccountingDAOFactory.createMonthlyLoansDAOImpl();

    @Override
    public Integer save(MonthlyLoansDTO monthlyLoansDTO) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public MonthlyLoansDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<MonthlyLoansDTO> search(int id) {
        ObservableList<MonthlyLoansDTO> monthlyLoansObservableList = monthlyLoansDAO.search(id);
        return monthlyLoansObservableList;
    }

    @Override
    public ObservableList<MonthlyLoansDTO> listAll() {
        return null;
    }
}
