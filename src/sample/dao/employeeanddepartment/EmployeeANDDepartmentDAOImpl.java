package sample.dao.employeeanddepartment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.common.database.AccountingQueries;
import sample.common.database.ConnectionFactory;
import sample.dto.EmployeeANDDepartmentDTO;

import java.sql.*;

public class EmployeeANDDepartmentDAOImpl implements EmployeeANDDepartmentDAO{
    @Override
    public Integer save(EmployeeANDDepartmentDTO employeeANDDepartmentDTO) {
        return null;
    }

    @Override
    public Boolean update(EmployeeANDDepartmentDTO employeeANDDepartmentDTO) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public EmployeeANDDepartmentDTO search(String id) {
        EmployeeANDDepartmentDTO employeeANDDepartmentDTO = null;
        try (Connection conn = ConnectionFactory.createConnection();
             CallableStatement callableStatement = conn.prepareCall(AccountingQueries.GET_EMPLOYEE_AND_DEPT_BY_CODE_ID)
        )
        {
            callableStatement.setInt(1,Integer.parseInt(id));
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next())
            {
                employeeANDDepartmentDTO =new EmployeeANDDepartmentDTO(
                        resultSet.getInt("code"),
                        resultSet.getString("name"),
                        resultSet.getString("phone"),
                        resultSet.getDouble("basic salary"),
                        resultSet.getLong("hours"),
                        resultSet.getString("department"),
                        resultSet.getString("Date of hiring")
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
        return employeeANDDepartmentDTO;
    }

    @Override
    public ObservableList<EmployeeANDDepartmentDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<EmployeeANDDepartmentDTO> listAll() {
        ObservableList<EmployeeANDDepartmentDTO> employeeANDDepartmentObservableList = FXCollections.observableArrayList();
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(AccountingQueries.SELECT_ALL_EMPLOYEES)
        )
        {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                employeeANDDepartmentObservableList.add(new EmployeeANDDepartmentDTO(
                        resultSet.getInt("code"),
                        resultSet.getString("name"),
                        resultSet.getString("phone"),
                        resultSet.getDouble("basic salary"),
                        resultSet.getLong("hours"),
                        resultSet.getString("department"),
                        resultSet.getString("Date of hiring")
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
        return employeeANDDepartmentObservableList;
    }
}
