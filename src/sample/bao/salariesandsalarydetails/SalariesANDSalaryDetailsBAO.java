package sample.bao.salariesandsalarydetails;


import javafx.collections.ObservableList;
import sample.common.bao.AccountingBAOIf;
import sample.dto.SalariesANDSalaryDetailsDTO;

public interface SalariesANDSalaryDetailsBAO extends AccountingBAOIf<SalariesANDSalaryDetailsDTO> {
    public ObservableList<SalariesANDSalaryDetailsDTO> search(int empCode, String date);
}
