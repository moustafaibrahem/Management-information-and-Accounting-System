package sample.dao.loansrepayment;

import javafx.collections.ObservableList;
import sample.common.database.AccountingQueries;
import sample.common.database.ConnectionFactory;
import sample.dto.LoansRepaymentDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoansRepaymentDAOImpl implements LoansRepaymentDAO{
    @Override
    public Integer save(LoansRepaymentDTO loansRepaymentDTO) {
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(AccountingQueries.INSERT_LOAN_REPAYMENT)
        )
        {
            preparedStatement.setLong(1,loansRepaymentDTO.getLoanID());
            preparedStatement.setDouble(2,loansRepaymentDTO.getRepaidMoney());
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
    public Boolean update(LoansRepaymentDTO loansRepaymentDTO) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public LoansRepaymentDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<LoansRepaymentDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<LoansRepaymentDTO> listAll() {
        return null;
    }
}
