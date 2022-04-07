package sample.bao.admin;


import sample.common.bao.AccountingBAOIf;
import sample.dto.AdminDTO;

public interface AdminBAO extends AccountingBAOIf<AdminDTO> {
    public AdminDTO search(String name,String password);
}
