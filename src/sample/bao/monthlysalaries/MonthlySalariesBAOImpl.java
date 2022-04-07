package sample.bao.monthlysalaries;

import javafx.collections.ObservableList;
import sample.common.dao.AccountingDAOFactory;
import sample.dao.monthlysalaries.MonthlySalariesDAO;
import sample.dto.MonthlySalariesDTO;

public class MonthlySalariesBAOImpl implements MonthlySalariesBAO{

    MonthlySalariesDAO monthlySalariesDAO = AccountingDAOFactory.createMonthlySalariesImpl();

    @Override
    public Integer save(MonthlySalariesDTO monthlySalariesDTO) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public MonthlySalariesDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<MonthlySalariesDTO> search(int id) {
        ObservableList<MonthlySalariesDTO> monthlySalariesObservableList = monthlySalariesDAO.search(id);
        return monthlySalariesObservableList;
    }

    @Override
    public ObservableList<MonthlySalariesDTO> listAll() {
        return null;
    }
}
