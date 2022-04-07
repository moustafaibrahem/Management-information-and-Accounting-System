package sample.dao.accounting;


import javafx.collections.ObservableList;
import sample.common.database.AccountingQueries;
import sample.common.database.ConnectionFactory;
import sample.dto.AccountingDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountingDAOImpl implements AccountingDAO{

    @Override
    public Integer save(AccountingDTO accountingDto){
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(AccountingQueries.INSERT_ACCOUNTING)
        )
        {
            preparedStatement.setLong(1,accountingDto.getEmployeeID());
            preparedStatement.setLong(2,accountingDto.getStatus());
            preparedStatement.setInt(3,accountingDto.getHours());
            preparedStatement.executeUpdate();
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
    public Boolean update(AccountingDTO accountingDto) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public AccountingDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<AccountingDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<AccountingDTO> listAll() {
        return null;
    }
}
