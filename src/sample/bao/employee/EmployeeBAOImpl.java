package sample.bao.employee;


import javafx.collections.ObservableList;
import sample.common.dao.AccountingDAOFactory;
import sample.dao.employee.EmployeeDAO;
import sample.dto.EmployeeDTO;

public class EmployeeBAOImpl implements EmployeeBAO {

    EmployeeDAO employeeDAO = AccountingDAOFactory.createEmployeeDAOImpl();

    @Override
    public Integer save(EmployeeDTO employeeDTO) {
        int result = -1;
        //Insert
        if (employeeDTO.getEmployeeID() == 0) {
            result = employeeDAO.save(employeeDTO);
        }
        //Update
        else {
            boolean flagResult = employeeDAO.update(employeeDTO);
            result = flagResult ? 1 : -1;
        }
        return result;
    }

    @Override
    public Boolean delete(String id) {
        boolean result = false;
        result = employeeDAO.delete(id);
        return result;
    }

    @Override
    public EmployeeDTO search(String id) {
        EmployeeDTO employeeDTO = employeeDAO.search(id);
        return employeeDTO;
    }

    @Override
    public ObservableList<EmployeeDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<EmployeeDTO> listAll() {
        return null;
    }
}
