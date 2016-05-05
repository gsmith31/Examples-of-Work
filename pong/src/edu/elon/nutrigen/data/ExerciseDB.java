package edu.elon.nutrigen.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import edu.elon.nutrigen.business.Exercise;

public class ExerciseDB {

	public ExerciseDB() {
		// intentionally empty
	}

	public static Exercise selectExerciseInfo(int ind_num) {
		Connection connection =   ConnectionPool.getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Exercise exercise = null;

		String query = "SELECT exercise_time, intex, modex FROM nutrigen.testexercise WHERE ind_num LIKE ?";

		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, String.format("%s", ind_num));
			rs = ps.executeQuery();
			exercise = null;
			if (rs.next()) {
				exercise = new Exercise();

				exercise.setExerciselastupdatedDisp(rs
						.getTimestamp("exercise_time"));
				exercise.setIntexercise(rs.getInt("intex"));
				exercise.setModexercise(rs.getInt("modex"));

			}
			return exercise;
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
