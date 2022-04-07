package sample.dao.salaries;


import javafx.collections.ObservableList;
import sample.common.database.AccountingQueries;
import sample.common.database.ConnectionFactory;
import sample.dto.SalariesDTO;

import java.sql.*;

public class SalariesDAOImpl implements SalariesDAO {
    @Override
    public Integer save(SalariesDTO salariesDTO) {
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(AccountingQueries.INSERT_SALARY)
        )
        {
            preparedStatement.setLong(1,salariesDTO.getEmployeeID());
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
    public Boolean update(SalariesDTO salariesDTO) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public SalariesDTO search(String id) {
        SalariesDTO salariesDTO = null;
        try (Connection conn = ConnectionFactory.createConnection();
             CallableStatement callableStatement = conn.prepareCall(AccountingQueries.SELECT_SALARY_ID_FOR_CURRENT_MONTH)
        )
        {
            callableStatement.setInt(1,Integer.parseInt(id));
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next())
            {
                salariesDTO =new SalariesDTO(
                        resultSet.getInt(1)
                );
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
        return salariesDTO;
    }

    @Override
    public ObservableList<SalariesDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<SalariesDTO> listAll() {
        return null;
    }
}
