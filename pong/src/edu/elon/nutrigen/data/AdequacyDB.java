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



import edu.elon.nutrigen.business.Adequacy;
import edu.elon.nutrigen.business.User;
import edu.elon.nutrigen.utilities.MD5;

/**
 * Class to control DB interaction with Adequacy
 * @author dpowell2
 */
public class AdequacyDB {
	
		  /**
		   * Places adequacy rate information into testadequacy table
		   * 
		   * @param indNum - unique int indentifying user
		   * @param adequacy - adequacy instance containing properties for insertion
		   * @return
		   */
		  public static int insertAdequacyRates(int ind_num, Adequacy adequacy) {
			   
			    Connection connection =   ConnectionPool.getConnection();
			     
			    PreparedStatement ps = null;
			    
			    //Use default time for adequacy_time
			    //Note: the ind_num is a char(6) here and not a int
			    String insert = "INSERT INTO nutrigen.testadequacy (adequacy_time,ind_num,ratefruits,ratevegs," +
			    		"ratemeat,ratefol,ratevc,ratebc,rateca,ratevd,asstype) VALUES (DEFAULT,?,?,?,?,?,?,?,?,?,?)";     
			    try {
			      ps = connection.prepareStatement(insert);
			      ps.setString(1, String.format("%s", ind_num));
			      ps.setInt(2, adequacy.getRatefruits());
			      ps.setInt(3, adequacy.getRatevegs());
			      ps.setInt(4, adequacy.getRatemeat());
			      ps.setInt(5, adequacy.getRatefol());
			      ps.setInt(6, adequacy.getRatevc());
			      ps.setInt(7, adequacy.getRatebc());
			      ps.setInt(8, adequacy.getRateca());
			      ps.setInt(9, adequacy.getRatevd());
			      ps.setInt(10, adequacy.getAsstype());
			      
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
