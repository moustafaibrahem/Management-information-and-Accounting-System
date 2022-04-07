package sample.dao.admin;


import sample.common.dao.AccountingDAOIf;
import sample.dto.AdminDTO;

public interface AdminDAO extends AccountingDAOIf<AdminDTO> {
    public AdminDTO search(String name,String password);
}
