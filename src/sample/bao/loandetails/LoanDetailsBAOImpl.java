package sample.bao.loandetails;

import javafx.collections.ObservableList;
import sample.common.dao.AccountingDAOFactory;
import sample.dao.loandetails.LoanDetailsDAO;
import sample.dto.LoanDetailsDTO;

public class LoanDetailsBAOImpl implements LoanDetailsBAO{

    LoanDetailsDAO loanDetailsDAO = AccountingDAOFactory.createLoanDetailsDAOImpl();

    @Override
    public Integer save(LoanDetailsDTO loanDetailsDTO) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public LoanDetailsDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<LoanDetailsDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<LoanDetailsDTO> listAll() {
        return null;
    }

    @Override
    public ObservableList<LoanDetailsDTO> search(int empCode, String date) {
        ObservableList<LoanDetailsDTO> loanDetailsObservableList = loanDetailsDAO.search(empCode,date);
        return loanDetailsObservableList;
    }
}
