package sample.bao.hourprice;


import javafx.collections.ObservableList;
import sample.common.dao.AccountingDAOFactory;
import sample.dao.hourprice.HourPriceDAO;
import sample.dto.HourPriceDTO;

public class HourPriceBAOImpl implements HourPriceBAO{

    HourPriceDAO hourPriceDAO = AccountingDAOFactory.createHourPriceDAOImpl();

    @Override
    public Integer save(HourPriceDTO hourPriceDTO) {

        int result = -1;
        if (hourPriceDTO.getPrice()>0)
            result = hourPriceDAO.save(hourPriceDTO);

        return result;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public HourPriceDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<HourPriceDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<HourPriceDTO> listAll() {
        return null;
    }
}
