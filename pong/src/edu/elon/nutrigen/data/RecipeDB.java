package edu.elon.nutrigen.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.elon.nutrigen.business.User;

/**
 * Get the URL associated with a mealItem
 * @author dpowell2
 *
 */
public class RecipeDB {

	public static String getUrl(int nrF) {
		Connection connection = ConnectionPool.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT linkR FROM nutrigen.testrecipe "
				+ "WHERE nrF = ?";
		String url = null;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, nrF);
			rs = ps.executeQuery();
			if (rs.next()) {
				url = rs.getString("linkR");
			}
			return url;
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
