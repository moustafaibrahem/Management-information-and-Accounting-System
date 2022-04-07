package sample.bao.loansrepaymentdetails;

import javafx.collections.ObservableList;
import sample.common.bao.AccountingBAOIf;
import sample.dto.LoansRepaymentDetailsDTO;

public interface LoansRepaymentDetailsBAO extends AccountingBAOIf<LoansRepaymentDetailsDTO> {
    public ObservableList<LoansRepaymentDetailsDTO> search(int empCode, String date);
}
