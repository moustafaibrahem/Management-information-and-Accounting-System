package sample.dao.salariesandsalarydetails;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.common.database.AccountingQueries;
import sample.common.database.ConnectionFactory;
import sample.dto.SalariesANDSalaryDetailsDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalariesANDSalaryDetailsDAOImpl implements SalariesANDSalaryDetailsDAO {
    @Override
    public Integer save(SalariesANDSalaryDetailsDTO salariesANDSalaryDetailsDTO) {
        return null;
    }

    @Override
    public Boolean update(SalariesANDSalaryDetailsDTO salariesANDSalaryDetailsDTO) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public SalariesANDSalaryDetailsDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<SalariesANDSalaryDetailsDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<SalariesANDSalaryDetailsDTO> listAll() {
        return null;
    }

    @Override
    public ObservableList<SalariesANDSalaryDetailsDTO> search(int empCode, String date) {
        ObservableList<SalariesANDSalaryDetailsDTO> salarysANDSalaryDetailsObservableList = FXCollections.observableArrayList();
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(AccountingQueries.SELECT_SALARY_DETAILS)
        )
        {
            preparedStatement.setInt(1,empCode);
            preparedStatement.setString(2,date);
            ResultSet resultSet = preparedStatement.executeQuery();
            Double monthlySalary=0.0,reservedSalary=0.0,takenSalary=0.0;

            while (resultSet.next())
            {
                monthlySalary = resultSet.getDouble("الراتب المستحق");
                takenSalary+= resultSet.getDouble("المدفوع");
                reservedSalary = monthlySalary - takenSalary;
                salarysANDSalaryDetailsObservableList.add(new SalariesANDSalaryDetailsDTO(
                        resultSet.getString("الشهر"),
                        resultSet.getDouble("المدفوع"),
                        resultSet.getString("التاريخ"),
                        reservedSalary
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
        return salarysANDSalaryDetailsObservableList;
    }
}
