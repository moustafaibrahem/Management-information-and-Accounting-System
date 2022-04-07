package sample.dao.monthlyloans;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.common.database.AccountingQueries;
import sample.common.database.ConnectionFactory;
import sample.dto.EmployeeDTO;
import sample.dto.MonthlyLoansDTO;
import sample.dto.SalariesANDSalaryDetailsDTO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MonthlyLoansDAOImpl implements MonthlyLoansDAO {
    @Override
    public Integer save(MonthlyLoansDTO monthlyLoansDTO) {
        return null;
    }

    @Override
    public Boolean update(MonthlyLoansDTO monthlyLoansDTO) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public MonthlyLoansDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<MonthlyLoansDTO> search(int id) {
        ObservableList<MonthlyLoansDTO> monthlyLoansObservableList = FXCollections.observableArrayList();
        try (Connection conn = ConnectionFactory.createConnection();
             CallableStatement callableStatement = conn.prepareCall(AccountingQueries.SELECT_MONTHLY_LOANS_FOR_EMPLOYEE)
        ) {
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                monthlyLoansObservableList.add(new MonthlyLoansDTO(
                        resultSet.getInt("ID"),
                        resultSet.getString("الشهر"),
                        resultSet.getDouble("ما تم تسديده من السلفة"),
                        resultSet.getDouble("مبلغ السلفة")
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
        return monthlyLoansObservableList;
    }

    @Override
    public ObservableList<MonthlyLoansDTO> listAll() {
        return null;
    }
}
