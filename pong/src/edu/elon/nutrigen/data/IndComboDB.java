package edu.elon.nutrigen.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import edu.elon.nutrigen.business.Exercise;
import edu.elon.nutrigen.business.IndCombo;

public class IndComboDB {

	public IndComboDB() {
		// intentionally empty
	}

	public static IndCombo selectIndComboInfo(int ind_num) {
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		IndCombo indCombo = null;
		
 

		//String query = "SELECT exercise_time, intex, modex FROM nutrigen.testexercise WHERE ind_num LIKE ?";
		String query = "SELECT ind_combotime,ind_num,nrFC,dlt,comborating FROM nutrigen.testindcombo  WHERE ind_num LIKE ?";

		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, String.format("%s", ind_num));
			rs = ps.executeQuery();
			indCombo = new IndCombo();
			while (rs.next()) {
				int nrFC = rs.getInt("nrFC");
				int comborating = rs.getInt("comborating");
				indCombo.addPreference(nrFC, comborating);
			}
			//perform additional processing on IndCombo to determine max nrFC and then set preferences.
			indCombo.additionalProcessing();
			return indCombo;
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
