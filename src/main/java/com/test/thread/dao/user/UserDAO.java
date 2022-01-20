package com.test.thread.dao.user;

import com.test.thread.dao.DBConnection;
import com.test.thread.model.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    public int saveUser(User user) throws SQLException {
        PreparedStatement statement = DBConnection.getConnection().prepareStatement("INSERT INTO USER VALUES (?,?,?);");
        statement.setInt(1, user.getId());
        statement.setString(2, user.getName());
        statement.setString(3, user.getEmail());
        return statement.executeUpdate();
    }
}
