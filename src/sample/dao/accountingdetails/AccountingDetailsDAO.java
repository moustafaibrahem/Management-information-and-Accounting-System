package sample.dao.accountingdetails;

import javafx.collections.ObservableList;
import sample.common.dao.AccountingDAOIf;
import sample.dto.AccountingDetailsDTO;

public interface AccountingDetailsDAO extends AccountingDAOIf<AccountingDetailsDTO> {
    public ObservableList<AccountingDetailsDTO> search(int empCode, String date);
}
