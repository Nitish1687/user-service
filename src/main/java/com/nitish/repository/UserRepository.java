package com.nitish.repository;

import com.nitish.domain.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Created by nsm1211 on 16-09-2015.
 */
@Repository
public class UserRepository {

    @Autowired
    private DataSource dataSource;

    private static final String USER_INSERT_QUERY = "insert into USER_ACCOUNT (userId, name, emailId) values (?,?,?)";
    private static final String USER_SELECT_QUERY = "select * from USER_ACCOUNT where userId = ?";

    public UserDomain addUser(UserDomain userModel) throws SQLException {
        Connection connection = preparationBeforeSqlUpdate();
        PreparedStatement preparedStatement = connection.prepareStatement(USER_INSERT_QUERY);
        preparedStatement.setInt(1, userModel.getUserId());
        preparedStatement.setString(2, userModel.getName());
        preparedStatement.setString(3, userModel.getEmailId());
        int rowEffected = preparedStatement.executeUpdate();
        System.out.println(" no of row inserted into DB = "+rowEffected);
        preparationAfterSqlUpdate(connection);
        return userModel;
    }

    public List<UserDomain> getUserDomainFor(String userId) throws SQLException {
        Connection connection = preparationBeforeSqlUpdate();
        PreparedStatement preparedStatement = connection.prepareStatement(USER_SELECT_QUERY);
        preparedStatement.setInt(1, parseInt(userId));
        ResultSet resultSet = preparedStatement.executeQuery();
        List<UserDomain> userModelList = new ArrayList<>();
        while (null != resultSet && resultSet.next()) {
            UserDomain userModel = new UserDomain();
            userModel.setUserId(resultSet.getInt(1));
            userModel.setName(resultSet.getString(2));
            userModel.setEmailId(resultSet.getString(3));
            userModelList.add(userModel);
        }
        preparationAfterSqlUpdate(connection);
        return userModelList;
    }

    private void preparationAfterSqlUpdate(Connection connection) throws SQLException {
        connection.commit();
    }

    private Connection preparationBeforeSqlUpdate() throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        return connection;
    }
}
