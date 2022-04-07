package sample.dao.employee;


import javafx.collections.ObservableList;
import sample.common.database.AccountingQueries;
import sample.common.database.ConnectionFactory;
import sample.dto.EmployeeDTO;

import java.sql.*;

public class EmployeeDAOImpl implements EmployeeDAO{
    @Override
    public Integer save(EmployeeDTO employeeDTO) {
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(AccountingQueries.INSERT_EMPLOYEE)
        )
        {
            preparedStatement.setLong(1,employeeDTO.getCodeID());
            preparedStatement.setString(2,employeeDTO.getName());
            preparedStatement.setString(3,employeeDTO.getPhone());
            preparedStatement.setDouble(4,employeeDTO.getBasicSalary());
            preparedStatement.setLong(5,employeeDTO.getNumberOfHours());
            preparedStatement.setLong(6,employeeDTO.getDepartmentID());
            preparedStatement.setString(7, employeeDTO.getDateOfEmployment());
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
    public Boolean update(EmployeeDTO employeeDTO) {
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(AccountingQueries.UPDATE_EMPLOYEE)
        )
        {
            preparedStatement.setString(1,employeeDTO.getName());
            preparedStatement.setString(2,employeeDTO.getPhone());
            preparedStatement.setDouble(3,employeeDTO.getBasicSalary());
            preparedStatement.setLong(4,employeeDTO.getNumberOfHours());
            preparedStatement.setLong(5,employeeDTO.getDepartmentID());
            preparedStatement.setLong(6,employeeDTO.getCodeID());
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
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(AccountingQueries.DELETE_EMPLOYEE)
        )
        {
            preparedStatement.setString(1,id);
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
    public EmployeeDTO search(String id) {
        EmployeeDTO employeeDTO = null;
        try (Connection conn = ConnectionFactory.createConnection();
             CallableStatement callableStatement = conn.prepareCall(AccountingQueries.GET_EMPLOYEE_CODE_ID)
        )
        {
            callableStatement.setInt(1,Integer.parseInt(id));
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next())
            {
                employeeDTO =new EmployeeDTO(
                        resultSet.getInt("code"),
                        resultSet.getString("name")
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
        return employeeDTO;
    }

    @Override
    public ObservableList<EmployeeDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<EmployeeDTO> listAll() {
        return null;
    }
}
