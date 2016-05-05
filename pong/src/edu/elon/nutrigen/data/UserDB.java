/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.elon.nutrigen.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.elon.nutrigen.business.User;
import edu.elon.nutrigen.utilities.MD5;

/**
 *
 * @author dpowell2
 */
public class UserDB {

	public static boolean userExists(String username, String password) {

		Connection connection = ConnectionPool.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT ind_num FROM nutrigen.testindinfo "
				+ "WHERE ind_id = ? and ind_pw = ?";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, MD5.MD5convert(username));
			ps.setString(2, MD5.MD5convert(password));
			rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(ps);
			ConnectionPool.freeConnection(connection);
			
		}
	}

	public static User selectUser(String username, String password) {
		Connection connection =  ConnectionPool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;

		String query = "SELECT ind_id,ind_pw,indphys_pw,allo,height,weight,ind_gen,preg,"
				+ "lact,in_age,in_state,ind_num,in_pref,smoker,diabetes,celiac,lactint FROM nutrigen.testindinfo "
				+ "WHERE ind_id = ? and ind_pw = ?";

		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, MD5.MD5convert(username));
			ps.setString(2, MD5.MD5convert(password));
			rs = ps.executeQuery();
			user = null;
			if (rs.next()) {
				user = new User();
				user.setIndId(rs.getString("ind_id"));
				user.setIndPw(rs.getString("ind_pw"));
				user.setIndPhysPw(rs.getString("indphys_pw"));
				user.setAllo(rs.getInt("allo"));
				user.setIndHeight(rs.getInt("height"));
				user.setIndWeight(rs.getDouble("weight"));
				user.setGender(rs.getInt("ind_gen"));
				user.setPregnant(rs.getInt("preg"));
				user.setLactating(rs.getInt("lact"));
				user.setAge(rs.getInt("in_age"));
				user.setInState(rs.getInt("in_state"));
				user.setIndNum(rs.getInt("ind_num"));
				user.setPreference(rs.getInt("in_pref"));
				user.setSmoker(rs.getInt("smoker"));
				user.setDiabetes(rs.getInt("diabetes"));
				user.setCeliac(rs.getInt("celiac"));
				user.setLactint(rs.getInt("lactint"));
				// additional processing by Martin to determine DRI group and
				// pseudoage
				user.calculateDRIgrp();
			}
			return user;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(ps);
			ConnectionPool.freeConnection(connection);
			 
		}
	}

	/**
	 * Places login information into th loginlog table
	 * 
	 * @param indNum
	 *            - unique int indentifying user to be insertd.
	 * @return
	 */
	public static int loginLogging(int ind_num) {

		Connection connection = ConnectionPool.getConnection();
		PreparedStatement ps = null;

		// INSERT INTO `loginlog` (login_time,ind_num) VALUES (%s,%s)
		// Use default time for login_time
		// Note: the ind_num is a char(6) here and not a int

		String query = "INSERT INTO nutrigen.loginlog (login_time, ind_num) VALUES (DEFAULT, ?) ";

		try {

			ps = connection.prepareStatement(query);
			// ps.setString(1, "");
			ps.setString(1, String.format("%s", ind_num));

			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			return 0;
		} finally {
			DBUtil.closePreparedStatement(ps);
			ConnectionPool.freeConnection(connection);

		}
	}

}
