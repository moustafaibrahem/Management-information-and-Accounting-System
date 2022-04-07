package sample.bao.employeeanddepartment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.common.dao.AccountingDAOFactory;
import sample.dao.employeeanddepartment.EmployeeANDDepartmentDAO;
import sample.dto.EmployeeANDDepartmentDTO;

public class EmployeeANDDepartmentBAOImpl implements EmployeeANDDepartmentBAO{

    EmployeeANDDepartmentDAO employeeANDDepartmentDAO = AccountingDAOFactory.createEmployeeANDDepartmentDAOImpl();

    @Override
    public Integer save(EmployeeANDDepartmentDTO employeeANDDepartmentDTO) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public EmployeeANDDepartmentDTO search(String id) {
        EmployeeANDDepartmentDTO employeeANDDepartmentDTO = employeeANDDepartmentDAO.search(id);
        return employeeANDDepartmentDTO;
    }

    @Override
    public ObservableList<EmployeeANDDepartmentDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<EmployeeANDDepartmentDTO> listAll() {
        ObservableList<EmployeeANDDepartmentDTO> employeeANDDepartmentObservableList = employeeANDDepartmentDAO.listAll();
        return employeeANDDepartmentObservableList;
    }
}
