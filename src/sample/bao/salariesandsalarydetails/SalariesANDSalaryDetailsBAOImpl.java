package sample.bao.salariesandsalarydetails;


import javafx.collections.ObservableList;
import sample.common.dao.AccountingDAOFactory;
import sample.dao.salariesandsalarydetails.SalariesANDSalaryDetailsDAO;
import sample.dto.SalariesANDSalaryDetailsDTO;

public class SalariesANDSalaryDetailsBAOImpl implements SalariesANDSalaryDetailsBAO {

    SalariesANDSalaryDetailsDAO salariesANDSalaryDetailsDAO = AccountingDAOFactory.createSalarysDtoSalaryDetailsDAOImpl();

    @Override
    public Integer save(SalariesANDSalaryDetailsDTO salariesANDSalaryDetailsDTO) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public SalariesANDSalaryDetailsDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<SalariesANDSalaryDetailsDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<SalariesANDSalaryDetailsDTO> listAll() {
        return null;
    }

    @Override
    public ObservableList<SalariesANDSalaryDetailsDTO> search(int empCode, String date) {
        ObservableList<SalariesANDSalaryDetailsDTO> salarysANDSalaryDetailsObservableList = salariesANDSalaryDetailsDAO.search(empCode,date);
        return salarysANDSalaryDetailsObservableList;
    }
}
