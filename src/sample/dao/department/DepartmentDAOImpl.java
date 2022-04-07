package sample.dao.department;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.common.database.AccountingQueries;
import sample.common.database.ConnectionFactory;
import sample.dto.DepartmentDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDAOImpl implements DepartmentDAO{
    @Override
    public Integer save(DepartmentDTO departmentDTO) {
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(AccountingQueries.INSERT_DEPARTMENT)
        )
        {
            preparedStatement.setString(1,departmentDTO.getDepartmentName());
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
    public Boolean update(DepartmentDTO departmentDTO) {
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(AccountingQueries.UPDATE_DEPARTMENT)
        )
        {
            preparedStatement.setString(1,departmentDTO.getDepartmentName());
            preparedStatement.setLong(2,departmentDTO.getDepartmentID());
            preparedStatement.executeUpdate();
            return true;
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
            return false;
        }
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public DepartmentDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<DepartmentDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<DepartmentDTO> listAll() {
        ObservableList<DepartmentDTO> departmentObservableList = FXCollections.observableArrayList();
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(AccountingQueries.SELECT_ALL_DEPARTMENTS)
        )
        {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                departmentObservableList.add(new DepartmentDTO(
                        resultSet.getInt(1),
                        resultSet.getString(2)
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
        return departmentObservableList;
    }
}
