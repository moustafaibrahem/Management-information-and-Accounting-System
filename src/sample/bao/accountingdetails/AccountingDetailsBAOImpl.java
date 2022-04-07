package sample.bao.accountingdetails;

import javafx.collections.ObservableList;
import sample.common.dao.AccountingDAOFactory;
import sample.dao.accountingdetails.AccountingDetailsDAO;
import sample.dto.AccountingDetailsDTO;

public class AccountingDetailsBAOImpl implements AccountingDetailsBAO{

    AccountingDetailsDAO accountingDetailsDAO = AccountingDAOFactory.createAccountingDetailsDAOImpl();

    @Override
    public Integer save(AccountingDetailsDTO accountingDetailsDTO) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public AccountingDetailsDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<AccountingDetailsDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<AccountingDetailsDTO> listAll() {
        return null;
    }

    @Override
    public ObservableList<AccountingDetailsDTO> search(int empCode, String date) {
        ObservableList<AccountingDetailsDTO> accountingDetailsObservableList = accountingDetailsDAO.search(empCode,date);
        return accountingDetailsObservableList;
    }
}
