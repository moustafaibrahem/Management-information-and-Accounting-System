package sample.dao.loandetails;

import javafx.collections.ObservableList;
import sample.common.dao.AccountingDAOIf;
import sample.dto.LoanDetailsDTO;

public interface LoanDetailsDAO extends AccountingDAOIf<LoanDetailsDTO> {
    public ObservableList<LoanDetailsDTO> search(int empCode, String date);
}
