package sample.dao.loansrepaymentdetails;

import javafx.collections.ObservableList;
import sample.common.dao.AccountingDAOIf;
import sample.dto.LoansRepaymentDetailsDTO;

public interface LoansRepaymentDetailsDAO extends AccountingDAOIf<LoansRepaymentDetailsDTO> {
    public ObservableList<LoansRepaymentDetailsDTO> search(int empCode, String date);

}
