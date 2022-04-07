package sample.dao.hourprice;


import javafx.collections.ObservableList;
import sample.common.database.AccountingQueries;
import sample.common.database.ConnectionFactory;
import sample.dto.HourPriceDTO;

import java.sql.*;

public class HourPriceDAOImpl implements HourPriceDAO{
    @Override
    public Integer save(HourPriceDTO hourPriceDTO) {
        try (Connection conn = ConnectionFactory.createConnection();
             CallableStatement callableStatement = conn.prepareCall(AccountingQueries.INSERT_HOUR_PRICE)
        )
        {
            callableStatement.setDouble(1,hourPriceDTO.getPrice());
            callableStatement.executeQuery();
            return 1;
        } catch (SQLException ex) {

            while (ex != null) {
                System.out.println("SQLState:  " + ex.getSQLState());
                System.out.println("Error Code:" + ex.getErrorCode());
                System.out.println("Message:   " + ex.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause:" + t);
                    t = t.getCause();
                }
                ex = ex.getNextException();
            }
            return -1;
        }
    }

    @Override
    public Boolean update(HourPriceDTO hourPriceDTO) {
        return null;
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
