package sample.bao.accountingdetails;

import javafx.collections.ObservableList;
import sample.common.bao.AccountingBAOIf;
import sample.dto.AccountingDetailsDTO;

public interface AccountingDetailsBAO extends AccountingBAOIf<AccountingDetailsDTO> {
    public ObservableList<AccountingDetailsDTO> search(int empCode, String date);
}
