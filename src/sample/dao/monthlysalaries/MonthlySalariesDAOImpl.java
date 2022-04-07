package sample.dao.monthlysalaries;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.common.database.AccountingQueries;
import sample.common.database.ConnectionFactory;
import sample.dto.EmployeeANDDepartmentDTO;
import sample.dto.MonthlySalariesDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MonthlySalariesDAOImpl implements MonthlySalariesDAO{
    @Override
    public Integer save(MonthlySalariesDTO monthlySalariesDTO) {
        return null;
    }

    @Override
    public Boolean update(MonthlySalariesDTO monthlySalariesDTO) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public MonthlySalariesDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<MonthlySalariesDTO> search(int id) {
        ObservableList<MonthlySalariesDTO> monthlySalariesObservableList = FXCollections.observableArrayList();
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(AccountingQueries.SELECT_SALARIES_FOR_EMPLOYEE)
        )
        {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                monthlySalariesObservableList.add(new MonthlySalariesDTO(
                        resultSet.getLong("ID"),
                        resultSet.getString("الشهر"),
                        resultSet.getDouble("المدفوع"),
                        resultSet.getDouble("الراتب المستحق")
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
        return monthlySalariesObservableList;
    }

    @Override
    public ObservableList<MonthlySalariesDTO> listAll() {
        return null;
    }
}
