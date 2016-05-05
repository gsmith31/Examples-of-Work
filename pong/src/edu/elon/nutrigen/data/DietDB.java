package edu.elon.nutrigen.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import edu.elon.nutrigen.business.Diet;
import edu.elon.nutrigen.business.Exercise;

public class DietDB {

	public DietDB() {
		// intentionally empty
	}

	public static Diet selectDietInfo(int ind_num) {
		Connection connection =  ConnectionPool.getConnection();
		 
		PreparedStatement ps = null;
		ResultSet rs = null;
		Diet diet = null;

		//String query = "SELECT exercise_time, intex, modex FROM nutrigen.testexercise WHERE ind_num LIKE ?";
		String query = "SELECT intake_counter,report_time,ind_num,intake_time,milk,dairy,wholegrain," +
				"boxcereal,melon,oranges,fruits,OJ,cafortifiedjuice,tomato,darkgreen,veggies,legumes," +
				"redmeat,poultry,eggs,coldfish,UV FROM nutrigen.testintake WHERE ind_num LIKE ?";
		
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, String.format("%s", ind_num));
			rs = ps.executeQuery();
			diet = null;
			if (rs.next()) {
				diet = new Diet();
				diet.setIntakelastupdatedDisp(rs.getString("intake_time"));
				diet.setMilk(rs.getInt("milk"));
				diet.setDairy(rs.getInt("dairy"));
				diet.setWholegrain(rs.getInt("wholegrain"));
				diet.setBoxcereal(rs.getInt("boxcereal"));
				diet.setMelon(rs.getInt("melon"));
				diet.setOranges(rs.getInt("oranges"));
				diet.setFruits(rs.getInt("fruits"));
				diet.setOJ(rs.getInt("OJ"));
				diet.setCafortifiedjuice(rs.getInt("cafortifiedjuice"));
				diet.setTomato(rs.getInt("tomato"));
				diet.setDarkgreen(rs.getInt("darkgreen"));
				diet.setVeggies(rs.getInt("veggies"));
				diet.setLegumes(rs.getInt("legumes"));
				diet.setRedmeat(rs.getInt("redmeat"));
				diet.setPoultry(rs.getInt("poultry"));
				diet.setEggs(rs.getInt("eggs"));
				diet.setColdfish(rs.getInt("coldfish"));
				diet.setUV(rs.getInt("UV"));
			}
			return diet;
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
