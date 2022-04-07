package sample.dao.loandetails;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.common.database.AccountingQueries;
import sample.common.database.ConnectionFactory;
import sample.dto.LoanDetailsDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanDetailsDAOImpl implements LoanDetailsDAO{
    @Override
    public Integer save(LoanDetailsDTO loanDetailsDTO) {
        return null;
    }

    @Override
    public Boolean update(LoanDetailsDTO loanDetailsDTO) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public LoanDetailsDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<LoanDetailsDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<LoanDetailsDTO> listAll() {
        return null;
    }

    @Override
    public ObservableList<LoanDetailsDTO> search(int empCode, String date) {
        ObservableList<LoanDetailsDTO> loanDetailsObservableList = FXCollections.observableArrayList();
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(AccountingQueries.SELECT_LOAN_DETAILS)
        )
        {
            preparedStatement.setInt(1,empCode);
            preparedStatement.setString(2,date);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                loanDetailsObservableList.add(new LoanDetailsDTO(
                        resultSet.getString("الشهر"),
                        resultSet.getDouble("السلفه"),
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
        return loanDetailsObservableList;
    }
}
