package sample.bao.salarydetails;


import javafx.collections.ObservableList;
import sample.common.dao.AccountingDAOFactory;
import sample.dao.salarydetails.SalaryDetailsDAO;
import sample.dto.SalaryDetailsDTO;

public class SalaryDetailsBAOImpl implements SalaryDetailsBAO{

    SalaryDetailsDAO salaryDetailsDAO = AccountingDAOFactory.createSalaryDetailsDAOImpl();

    @Override
    public Integer save(SalaryDetailsDTO salaryDetailsDTO) {
        int result = -1;
        //Insert
        if (salaryDetailsDTO.getSalaryDetailsID() == 0) {
            result = salaryDetailsDAO.save(salaryDetailsDTO);
        }
        //Update
        else {
            boolean flagResult = salaryDetailsDAO.update(salaryDetailsDTO);
            result = flagResult ? 1 : -1;
        }
        return result;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public SalaryDetailsDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<SalaryDetailsDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<SalaryDetailsDTO> listAll() {
        return null;
    }
}
