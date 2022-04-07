package sample.bao.department;


import javafx.collections.ObservableList;
import sample.common.dao.AccountingDAOFactory;
import sample.dao.department.DepartmentDAO;
import sample.dto.DepartmentDTO;

public class DepartmentBAOImpl implements DepartmentBAO{

    DepartmentDAO departmentDAO = AccountingDAOFactory.createDepartmentDAOImpl();

    @Override
    public Integer save(DepartmentDTO departmentDTO) {
        int result = -1;
        //Insert
        if (departmentDTO.getDepartmentID() == 0) {
            result = departmentDAO.save(departmentDTO);
        }
        //Update
        else {
            boolean flagResult = departmentDAO.update(departmentDTO);
            result = flagResult ? 1 : -1;
        }
        return result;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public DepartmentDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<DepartmentDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<DepartmentDTO> listAll() {
        ObservableList<DepartmentDTO> departmentObservableList = departmentDAO.listAll();
        return departmentObservableList;
    }
}
