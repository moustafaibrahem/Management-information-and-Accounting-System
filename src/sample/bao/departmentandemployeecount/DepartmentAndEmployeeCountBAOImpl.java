package sample.bao.departmentandemployeecount;

import javafx.collections.ObservableList;
import sample.common.dao.AccountingDAOFactory;
import sample.dao.departmentandemployeecount.DepartmentAndEmployeeCountDAO;
import sample.dto.DepartmentAndEmployeeCountDTO;

public class DepartmentAndEmployeeCountBAOImpl implements DepartmentAndEmployeeCountBAO{

    DepartmentAndEmployeeCountDAO departmentAndEmployeeCountDAO = AccountingDAOFactory.createDepartmentAndEmployeeCountDAOImpl();

    @Override
    public Integer save(DepartmentAndEmployeeCountDTO departmentAndEmployeeCountDTO) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public DepartmentAndEmployeeCountDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<DepartmentAndEmployeeCountDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<DepartmentAndEmployeeCountDTO> listAll() {
        ObservableList<DepartmentAndEmployeeCountDTO> departmentAndEmployeeCountObservableList = departmentAndEmployeeCountDAO.listAll();
        return departmentAndEmployeeCountObservableList;
    }
}
