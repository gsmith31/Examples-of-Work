package edu.elon.nutrigen.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import edu.elon.nutrigen.business.Calories;
import edu.elon.nutrigen.business.Exercise;
import edu.elon.nutrigen.business.IndCombo;

public class CaloriesDB {

	public CaloriesDB() {
		// intentionally empty
	}

	public static Calories selectCaloriesInfo(int ind_num) {
		Connection connection = ConnectionPool.getConnection();
		 
		PreparedStatement ps = null;
		ResultSet rs = null;
		Calories calories = null;
		
		//String query = "SELECT exercise_time, intex, modex FROM nutrigen.testexercise WHERE ind_num LIKE ?";
		//String query = "SELECT ind_combotime,ind_num,nrFC,dlt,comborating FROM nutrigen.testindcombo  WHERE ind_num LIKE ?";
		String query = "SELECT calorie_time,ind_num,caloriefraction FROM nutrigen.testcalories WHERE ind_num LIKE ?";

		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, String.format("%s", ind_num));
			rs = ps.executeQuery();
			calories = new Calories();
			//Martin is only setting the data based on the last row read
			int calIndex = 0;
			while (rs.next()) {
				calIndex = rs.getInt("caloriefraction");
			}
			//perform additional processing on Calories to set values from arrays using this index..
			calories.additionalProcessing(calIndex);
			return calories;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(ps);
			 
			ConnectionPool.freeConnection(connection);
		}
	}

}
