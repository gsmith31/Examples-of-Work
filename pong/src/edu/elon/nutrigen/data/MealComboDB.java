package edu.elon.nutrigen.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import edu.elon.nutrigen.business.Adequacy;
import edu.elon.nutrigen.business.Exercise;
import edu.elon.nutrigen.business.IndCombo;
import edu.elon.nutrigen.business.MealComboNutrients;
import edu.elon.nutrigen.business.MealCombos;
import edu.elon.nutrigen.business.MealPlanner;
import edu.elon.nutrigen.business.Wts;

public class MealComboDB {

	public MealComboDB() {
		// intentionally empty
	}

	public static MealCombos selectMealComboInfo( 
			MealCombos combos, Adequacy adequacy, MealPlanner mealPlanner,
			Wts wts) {
		Connection connection =   ConnectionPool.getConnection();
		 
		PreparedStatement ps = null;
		ResultSet rs = null;
		 
		MealComboNutrients nutrients;
		//String query = "SELECT ind_combotime,ind_num,nrFC,dlt,comborating FROM nutrigen.testindcombo  WHERE ind_num LIKE ?";
		String query = "SELECT nrFC,FC,newcombo_time,item1,item2,item3,item4,item5,item6,item7," +
				"item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18," +
				"item19,item20,item21,sysnr,t_energy,t_sodium,t_potassium,t_freefol,t_fiber," +
				"t_pork,t_kosher,t_lactose,t_ovolacto,t_vegan,t_gluten,t_co2 FROM nutrigen.testmealcombo";
		try {
			ps = connection.prepareStatement(query);
			nutrients = new MealComboNutrients();
			
			rs = ps.executeQuery();
			while (rs.next()) {
				
				nutrients = new MealComboNutrients();
				int nrFC = rs.getInt("nrFC");
				nutrients.setNrFC(nrFC);
				nutrients.setFC(rs.getString("FC"));
				nutrients.setNewcomboTime(rs.getTimestamp("newcombo_time"));
				nutrients.setItem1(rs.getInt("item1"));
				nutrients.setItem2(rs.getInt("item2"));
				nutrients.setItem3(rs.getInt("item3"));
				nutrients.setItem4(rs.getInt("item4"));
				nutrients.setItem5(rs.getInt("item5"));
				nutrients.setItem6(rs.getInt("item6"));
				nutrients.setItem7(rs.getInt("item7"));
				nutrients.setItem8(rs.getInt("item8"));
				nutrients.setItem9(rs.getInt("item9"));
				nutrients.setItem10(rs.getInt("item10"));
				nutrients.setItem11(rs.getInt("item11"));
				nutrients.setItem12(rs.getInt("item12"));
				nutrients.setItem13(rs.getInt("item13"));
				nutrients.setItem14(rs.getInt("item14"));
				nutrients.setItem15(rs.getInt("item15"));
				nutrients.setItem16(rs.getInt("item16"));
				nutrients.setItem17(rs.getInt("item17"));
				nutrients.setItem18(rs.getInt("item18"));
				nutrients.setItem19(rs.getInt("item19"));
				nutrients.setItem20(rs.getInt("item20"));
				nutrients.setItem21(rs.getInt("item21"));
				nutrients.setSysnr(rs.getString("sysnr"));
				int energy = rs.getInt("t_energy");
				nutrients.settEnergy(energy);
				nutrients.settSodium(rs.getInt("t_sodium"));
				nutrients.settPotassium(rs.getInt("t_potassium"));
				nutrients.settFreefol(rs.getInt("t_freefol"));
				nutrients.settFiber(rs.getDouble("t_fiber"));
				nutrients.settPork(rs.getInt("t_pork"));
				nutrients.settKosher(rs.getInt("t_kosher"));
				nutrients.settLactose(rs.getDouble("t_lactose"));
				nutrients.settOvolacto(rs.getInt("t_ovolacto"));
				nutrients.settVegan(rs.getInt("t_vegan"));
				nutrients.settGluten(rs.getInt("t_gluten"));
				nutrients.settCo2(rs.getDouble("t_co2"));
				
				//add nutrients to correct list
				double enhighMult = wts.getEnhighMult();
				double enlowMult = wts.getEnlowMult();
				double endayTarget = adequacy.getEndayTarget();
				if ((energy < (endayTarget * enhighMult))
						&& (energy > (endayTarget * enlowMult))) {
					combos.addFoodCombos(nutrients);
				}
				int [] currentmealplan = mealPlanner.getCurrentMealPlan();
				boolean found = false;
				for (int i = 1; i < 9; i++) {
					if (nrFC == currentmealplan[i]) {
						found = true;
					}
				}
				if (found) {
					combos.addRawCombos(nutrients);
				}  
			}
			 
			return combos;
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
