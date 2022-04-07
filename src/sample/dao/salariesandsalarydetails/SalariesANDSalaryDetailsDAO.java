package sample.dao.salariesandsalarydetails;


import javafx.collections.ObservableList;
import sample.common.dao.AccountingDAOIf;
import sample.dto.SalariesANDSalaryDetailsDTO;

public interface SalariesANDSalaryDetailsDAO extends AccountingDAOIf<SalariesANDSalaryDetailsDTO> {
    public ObservableList<SalariesANDSalaryDetailsDTO> search(int empCode, String date);
}
