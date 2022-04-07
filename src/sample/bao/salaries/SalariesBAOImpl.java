package sample.bao.salaries;


import javafx.collections.ObservableList;
import sample.common.dao.AccountingDAOFactory;
import sample.dao.salaries.SalariesDAO;
import sample.dto.SalariesDTO;

public class SalariesBAOImpl implements SalariesBAO {

    SalariesDAO salariesDAO = AccountingDAOFactory.createSalarysDAOImpl();

    @Override
    public Integer save(SalariesDTO salariesDTO) {
        int result = -1;
        //Insert
        if (salariesDTO.getSalaryID() == 0) {
            result = salariesDAO.save(salariesDTO);
        }
        //Update
        else {
            boolean flagResult = salariesDAO.update(salariesDTO);
            result = flagResult ? 1 : -1;
        }
        return result;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public SalariesDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<SalariesDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<SalariesDTO> listAll() {
        return null;
    }
}
