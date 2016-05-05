package edu.elon.nutrigen.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import edu.elon.nutrigen.business.Adjust;
import edu.elon.nutrigen.business.OptInfo;

public class AdjustDB {
	
	public static Adjust selectAdjustInfo(int ind_num, OptInfo optInfo) {
		  Connection connection =  ConnectionPool.getConnection();
		   
		  PreparedStatement ps = null;
		  ResultSet rs = null;
		  Adjust adjust = null;

		String query = "SELECT ind_id,ind_num,adj_time,adj_meat,adj_redmeat,adj_veg,adj_brass,adj_fruit,adj_fruitveg,adj_fish,adj_en," +
				"adj_alc,adj_pr,adj_fat,adj_sat,adj_trans,adj_so,adj_pot,adj_chol,adj_omega6,adj_omega3,adj_ala,adj_dha,adj_epa," +
				"adj_carb,adj_sugar,adj_fiber,adj_solfib,adj_insolfib,adj_b1,adj_b2,adj_nia,adj_b6,adj_b12,adj_freeb12,adj_fo," +
				"adj_choline,adj_bet,adj_freefo,adj_vc,adj_va,adj_ret,adj_bc,adj_vd,adj_ve,adj_vk,adj_ca,adj_mg,adj_phos,adj_fe," +
				"adj_zn,adj_cu,adj_mn,adj_se,adj_iod,adj_lyco,adj_lutein3,adj_iflav,adj_caff FROM nutrigen.testadjust WHERE ind_num LIKE ?";

		
	    try {
	      ps = connection.prepareStatement(query);
	      ps.setString(1,  String.format("%s", ind_num));
	      rs = ps.executeQuery();
	      adjust = null;
	      if (rs.next()) {
	        adjust = new Adjust();
	        
	        
	        adjust.setAdjTime(rs.getTimestamp("adj_time"));
	        adjust.setAdjMeat(rs.getDouble("adj_meat"));
	        adjust.setAdjRedmeat(rs.getDouble("adj_redmeat"));
	        adjust.setAdjVeg(rs.getDouble("adj_veg"));
	        adjust.setAdjBrass(rs.getDouble("adj_brass"));
	        adjust.setAdjFruit(rs.getDouble("adj_fruit"));
	        adjust.setAdjFruitveg(rs.getDouble("adj_fruitveg"));
	        adjust.setAdjFish(rs.getDouble("adj_fish"));
	        adjust.setAdjEn(rs.getDouble("adj_en"));   
	  
	        adjust.setAdjAlc(rs.getDouble("adj_alc"));
	        adjust.setAdjPr(rs.getDouble("adj_pr"));
	        adjust.setAdjFat(rs.getDouble("adj_fat"));
	        adjust.setAdjSat(rs.getDouble("adj_sat"));
	        adjust.setAdjTrans(rs.getDouble("adj_trans"));
	        adjust.setAdjSo(rs.getDouble("adj_so"));
	        adjust.setAdjPot(rs.getDouble("adj_pot"));
	        adjust.setAdjChol(rs.getDouble("adj_chol"));
	        adjust.setAdjOmega6(rs.getDouble("adj_omega6"));
	        adjust.setAdjOmega3(rs.getDouble("adj_omega3"));
	        adjust.setAdjAla(rs.getDouble("adj_ala"));
	        adjust.setAdjDha(rs.getDouble("adj_dha"));
	        adjust.setAdjEpa(rs.getDouble("adj_epa"));
	        
	        adjust.setAdjCarb(rs.getDouble("adj_carb"));
	        adjust.setAdjSugar(rs.getDouble("adj_sugar"));
	        adjust.setAdjFiber(rs.getDouble("adj_fiber"));
	        adjust.setAdjSolfib(rs.getDouble("adj_solfib"));
	        adjust.setAdjInsolfib(rs.getDouble("adj_insolfib"));
	        adjust.setAdjB1(rs.getDouble("adj_b1"));
	        adjust.setAdjB2(rs.getDouble("adj_b2"));
	        adjust.setAdjNia(rs.getDouble("adj_nia"));
	        adjust.setAdjB6(rs.getDouble("adj_b6"));
	        adjust.setAdjB12(rs.getDouble("adj_b12"));
	        adjust.setAdjFreeb12(rs.getDouble("adj_freeb12"));
	        adjust.setAdjFo(rs.getDouble("adj_fo"));
	        
	        adjust.setAdjCholine(rs.getDouble("adj_choline"));
	        adjust.setAdjBet(rs.getDouble("adj_bet"));
	        adjust.setAdjFreefo(rs.getDouble("adj_freefo"));
	        adjust.setAdjVc(rs.getDouble("adj_vc"));
	        adjust.setAdjVa(rs.getDouble("adj_va"));
	        adjust.setAdjRet(rs.getDouble("adj_ret"));
	        adjust.setAdjBc(rs.getDouble("adj_bc"));
	        adjust.setAdjVd(rs.getDouble("adj_vd"));
	        adjust.setAdjVe(rs.getDouble("adj_ve"));
	        adjust.setAdjVk(rs.getDouble("adj_vk"));
	        adjust.setAdjCa(rs.getDouble("adj_ca"));
	        adjust.setAdjMg(rs.getDouble("adj_mg"));
	        adjust.setAdjPhos(rs.getDouble("adj_phos"));
	        adjust.setAdjFe(rs.getDouble("adj_fe"));
	        
	        adjust.setAdjZn(rs.getDouble("adj_zn"));
	        adjust.setAdjCu(rs.getDouble("adj_cu"));
	        adjust.setAdjMn(rs.getDouble("adj_mn"));
	        adjust.setAdjSe(rs.getDouble("adj_se"));
	        adjust.setAdjIod(rs.getDouble("adj_iod"));
	        adjust.setAdjLyco(rs.getDouble("adj_lyco"));
	        adjust.setAdjLutein3(rs.getDouble("adj_lutein3"));
	        adjust.setAdjIflav(rs.getDouble("adj_iflav"));
	        adjust.setAdjCaff(rs.getDouble("adj_caff"));
	        
	        
	      //additional processing  by Martin to set enadj, nut0adj - nut9adj - nuteadj/
	       adjust.additionalProcessing(optInfo);
	        
	      }
	      return adjust;
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
