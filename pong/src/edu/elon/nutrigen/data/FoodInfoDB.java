package edu.elon.nutrigen.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import edu.elon.nutrigen.business.Allpass;
import edu.elon.nutrigen.business.Exercise;
import edu.elon.nutrigen.business.FoodInfo;
import edu.elon.nutrigen.business.IndCombo;
import edu.elon.nutrigen.business.OptInfo;
import edu.elon.nutrigen.facade.NutritionalItem;

/**
 * Creates instance of FoodInfo object with data from foodinfo db. This is the object
 * that does a lot of work to fill in date into Allpass
 * @author dpowell2
 *
 */
public class FoodInfoDB {

	public FoodInfoDB() {
		// intentionally empty
	}

	public static FoodInfo selectFoodInfo(OptInfo optInfo, Allpass foods) {
		Connection connection =  ConnectionPool.getConnection();
		 
		PreparedStatement ps = null;
		ResultSet rs = null;
		FoodInfo foodInfo = null;
		
		//String query = "SELECT ind_combotime,ind_num,nrFC,dlt,comborating FROM nutrigen.testindcombo  WHERE ind_num LIKE ?";
		String query  = "SELECT nrF,NDBnumber,label,ovolacto,lacfree,kosher,amount,less,more,redmeatF,"
				+ "vegF,fruitF,fruitvegF,fishF,type,type2,type3,type4,type5,enF,prF,fatF,satF,soF," 
				+ "potF,cholF,carbF,sugarF,fiberF,foF,freefoF,vcF,vaF,retF,bcF,caF,mgF,phosF,"
				+ "feF FROM nutrigen.testfoodinfo";

		try {
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			//foodInfo = new FoodInfo(optInfo, foods);
			/* I can get the size of the result set to allocate arrays in food info to speed things up */
			rs.last();
			int size = rs.getRow();
			rs.beforeFirst();
			System.out.println("Result set in Food Info has " + size + " entries");
			foodInfo = new FoodInfo(optInfo, foods, size);
			while (rs.next()) {
				foodInfo.setNrF(rs.getInt("nrF"));
				foodInfo.setAmount(rs.getInt("amount"));
				foodInfo.setLess(rs.getInt("less"));
				foodInfo.setMore(rs.getInt("more"));
				foodInfo.setNDBnumber(rs.getInt("NDBnumber"));
				foodInfo.setLabel(rs.getString("label"));
				foodInfo.setOvolacto(rs.getInt("ovolacto"));
				foodInfo.setEnF(rs.getInt("enF"));
				foodInfo.setInvarsElement(2, rs.getInt("redmeatF"));
				foodInfo.setInvarsElement(6, rs.getInt("fruitvegF"));
				foodInfo.setInvarsElement(12, rs.getDouble("prF"));
				foodInfo.setInvarsElement(13, rs.getDouble("fatF"));
				foodInfo.setInvarsElement(14, rs.getDouble("satF"));
				foodInfo.setInvarsElement(16, rs.getInt("sof"));
				foodInfo.setInvarsElement(17, rs.getDouble("potF"));
				foodInfo.setInvarsElement(18, rs.getInt("cholF"));
				foodInfo.setInvarsElement(24, rs.getDouble("carbF"));
				foodInfo.setInvarsElement(25, rs.getDouble("sugarF"));
				foodInfo.setInvarsElement(26, rs.getDouble("fiberF"));
				foodInfo.setInvarsElement(35, rs.getInt("foF"));
				foodInfo.setInvarsElement(38, rs.getInt("freefoF"));
				foodInfo.setInvarsElement(39, rs.getDouble("vcF"));
				foodInfo.setInvarsElement(40, rs.getInt("vaF"));
				foodInfo.setInvarsElement(41, rs.getInt("retF"));
				foodInfo.setInvarsElement(42, rs.getInt("bcF"));
				foodInfo.setInvarsElement(46, rs.getInt("caF"));
				foodInfo.setInvarsElement(47, rs.getInt("mgF"));
				foodInfo.setInvarsElement(49, rs.getDouble("feF"));
				foodInfo.setType(rs.getInt("type"));
				foodInfo.setType2(rs.getInt("type2"));
				foodInfo.setType3(rs.getInt("type3"));
				foodInfo.setType4(rs.getInt("type4"));
				foodInfo.setType5(rs.getInt("type5"));
				//foodInfo.addValuesToLists();
				foodInfo.addValuesToArrays();
			} 
			//additional processing on FoodInfo before returning object
			//foodInfo.addListsToFood();
			//foodInfo.clearLists();
			foodInfo.addArraysToFood();
			return foodInfo;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(ps);
			ConnectionPool.freeConnection(connection);
			 
		}
	}
	
	public static ArrayList<NutritionalItem> selectMealItemNutrientInfo(OptInfo optInfo, int itemNumber) {
		Connection connection =  ConnectionPool.getConnection();
		 
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query  = "SELECT nrF,NDBnumber,label,ovolacto,lacfree,kosher,amount,less,more,redmeatF,"
				+ "vegF,fruitF,fruitvegF,fishF,type,type2,type3,type4,type5,enF,prF,fatF,satF,soF," 
				+ "potF,cholF,carbF,sugarF,fiberF,foF,freefoF,vcF,vaF,retF,bcF,caF,mgF,phosF,"
				+ "feF FROM nutrigen.testfoodinfo where nrF=?";
		ArrayList<NutritionalItem> items = new ArrayList<NutritionalItem>();
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, itemNumber);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				items.add(new NutritionalItem("Energy", rs.getInt("enF"), "kcal"));
				items.add(new NutritionalItem(optInfo.getNut0name(), rs.getDouble("prF"), optInfo.getNut0unit()));
				items.add(new NutritionalItem(optInfo.getNut1name(), rs.getDouble("satF"), optInfo.getNut1unit()));
				items.add(new NutritionalItem(optInfo.getNut2name(), rs.getInt("cholF"), optInfo.getNut2unit()));
				items.add(new NutritionalItem(optInfo.getNut3name(), rs.getInt("foF"), optInfo.getNut3unit()));
				items.add(new NutritionalItem(optInfo.getNut4name(), rs.getInt("freefoF"), optInfo.getNut4unit()));
				items.add(new NutritionalItem(optInfo.getNut5name(), rs.getDouble("vcF"), optInfo.getNut5unit()));
				items.add(new NutritionalItem(optInfo.getNut6name(), rs.getDouble("feF"), optInfo.getNut6unit()));
				items.add(new NutritionalItem(optInfo.getNut7name(), rs.getInt("soF"), optInfo.getNut7unit()));
				items.add(new NutritionalItem(optInfo.getNut8name(), rs.getInt("caF"), optInfo.getNut8unit()));
				items.add(new NutritionalItem(optInfo.getNut9name(), rs.getInt("mgF"), optInfo.getNut9unit()));
				items.add(new NutritionalItem(optInfo.getNutaname(), rs.getInt("redmeatF"), optInfo.getNutaunit()));
				items.add(new NutritionalItem(optInfo.getNutbname(), rs.getInt("fruitvegF"), optInfo.getNutbunit()));
				items.add(new NutritionalItem(optInfo.getNutcname(), rs.getInt("vaF"), optInfo.getNutcunit()));
				items.add(new NutritionalItem(optInfo.getNutdname(), rs.getInt("retF"), optInfo.getNutdunit()));
				items.add(new NutritionalItem(optInfo.getNutename(), rs.getInt("bcF"), optInfo.getNuteunit()));	 
			} 
			 
			return items;
		} catch (SQLException e) {
			System.out.println(e);
			return items;
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(ps);
			ConnectionPool.freeConnection(connection);
			 
		}
	}

}
