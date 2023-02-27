package id.co.test.service.config;

import java.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SQLCustomStatement {
	@Autowired
	private DBConnection dbConnection;

	public ResultSet executeQuery(String sql) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dbConnection.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			// handle the exception
		} finally {
			if (resultSet != null)
				resultSet.close();
			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		}
		return resultSet;
	}

	public int executeUpdate(String sql) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rowsAffected = 0;
		try {
			connection = dbConnection.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			rowsAffected = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// handle the exception
		} finally {
			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		}
		return rowsAffected;
	}

}
