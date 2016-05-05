package edu.elon.nutrigen.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import edu.elon.nutrigen.business.OptInfo;


public class OptInfoDB {
	
	public static OptInfo selectOptInfo(int ind_num) {
		  Connection connection =  ConnectionPool.getConnection();
		  
		  PreparedStatement ps = null;
		  ResultSet rs = null;
		  OptInfo optInfo = null;

	    
	    String query = "SELECT opt_time,ind_id,ind_num,optenh,optenl,opt0h,opt0l,opt1h,opt1l,opt2h,opt2l,opt3h,opt3l,opt4h,opt4l,opt5h," +
	    		"opt5l,opt6h,opt6l,opt7h,opt7l,opt8h,opt8l,opt9h,opt9l,optah,optal,optbh,optbl,optch,optcl,optdh,optdl,opteh,optel,apt0l," +
	    		"apt0h,apt1l,apt1h,apt2l,apt2h,apt3l,apt3h,apt4l,apt4h,apt5l,apt5h,apt6l,apt6h,apt7l,apt7h,apt8l,apt8h,apt9l,apt9h,aptah," +
	    		"aptal,aptbh,aptbl,aptch,aptcl,aptdh,aptdl,apteh,aptel,sel0,sel1,sel2,sel3,sel4,sel5,sel6,sel7,sel8,sel9,sela,selb,selc," +
	    		"seld,sele,link0,link1,link2,link3,link4,link5,link6,link7,link8,link9,linka,linkb,linkc,linkd,linke FROM nutrigen.testopt WHERE ind_num LIKE ?";
		
	    try {
	      ps = connection.prepareStatement(query);
	      ps.setString(1,  String.format("%s", ind_num));
	      rs = ps.executeQuery();
	      optInfo = null;
	      if (rs.next()) {
	        optInfo = new OptInfo();
	        
	        Timestamp optTime = rs.getTimestamp("opt_time");
	        optInfo.setOptenh(rs.getInt("optenh"));
	        optInfo.setOptenl(rs.getInt("optenl"));
	        optInfo.setOpt0h(rs.getInt("opt0h"));
	        optInfo.setOpt0l(rs.getInt("opt0l"));
	        optInfo.setOpt1h(rs.getInt("opt1h"));
	        optInfo.setOpt1l(rs.getInt("opt1l"));
	        optInfo.setOpt2h(rs.getInt("opt2h"));
	        optInfo.setOpt2l(rs.getInt("opt2l"));
	        optInfo.setOpt3h(rs.getInt("opt3h"));
	        optInfo.setOpt3l(rs.getInt("opt3l"));
	        optInfo.setOpt4h(rs.getInt("opt4h"));
	        optInfo.setOpt4l(rs.getInt("opt4l"));
	        optInfo.setOpt5h(rs.getInt("opt5h"));
	        optInfo.setOpt5l(rs.getInt("opt5l"));
	        optInfo.setOpt6h(rs.getInt("opt6h"));
	        optInfo.setOpt6l(rs.getInt("opt6l"));
	        optInfo.setOpt7h(rs.getInt("opt7h"));
	        optInfo.setOpt7l(rs.getInt("opt7l"));
	        optInfo.setOpt8h(rs.getInt("opt8h"));
	        optInfo.setOpt8l(rs.getInt("opt8l"));
	        optInfo.setOpt9h(rs.getInt("opt9h"));
	        optInfo.setOpt9l(rs.getInt("opt9l"));
	        optInfo.setOptah(rs.getInt("optah"));
	        optInfo.setOptal(rs.getInt("optal"));
	        optInfo.setOptbh(rs.getInt("optbh"));
	        optInfo.setOptbl(rs.getInt("optbl"));
	        optInfo.setOptch(rs.getInt("optch"));
	        optInfo.setOptcl(rs.getInt("optcl"));
	        optInfo.setOptdh(rs.getInt("optdh"));
	        optInfo.setOptdl(rs.getInt("optdl"));
	        optInfo.setOpteh(rs.getInt("opteh"));
	        optInfo.setOptel(rs.getInt("optel"));
	        
	        optInfo.setApt0h(rs.getInt("apt0h") * 0.001);
	        optInfo.setApt0l(rs.getInt("apt0l") * 0.001);
	        optInfo.setApt1h(rs.getInt("apt1h") * 0.001);
	        optInfo.setApt1l(rs.getInt("apt1l") * 0.001);
	        optInfo.setApt2h(rs.getInt("apt2h") * 0.001);
	        optInfo.setApt2l(rs.getInt("apt2l") * 0.001);
	        optInfo.setApt3h(rs.getInt("apt3h") * 0.001);
	        optInfo.setApt3l(rs.getInt("apt3l") * 0.001);
	        optInfo.setApt4h(rs.getInt("apt4h") * 0.001);
	        optInfo.setApt4l(rs.getInt("apt4l") * 0.001);
	        optInfo.setApt5h(rs.getInt("apt5h") * 0.001);
	        optInfo.setApt5l(rs.getInt("apt5l") * 0.001);
	        optInfo.setApt6h(rs.getInt("apt6h") * 0.001);
	        optInfo.setApt6l(rs.getInt("apt6l") * 0.001);
	        optInfo.setApt7h(rs.getInt("apt7h") * 0.001);
	        optInfo.setApt7l(rs.getInt("apt7l") * 0.001);
	        optInfo.setApt8h(rs.getInt("apt8h") * 0.001);
	        optInfo.setApt8l(rs.getInt("apt8l") * 0.001);
	        optInfo.setApt9h(rs.getInt("apt9h") * 0.001);
	        optInfo.setApt9l(rs.getInt("apt9l") * 0.001);
	        optInfo.setAptah(rs.getInt("aptah") * 0.001);
	        optInfo.setAptal(rs.getInt("aptal") * 0.001);
	        optInfo.setAptbh(rs.getInt("aptbh") * 0.001);
	        optInfo.setAptbl(rs.getInt("aptbl") * 0.001);
	        optInfo.setAptch(rs.getInt("aptch") * 0.001);
	        optInfo.setAptcl(rs.getInt("aptcl") * 0.001);
	        optInfo.setAptdh(rs.getInt("aptdh") * 0.001);
	        optInfo.setAptdl(rs.getInt("aptdl") * 0.001);
	        optInfo.setApteh(rs.getInt("apteh") * 0.001);
	        optInfo.setAptel(rs.getInt("aptel") * 0.001);
	        
	        optInfo.setSel0(rs.getInt("sel0"));
	        optInfo.setSel1(rs.getInt("sel1"));
	        optInfo.setSel2(rs.getInt("sel2"));
	        optInfo.setSel3(rs.getInt("sel3"));
	        optInfo.setSel4(rs.getInt("sel4"));
	        optInfo.setSel5(rs.getInt("sel5"));
	        optInfo.setSel6(rs.getInt("sel6"));
	        optInfo.setSel7(rs.getInt("sel7"));
	        optInfo.setSel8(rs.getInt("sel8"));
	        optInfo.setSel9(rs.getInt("sel9"));
	        optInfo.setSela(rs.getInt("sela"));
	        optInfo.setSelb(rs.getInt("selb"));
	        optInfo.setSelc(rs.getInt("selc"));
	        optInfo.setSeld(rs.getInt("seld"));
	        optInfo.setSele(rs.getInt("sele"));
	        
	        optInfo.setLink0(rs.getInt("link0"));
	        optInfo.setLink1(rs.getInt("link1"));
	        optInfo.setLink2(rs.getInt("link2"));
	        optInfo.setLink3(rs.getInt("link3"));
	        optInfo.setLink4(rs.getInt("link4"));
	        optInfo.setLink5(rs.getInt("link5"));
	        optInfo.setLink6(rs.getInt("link6"));
	        optInfo.setLink7(rs.getInt("link7"));
	        optInfo.setLink8(rs.getInt("link8"));
	        optInfo.setLink9(rs.getInt("link9"));
	        optInfo.setLinka(rs.getInt("linka"));
	        optInfo.setLinkb(rs.getInt("linkb"));
	        optInfo.setLinkc(rs.getInt("linkc"));
	        optInfo.setLinkd(rs.getInt("linkd"));
	        optInfo.setLinke(rs.getInt("linke"));
	        
	      //additional processing  by Martin to nutname, nutunit and nutlinker variables 
	        optInfo.additionalProcessing();
	        
	      }
	      return optInfo;
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
