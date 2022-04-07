package sample.dao.loansrepaymentdetails;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.common.database.AccountingQueries;
import sample.common.database.ConnectionFactory;
import sample.dto.LoansRepaymentDetailsDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoansRepaymentDetailsDAOImpl implements LoansRepaymentDetailsDAO{
    @Override
    public Integer save(LoansRepaymentDetailsDTO loansRepaymentDetailsDTO) {
        return null;
    }

    @Override
    public Boolean update(LoansRepaymentDetailsDTO loansRepaymentDetailsDTO) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public LoansRepaymentDetailsDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<LoansRepaymentDetailsDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<LoansRepaymentDetailsDTO> listAll() {
        return null;
    }

    @Override
    public ObservableList<LoansRepaymentDetailsDTO> search(int empCode, String date) {
        ObservableList<LoansRepaymentDetailsDTO> loansRepaymentDetailsObservableList = FXCollections.observableArrayList();
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(AccountingQueries.SELECT_LOAN_REPAYMENT_DETAILS)
        )
        {
            preparedStatement.setInt(1,empCode);
            preparedStatement.setString(2,date);
            ResultSet resultSet = preparedStatement.executeQuery();
            Double borrowedMoney=0.0,remainingAmount=0.0,repaidMoney=0.0;
            while (resultSet.next())
            {
                borrowedMoney = resultSet.getDouble("مبلغ السلفه");
                repaidMoney += resultSet.getDouble("المبلغ المسدد");
                remainingAmount = borrowedMoney - repaidMoney;
                loansRepaymentDetailsObservableList.add(new LoansRepaymentDetailsDTO(
                        resultSet.getString("الشهر"),
                        remainingAmount,
                        resultSet.getDouble("المبلغ المسدد"),
                        resultSet.getString("التاريخ")
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
        return loansRepaymentDetailsObservableList;
    }
}
