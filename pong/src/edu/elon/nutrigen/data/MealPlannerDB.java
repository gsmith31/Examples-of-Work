package edu.elon.nutrigen.data;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import edu.elon.nutrigen.business.Calories;
import edu.elon.nutrigen.business.DateManager;
import edu.elon.nutrigen.business.Exercise;
import edu.elon.nutrigen.business.IndCombo;
import edu.elon.nutrigen.business.MealComboCompare;
import edu.elon.nutrigen.business.MealPlanner;
import edu.elon.nutrigen.facade.Meal;
import edu.elon.nutrigen.facade.ScheduledMeal;

public class MealPlannerDB {

	public MealPlannerDB() {
		// intentionally empty
	}

	public static MealPlanner selectMealPlannerInfo(int ind_num, int referenceday) {
		Connection connection =  ConnectionPool.getConnection();
		 
		PreparedStatement ps = null;
		ResultSet rs = null;
		MealPlanner mealPlanner = null;

		String query= "SELECT menucounter,useday_time,ind_num,nrFC,usedata,dlt,useday FROM nutrigen.testmealplanner WHERE ind_num LIKE ?";

		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, String.format("%s", ind_num));
			rs = ps.executeQuery();
			mealPlanner = new MealPlanner();
			 
			while (rs.next()) {
				int useday = rs.getInt("useday");
				int transmeals = useday- referenceday + 1;;
				int nrFC = rs.getInt("nrFC");
				mealPlanner.setCurrentMealPlanItem(transmeals, nrFC);
			}
			//perform additional processing on Calories to set values from arrays using this index..
			mealPlanner.setCurrentMealPlanItem(0, 0);
			mealPlanner.setCurrentMealPlanItem(9, 0);
			return mealPlanner;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(ps);
			ConnectionPool.freeConnection(connection);
			 
		}
	}
	
	public static List<ScheduledMeal> selectMealPlannerByMonthInfo(int ind_num, int startReferenceDay, int endReferenceDay) {
		Connection connection =  ConnectionPool.getConnection();
		DateManager dateManager = new DateManager();
		 
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ScheduledMeal> meals = new ArrayList<ScheduledMeal>();
		 

		String query= "SELECT menucounter,useday_time,ind_num,nrFC,usedata,dlt,useday FROM nutrigen.testmealplanner " +
		" WHERE ind_num LIKE ? and useday >= ? and useday <= ?";
		
		System.out.println(query);
		System.out.println("Start date: " + startReferenceDay);
		System.out.println("End date: " + endReferenceDay);

		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, String.format("%s", ind_num));
			ps.setInt(2, startReferenceDay);
			ps.setInt(3, endReferenceDay);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				ScheduledMeal meal = new ScheduledMeal();
				int useday = rs.getInt("useday");
				int nrFC = rs.getInt("nrFC");
				double dlt = rs.getDouble("dlt");
				meal.setDate(dateManager.getDateFromReferenceDay(useday));
				meal.setReferenceDay(useday);
				meal.setExists(true);
				meal.setMealNumber(nrFC);
				meal.setDlt(dlt);
				meals.add(meal);
			}
			return meals;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(ps);
			ConnectionPool.freeConnection(connection);
			 
		}
	}
	
	public static Meal selectMealPlanByDateInfo(int ind_num, int referenceDay) {
		Connection connection =  ConnectionPool.getConnection();
		DateManager dateManager = new DateManager();
		 
		PreparedStatement ps = null;
		ResultSet rs = null;
		 
		String query= "SELECT menucounter,useday_time,ind_num,nrFC,usedata,dlt,useday FROM nutrigen.testmealplanner " +
		" WHERE ind_num LIKE ? and useday = ?";
		
		System.out.println(query);
		System.out.println("date: " + referenceDay);

		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, String.format("%s", ind_num));
			ps.setInt(2, referenceDay);
			rs = ps.executeQuery();
			Meal meal = null;
			while (rs.next()) {
				int nrFC = rs.getInt("nrFC");
				meal = new Meal();
				meal.setMealNumber(nrFC);
			}
			return meal;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(ps);
			ConnectionPool.freeConnection(connection);
			 
		}
	}
	
	public static int assignMealPlan(int ind_num, Date date, int assignedDate, int nrFC, int dlt) {

		Connection connection = ConnectionPool.getConnection();
		PreparedStatement ps = null;

		// Note: the ind_num is a char(6) here and not a int

		String query = "INSERT INTO nutrigen.testmealplanner (useday_time, ind_num, nrFC, usedata, dlt, useday) VALUES (?, ?, ?, ?, ?, ?) ";

		try {

			ps = connection.prepareStatement(query);
			String usedata = "000000000000000000000000000000000000000000000";
			 
			int useday = assignedDate;
			ps.setInt(1, date.getYear() + 1900);
			ps.setString(2, String.format("%s", ind_num));
			ps.setInt(3, nrFC);
			ps.setString(4, usedata);
			ps.setInt(5, dlt);
			ps.setInt(6, useday);

			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			return 0;
		} finally {
			DBUtil.closePreparedStatement(ps);
			ConnectionPool.freeConnection(connection);

		}
	}
	
	public static int deleteMealPlan(int ind_num, int assignedDate) {

		Connection connection = ConnectionPool.getConnection();
		PreparedStatement ps = null;

		// Note: the ind_num is a char(6) here and not a int

		String query = "DELETE FROM nutrigen.testmealplanner WHERE ind_num LIKE ? AND useday = ?";

		try {
			ps = connection.prepareStatement(query);
			int useday = assignedDate;
			ps.setString(1, String.format("%s", ind_num));
			ps.setInt(2, useday);
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
