package sample.dao.monthlyreport;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.common.database.AccountingQueries;
import sample.common.database.ConnectionFactory;
import sample.dto.LoanDetailsDTO;
import sample.dto.MonthlyReportDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MonthlyReportDAOImpl implements MonthlyReportDAO{
    @Override
    public Integer save(MonthlyReportDTO monthlyReportDTO) {
        return null;
    }

    @Override
    public Boolean update(MonthlyReportDTO monthlyReportDTO) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public MonthlyReportDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<MonthlyReportDTO> search(int id) {
        ObservableList<MonthlyReportDTO> monthlyReportObservableList = FXCollections.observableArrayList();
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(AccountingQueries.SELECT_EMPLOYEE_HISTORY)
        )
        {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                monthlyReportObservableList.add(new MonthlyReportDTO(
                        resultSet.getInt("Emp code"),
                        resultSet.getString("name"),
                        resultSet.getString("depName"),
                        resultSet.getString("dateOfEmployment"),
                        resultSet.getDouble("basicSalary"),
                        resultSet.getDouble("monthlySalary"),
                        resultSet.getDouble("monthlyBonus"),
                        resultSet.getDouble("monthlyDiscount"),
                        resultSet.getDouble("monthlyBorrowedMoney"),
                        resultSet.getString("date")
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
        return monthlyReportObservableList;
    }

    @Override
    public ObservableList<MonthlyReportDTO> listAll() {
        return null;
    }

    @Override
    public ObservableList<MonthlyReportDTO> searchByDate(String date) {
        ObservableList<MonthlyReportDTO> monthlyReportObservableList = FXCollections.observableArrayList();
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(AccountingQueries.SELECT_MONTHLY_REPORT)
        )
        {
            preparedStatement.setString(1,date);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                monthlyReportObservableList.add(new MonthlyReportDTO(
                        resultSet.getInt("Emp code"),
                        resultSet.getString("name"),
                        resultSet.getString("depName"),
                        resultSet.getString("dateOfEmployment"),
                        resultSet.getDouble("basicSalary"),
                        resultSet.getDouble("monthlySalary"),
                        resultSet.getDouble("monthlyBonus"),
                        resultSet.getDouble("monthlyDiscount"),
                        resultSet.getDouble("monthlyBorrowedMoney")
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
        return monthlyReportObservableList;
    }

    @Override
    public MonthlyReportDTO search(int empCode, String date) {
        MonthlyReportDTO monthlyReportDTO = new MonthlyReportDTO();
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(AccountingQueries.SELECT_MONTHLY_BONUS_AND_DISCOUNT)
        )
        {
            preparedStatement.setInt(1,empCode);
            preparedStatement.setString(2,date);
            preparedStatement.setString(3,date);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                monthlyReportDTO = new MonthlyReportDTO(
                        resultSet.getDouble(1),
                        resultSet.getDouble(2)
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
        return monthlyReportDTO;
    }
}
