package sample.bao.loan;


import javafx.collections.ObservableList;
import sample.common.dao.AccountingDAOFactory;
import sample.dao.loan.LoanDAO;
import sample.dto.LoanDTO;

public class LoanBAOImpl implements LoanBAO{

    LoanDAO loanDAO = AccountingDAOFactory.createLoanDAOImpl();

    @Override
    public Integer save(LoanDTO loanDTO) {
        int result = -1;
        //Insert
        if (loanDTO.getLoanID() == 0) {
            result = loanDAO.save(loanDTO);
        }
        //Update
        else {
            boolean flagResult = loanDAO.update(loanDTO);
            result = flagResult ? 1 : -1;
        }
        return result;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public LoanDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<LoanDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<LoanDTO> listAll() {
        return null;
    }
}
