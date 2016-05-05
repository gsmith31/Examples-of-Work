package edu.elon.nutrigen.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import edu.elon.nutrigen.business.Adjust;
import edu.elon.nutrigen.business.OptInfo;
import edu.elon.nutrigen.business.Wts;

public class WtsDB {
	
	public static Wts selectWtsInfo(int ind_num, OptInfo optInfo) {
		  Connection connection =  ConnectionPool.getConnection();
		   
		  PreparedStatement ps = null;
		  ResultSet rs = null;
		  Wts wts = null;

		
		String query = "SELECT wts_time, maxdiff1,maxdiff2,maxdiff3,enlowMult,enhighMult,meatlowt,meathiwt," +
				"redmeatlowt,redmeathiwt,veglowt,veghiwt,brasslowt,brasshiwt,fruitlowt,fruithiwt,fruitveglowt,fruitveghiwt," +
				"fishlowt,fishhiwt,enlowt,enhiwt,alclowt,alchiwt,prlowt,prhiwt,fatlowt,fathiwt,satlowt,sathiwt,translowt," +
				"transhiwt,solowt,sohiwt,potlowt,pothiwt,chollowt,cholhiwt,omega6lowt,omega6hiwt,omega3lowt,omega3hiwt," +
				"alalowt,alahiwt,dhalowt,dhahiwt,epalowt,epahiwt,carblowt,carbhiwt,sugarlowt,sugarhiwt,fiberlowt,fiberhiwt," +
				"solfiblowt,solfibhiwt,insolfiblowt,insolfibhiwt,b1lowt,b1hiwt,b2lowt,b2hiwt,nialowt,niahiwt,b6lowt,b6hiwt," +
				"b12lowt,b12hiwt,freeb12lowt,freeb12hiwt,folowt,fohiwt,cholinelowt,cholinehiwt,betlowt,bethiwt,freefolowt," +
				"freefohiwt,vclowt,vchiwt,valowt,vahiwt,retlowt,rethiwt,bclowt,bchiwt,vdlowt,vdhiwt,velowt,vehiwt,vklowt," +
				"vkhiwt,calowt,cahiwt,mglowt,mghiwt,phoslowt,phoshiwt,felowt,fehiwt,znlowt,znhiwt,culowt,cuhiwt,mnlowt,mnhiwt," +
				"selowt,sehiwt,iodlowt,iodhiwt,lycolowt,lycohiwt,luteinlowt,luteinhiwt,iflavlowt,iflavhiwt,cafflowt," +
				"caffhiwt FROM nutrigen.testwts WHERE ind_num LIKE ?";

		
	    try {
	      ps = connection.prepareStatement(query);
	      ps.setString(1,  String.format("%s", ind_num));
	      rs = ps.executeQuery();
	      wts = null;
	      if (rs.next()) {
	        wts = new Wts();
	        
	        wts.setWtsTime(rs.getTimestamp("wts_time"));
	        wts.setMaxdiff1(rs.getDouble("maxdiff1"));
	        wts.setMaxdiff2(rs.getDouble("maxdiff2"));
	        wts.setMaxdiff3(rs.getDouble("maxdiff3"));
	        wts.setEnlowMult(rs.getDouble("enlowMult"));
	        wts.setEnhighMult(rs.getDouble("enhighMult"));
	        wts.setMeatlowt(rs.getDouble("meatlowt"));
	        wts.setMeathiwt(rs.getDouble("meathiwt"));
	         
	        wts.setRedmeatlowt(rs.getDouble("redmeatlowt"));
	        wts.setRedmeathiwt(rs.getDouble("redmeathiwt"));
	        wts.setVeglowt(rs.getDouble("veglowt"));
	        wts.setVeghiwt(rs.getDouble("veghiwt"));
	        wts.setBrasslowt(rs.getDouble("brasslowt"));
	        wts.setBrasshiwt(rs.getDouble("brasshiwt"));
	        wts.setFruitlowt(rs.getDouble("fruitlowt"));
	        wts.setFruithiwt(rs.getDouble("fruithiwt"));
	        wts.setFruitveglowt(rs.getDouble("fruitveglowt"));
	        wts.setFruitveghiwt(rs.getDouble("fruitveghiwt"));
	        
//			"fishlowt,fishhiwt,enlowt,enhiwt,alclowt,alchiwt,prlowt,prhiwt,fatlowt,fathiwt,satlowt,sathiwt,translowt," +
	        wts.setFishlowt(rs.getDouble("fishlowt"));
	        wts.setFishhiwt(rs.getDouble("fishhiwt"));
	        wts.setEnlowt(rs.getDouble("enlowt"));
	        wts.setEnhiwt(rs.getDouble("enhiwt"));
	        wts.setAlclowt(rs.getDouble("alclowt"));
	        wts.setAlchiwt(rs.getDouble("alchiwt"));
	        wts.setPrlowt(rs.getDouble("prlowt"));
	        wts.setPrhiwt(rs.getDouble("prhiwt"));
	        wts.setFatlowt(rs.getDouble("fatlowt"));
	        wts.setFathiwt(rs.getDouble("fathiwt"));
	        wts.setSatlowt(rs.getDouble("satlowt"));
	        wts.setSathiwt(rs.getDouble("sathiwt"));
	        wts.setTranslowt(rs.getDouble("translowt"));
	        wts.setTranshiwt(rs.getDouble("transhiwt"));
	        
//			"solowt,sohiwt,potlowt,pothiwt,chollowt,cholhiwt,omega6lowt,omega6hiwt,omega3lowt,omega3hiwt," +
	        wts.setSolowt(rs.getDouble("solowt"));
	        wts.setSohiwt(rs.getDouble("sohiwt"));
	        wts.setPotlowt(rs.getDouble("potlowt"));
	        wts.setPothiwt(rs.getDouble("pothiwt"));
	        wts.setChollowt(rs.getDouble("chollowt"));
	        wts.setCholhiwt(rs.getDouble("cholhiwt"));
	        wts.setOmega6lowt(rs.getDouble("omega6lowt"));
	        wts.setOmega6hiwt(rs.getDouble("omega6hiwt"));
	        wts.setOmega3lowt(rs.getDouble("omega3lowt"));
	        wts.setOmega3hiwt(rs.getDouble("omega3hiwt"));
	        
//			"alalowt,alahiwt,dhalowt,dhahiwt,epalowt,epahiwt,carblowt,carbhiwt,sugarlowt,sugarhiwt,fiberlowt,fiberhiwt," +
	        wts.setAlalowt(rs.getDouble("alalowt"));
	        wts.setAlahiwt(rs.getDouble("alahiwt"));
	        wts.setDhalowt(rs.getDouble("dhalowt"));
	        wts.setDhahiwt(rs.getDouble("dhahiwt"));
	        wts.setEpalowt(rs.getDouble("epalowt"));
	        wts.setEpahiwt(rs.getDouble("epahiwt"));
	        wts.setCarblowt(rs.getDouble("carblowt"));
	        wts.setCarbhiwt(rs.getDouble("carbhiwt"));
	        wts.setSugarlowt(rs.getDouble("sugarlowt"));
	        wts.setSugarhiwt(rs.getDouble("sugarhiwt"));
	        wts.setFiberlowt(rs.getDouble("fiberlowt"));
	        wts.setFiberhiwt(rs.getDouble("fiberhiwt"));
	        
//			"solfiblowt,solfibhiwt,insolfiblowt,insolfibhiwt,b1lowt,b1hiwt,b2lowt,b2hiwt,nialowt,niahiwt,b6lowt,b6hiwt," +
	        wts.setSolfiblowt(rs.getDouble("solfiblowt"));
	        wts.setSolfibhiwt(rs.getDouble("solfibhiwt"));
	        wts.setInsolfiblowt(rs.getDouble("insolfiblowt"));
	        wts.setInsolfibhiwt(rs.getDouble("insolfibhiwt"));
	        wts.setB1lowt(rs.getDouble("b1lowt"));
	        wts.setB1hiwt(rs.getDouble("b1hiwt"));
	        wts.setB2lowt(rs.getDouble("b2lowt"));
	        wts.setB2hiwt(rs.getDouble("b2hiwt"));
	        wts.setNialowt(rs.getDouble("nialowt"));
	        wts.setNiahiwt(rs.getDouble("niahiwt"));
	        wts.setB6lowt(rs.getDouble("b6lowt"));
	        wts.setB6hiwt(rs.getDouble("b6hiwt"));
	        
//			"b12lowt,b12hiwt,freeb12lowt,freeb12hiwt,folowt,fohiwt,cholinelowt,cholinehiwt,betlowt,bethiwt,freefolowt," +
	        wts.setB12lowt(rs.getDouble("b12lowt"));
	        wts.setB12hiwt(rs.getDouble("b12hiwt"));
	        wts.setFreeb12lowt(rs.getDouble("freeb12lowt"));
	        wts.setFreeb12hiwt(rs.getDouble("freeb12hiwt"));
	        wts.setFolowt(rs.getDouble("folowt"));
	        wts.setFohiwt(rs.getDouble("fohiwt"));
	        wts.setCholinelowt(rs.getDouble("cholinelowt"));
	        wts.setCholinehiwt(rs.getDouble("cholinehiwt"));
	        wts.setBetlowt(rs.getDouble("betlowt"));
	        wts.setBethiwt(rs.getDouble("bethiwt"));
	        wts.setFreefolowt(rs.getDouble("freefolowt"));
	        wts.setFreefohiwt(rs.getDouble("freefohiwt"));
	        
//			"vclowt,vchiwt,valowt,vahiwt,retlowt,rethiwt,bclowt,bchiwt,vdlowt,vdhiwt,velowt,vehiwt,vklowt," +
	        wts.setVclowt(rs.getDouble("vclowt"));
	        wts.setVchiwt(rs.getDouble("vchiwt"));
	        wts.setValowt(rs.getDouble("valowt"));
	        wts.setVahiwt(rs.getDouble("vahiwt"));
	        wts.setRetlowt(rs.getDouble("retlowt"));
	        wts.setRethiwt(rs.getDouble("rethiwt"));
	        wts.setBclowt(rs.getDouble("bclowt"));
	        wts.setBchiwt(rs.getDouble("bchiwt"));
	        wts.setVdlowt(rs.getDouble("vdlowt"));
	        wts.setVdhiwt(rs.getDouble("vdhiwt"));
	        wts.setVelowt(rs.getDouble("velowt"));
	        wts.setVehiwt(rs.getDouble("vehiwt"));
	        wts.setVklowt(rs.getDouble("vklowt"));
	        wts.setVkhiwt(rs.getDouble("vkhiwt"));
	        
//			"calowt,cahiwt,mglowt,mghiwt,phoslowt,phoshiwt,felowt,fehiwt,znlowt,znhiwt,culowt,cuhiwt,mnlowt,mnhiwt," +
	        wts.setCalowt(rs.getDouble("calowt"));
	        wts.setCahiwt(rs.getDouble("cahiwt"));
	        wts.setMglowt(rs.getDouble("mglowt"));
	        wts.setMghiwt(rs.getDouble("mghiwt"));
	        wts.setPhoslowt(rs.getDouble("phoslowt"));
	        wts.setPhoshiwt(rs.getDouble("phoshiwt"));
	        wts.setFelowt(rs.getDouble("felowt"));
	        wts.setFehiwt(rs.getDouble("fehiwt"));
	        wts.setZnlowt(rs.getDouble("znlowt"));
	        wts.setZnhiwt(rs.getDouble("znhiwt"));
	        wts.setCulowt(rs.getDouble("culowt"));
	        wts.setCuhiwt(rs.getDouble("cuhiwt"));
	        wts.setMnlowt(rs.getDouble("mnlowt"));
	        wts.setMnhiwt(rs.getDouble("mnhiwt"));
	        
//			"selowt,sehiwt,iodlowt,iodhiwt,lycolowt,lycohiwt,luteinlowt,luteinhiwt,iflavlowt,iflavhiwt,cafflowt," +
	        wts.setSelowt(rs.getDouble("selowt"));
	        wts.setSehiwt(rs.getDouble("sehiwt"));
	        wts.setIodlowt(rs.getDouble("iodlowt"));
	        wts.setIodhiwt(rs.getDouble("iodhiwt"));
	        wts.setLycolowt(rs.getDouble("lycolowt"));
	        wts.setLycohiwt(rs.getDouble("lycohiwt"));
	        wts.setLuteinlowt(rs.getDouble("luteinlowt"));
	        wts.setLuteinhiwt(rs.getDouble("luteinhiwt"));
	        wts.setIflavlowt(rs.getDouble("iflavlowt"));
	        wts.setIflavhiwt(rs.getDouble("iflavhiwt"));
	        wts.setCafflowt(rs.getDouble("cafflowt"));
	        wts.setCaffhiwt(rs.getDouble("caffhiwt"));
	         
	      //additional processing  by Martin to set enadj, nut0adj - nut9adj - nuteadj/
	       wts.additionalProcessing(optInfo);
	        
	      }
	      return wts;
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
