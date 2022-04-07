package sample.bao.accounting;

import javafx.collections.ObservableList;
import sample.common.dao.AccountingDAOFactory;
import sample.dao.accounting.AccountingDAO;
import sample.dto.AccountingDTO;

public class AccountingBAOImpl implements AccountingBAO{

    AccountingDAO accountingDAO = AccountingDAOFactory.createAccountingDAOImpl();

    @Override
    public Integer save(AccountingDTO accountingDto) {
        int result = -1;
        //Insert
        if (accountingDto.getAccountingID() == 0) {
            result = accountingDAO.save(accountingDto);
        }
        //Update
        else {
            boolean flagResult = accountingDAO.update(accountingDto);
            result = flagResult ? 1 : -1;
        }
        return result;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public AccountingDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<AccountingDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<AccountingDTO> listAll() {
        return null;
    }
}
