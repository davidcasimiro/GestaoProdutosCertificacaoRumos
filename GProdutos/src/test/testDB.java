package test;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import repository.DButils;

public class testDB {

	public static void main(String[] args) {

		String sql = "SELECT * From produto";
		
		try {
			Connection connection = (Connection) DButils.getDataSource().getConnection();
//			Statement statement = connection.createStatement();
//			ResultSet resultSet = statement.executeQuery(sql);
//			
//			while(resultSet.next()) {
//				System.out.println(resultSet.getString(4));
//			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
