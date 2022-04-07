package sample.dao.loan;

import javafx.collections.ObservableList;
import sample.common.database.AccountingQueries;
import sample.common.database.ConnectionFactory;
import sample.dto.LoanDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoanDAOImpl implements LoanDAO{
    @Override
    public Integer save(LoanDTO loanDTO) {
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(AccountingQueries.INSERT_LOAN)
        )
        {
            preparedStatement.setLong(1,loanDTO.getEmployeeID());
            preparedStatement.setDouble(2,loanDTO.getBorrowedMoney());
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
    public Boolean update(LoanDTO loanDTO) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public LoanDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<LoanDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<LoanDTO> listAll() {
        return null;
    }
}
