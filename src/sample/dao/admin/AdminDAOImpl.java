package sample.dao.admin;


import javafx.collections.ObservableList;
import sample.common.database.AccountingQueries;
import sample.common.database.ConnectionFactory;
import sample.dto.AdminDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAOImpl implements AdminDAO{
    @Override
    public Integer save(AdminDTO adminDTO) {
        return null;
    }

    @Override
    public Boolean update(AdminDTO adminDTO) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public AdminDTO search(String id) {
        return null;
    }

    @Override
    public ObservableList<AdminDTO> search(int id) {
        return null;
    }

    @Override
    public ObservableList<AdminDTO> listAll() {
        return null;
    }

    @Override
    public AdminDTO search(String name, String password) {
        AdminDTO adminDTO = new AdminDTO();
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(AccountingQueries.SELECT_ADMIN);
        )
        {
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                adminDTO.setAdminID(resultSet.getInt(1));
                adminDTO.setUsername(name);
                adminDTO.setPassword(password);
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
        return adminDTO;
    }
}
