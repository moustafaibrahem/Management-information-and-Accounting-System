package sample.dao.accountingdetails;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.common.database.AccountingQueries;
import sample.common.database.ConnectionFactory;
import sample.dto.AccountingDetailsDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountingDetailsDAOImpl implements AccountingDetailsDAO{
    @Override
    public Integer save(AccountingDetailsDTO accountingDetailsDTO) {
        return null;
    }

    @Override
    public Boolean update(AccountingDetailsDTO accountingDetailsDTO) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public AccountingDetailsDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<AccountingDetailsDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<AccountingDetailsDTO> listAll() {
        return null;
    }

    @Override
    public ObservableList<AccountingDetailsDTO> search(int empCode, String date) {
        ObservableList<AccountingDetailsDTO> accountingDetailsObservableList = FXCollections.observableArrayList();
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(AccountingQueries.SELECT_ACCOUNTING_DETAILS)
        )
        {
            preparedStatement.setInt(1,empCode);
            preparedStatement.setString(2,date);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                accountingDetailsObservableList.add(new AccountingDetailsDTO(
                        resultSet.getString("الشهر"),
                        resultSet.getInt("عدد الساعات"),
                        resultSet.getString("الحاله"),
                        resultSet.getString("التاريخ")
                ));
            }
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
        }
        return accountingDetailsObservableList;
    }
}
