package sample.dao.departmentandemployeecount;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.common.database.AccountingQueries;
import sample.common.database.ConnectionFactory;
import sample.dto.DepartmentAndEmployeeCountDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentAndEmployeeCountDAOImpl implements DepartmentAndEmployeeCountDAO{
    @Override
    public Integer save(DepartmentAndEmployeeCountDTO departmentAndEmployeeCountDTO) {
        return null;
    }

    @Override
    public Boolean update(DepartmentAndEmployeeCountDTO departmentAndEmployeeCountDTO) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public DepartmentAndEmployeeCountDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<DepartmentAndEmployeeCountDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<DepartmentAndEmployeeCountDTO> listAll() {
        ObservableList<DepartmentAndEmployeeCountDTO> departmentAndEmployeeCountObservableList = FXCollections.observableArrayList();
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(AccountingQueries.SELECT_ALL_DEPARTMENTS_AND_COUNT_OF_EMPLOYEES)
        )
        {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                departmentAndEmployeeCountObservableList.add(new DepartmentAndEmployeeCountDTO(
                        resultSet.getInt("ID"),
                        resultSet.getString("القسم"),
                        resultSet.getInt("عدد الموظفين")
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
        return departmentAndEmployeeCountObservableList;
    }
}
