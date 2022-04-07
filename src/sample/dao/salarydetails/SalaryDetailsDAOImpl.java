package sample.dao.salarydetails;

import javafx.collections.ObservableList;
import sample.common.database.AccountingQueries;
import sample.common.database.ConnectionFactory;
import sample.dto.SalaryDetailsDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalaryDetailsDAOImpl implements SalaryDetailsDAO{
    @Override
    public Integer save(SalaryDetailsDTO salaryDetailsDTO) {
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(AccountingQueries.INSERT_TAKEN_SALARY)
        )
        {
            preparedStatement.setLong(1,salaryDetailsDTO.getSalarysID());
            preparedStatement.setDouble(2,salaryDetailsDTO.getTakenSalary());
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
    public Boolean update(SalaryDetailsDTO salaryDetailsDTO) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public SalaryDetailsDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<SalaryDetailsDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<SalaryDetailsDTO> listAll() {
        return null;
    }
}
