package sample.bao.loansrepaymentdetails;

import javafx.collections.ObservableList;
import sample.common.dao.AccountingDAOFactory;
import sample.dao.loansrepaymentdetails.LoansRepaymentDetailsDAO;
import sample.dto.LoansRepaymentDetailsDTO;

public class LoansRepaymentDetailsBAOImpl implements LoansRepaymentDetailsBAO{

    LoansRepaymentDetailsDAO loansRepaymentDetailsDAO = AccountingDAOFactory.createLoansRepaymentDetailsDAOImpl();

    @Override
    public Integer save(LoansRepaymentDetailsDTO loansRepaymentDetailsDTO) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public LoansRepaymentDetailsDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<LoansRepaymentDetailsDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<LoansRepaymentDetailsDTO> listAll() {
        return null;
    }

    @Override
    public ObservableList<LoansRepaymentDetailsDTO> search(int empCode, String date) {
        ObservableList<LoansRepaymentDetailsDTO> loansRepaymentDetailsObservableList = loansRepaymentDetailsDAO.search(empCode,date);
        return loansRepaymentDetailsObservableList;
    }
}
