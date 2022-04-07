package sample.bao.admin;


import javafx.collections.ObservableList;
import sample.common.dao.AccountingDAOFactory;
import sample.dao.admin.AdminDAO;
import sample.dto.AdminDTO;

public class AdminBAOImpl implements AdminBAO{

    AdminDAO adminDAO = AccountingDAOFactory.createAdminDAOImpl();

    @Override
    public Integer save(AdminDTO adminDTO) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public AdminDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<AdminDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<AdminDTO> listAll() {
        return null;
    }

    @Override
    public AdminDTO search(String name, String password) {
        AdminDTO adminDTO = adminDAO.search(name,password);
        return adminDTO;
    }
}
