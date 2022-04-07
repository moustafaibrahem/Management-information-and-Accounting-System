package sample.bao.loandetails;

import javafx.collections.ObservableList;
import sample.common.bao.AccountingBAOIf;
import sample.dto.LoanDetailsDTO;

public interface LoanDetailsBAO extends AccountingBAOIf<LoanDetailsDTO> {
    public ObservableList<LoanDetailsDTO> search(int empCode, String date);
}
