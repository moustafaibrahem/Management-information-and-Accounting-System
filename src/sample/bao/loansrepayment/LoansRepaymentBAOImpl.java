package sample.bao.loansrepayment;

import javafx.collections.ObservableList;
import sample.common.dao.AccountingDAOFactory;
import sample.dao.loansrepayment.LoansRepaymentDAO;
import sample.dto.LoansRepaymentDTO;

public class LoansRepaymentBAOImpl implements LoansRepaymentBAO{

    LoansRepaymentDAO loansRepaymentDAO = AccountingDAOFactory.createLoansRepaymentDAOImpl();

    @Override
    public Integer save(LoansRepaymentDTO loansRepaymentDTO) {
        int result = -1;
        //Insert
        if (loansRepaymentDTO.getId() == 0) {
            result = loansRepaymentDAO.save(loansRepaymentDTO);
        }
        //Update
        else {
            boolean flagResult = loansRepaymentDAO.update(loansRepaymentDTO);
            result = flagResult ? 1 : -1;
        }
        return result;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public LoansRepaymentDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<LoansRepaymentDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<LoansRepaymentDTO> listAll() {
        return null;
    }
}
