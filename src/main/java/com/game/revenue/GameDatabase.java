package com.game.revenue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class GameDatabase {
	
	Connection con = null;
	Statement stmt = null;
	/*
	 * Database Connection
	 * MyService: Enter Service name of Oracle database
	 * USERNAME: DB Username
	 * PASSWORD: DB Password
	 * 
	 */
	public GameDatabase() {
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver");			
			String URL = "jdbc:oracle:thin:@localhost:1521/MyService";
			String userName = "USERNAME";
			String password = "PASSWORD";
			con=DriverManager.getConnection(URL, userName, password);
			stmt = con.createStatement();
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		}  
	}
	
	//Get Revenue Details
	public List<GameRevenue> getRevenueDetails(){
		List<GameRevenue> games = new ArrayList<GameRevenue>();
		String sql = "select * from REVENUE_ANALYSIS";
		try {
			Statement stmt = con.createStatement();  
			ResultSet rs = stmt.executeQuery(sql); 
			while(rs.next()) {
				GameRevenue game = new GameRevenue();
				game.setMemberId(rs.getInt(2));
				game.setGameId(rs.getInt(3));
				game.setWagerAmount(rs.getDouble(4));
				game.setNoOfWagers(rs.getInt(5));
				game.setWinAmount(rs.getDouble(6));
				game.setActivityYearmonth(rs.getInt(7));	
				games.add(game);
			}
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		} 
		 
		return games;
	}
	
	//Get Win_Amount
	public GameRevenue getWinAmount(int id, int month, int gameType) {
		String sql = "";
		GameRevenue winAmt = new GameRevenue();
		if ((month == 0) && (gameType == 0)) {
			sql = "select member_id, sum(win_amount) as Win_Amount from REVENUE_ANALYSIS where member_id="+ id +" group by member_id";
			try {				  
				ResultSet rs = stmt.executeQuery(sql); 
				while(rs.next()) {	
					winAmt.setMemberId(rs.getInt(1));
					winAmt.setWinAmount(rs.getDouble(2));
				}
			}
			catch(Exception e)
			{ 
				System.out.println(e);
			} 
		}
		else if((month != 0) && (gameType == 0)) {
			sql = "select member_id, sum(win_amount) as Win_Amount, activity_year_month from REVENUE_ANALYSIS where member_id="+ id 
					+ " and activity_year_month="+ month + " group by member_id, activity_year_month";
			try {				  
				ResultSet rs = stmt.executeQuery(sql); 
				while(rs.next()) {	
					winAmt.setMemberId(rs.getInt(1));
					winAmt.setWinAmount(rs.getDouble(2));
					winAmt.setActivityYearmonth(rs.getInt(3));	
				}
			}
			catch(Exception e)
			{ 
				System.out.println(e);
			} 
		}
		else if((month == 0) && (gameType != 0)) {
			sql = "select member_id, sum(win_amount) as Win_Amount, game_id from REVENUE_ANALYSIS where member_id="+ id
					+ " and game_id="+ gameType	+ " group by member_id, game_id";
			try {				  
				ResultSet rs = stmt.executeQuery(sql); 
				while(rs.next()) {	
					winAmt.setMemberId(rs.getInt(1));
					winAmt.setWinAmount(rs.getDouble(2));
					winAmt.setGameId(rs.getInt(3));					
				}
			}
			catch(Exception e)
			{ 
				System.out.println(e);
			} 
		}
		else if((month != 0) && (gameType != 0)) {
			sql = "select member_id, sum(win_amount) as Win_Amount, activity_year_month, game_id from REVENUE_ANALYSIS where member_id="+ id 
					+ " and activity_year_month="+ month + " and game_id=" + gameType + " group by member_id, activity_year_month, game_id";
			try {				  
				ResultSet rs = stmt.executeQuery(sql); 
				while(rs.next()) {	
					winAmt.setMemberId(rs.getInt(1));
					winAmt.setWinAmount(rs.getDouble(2));
					winAmt.setActivityYearmonth(rs.getInt(3));
					winAmt.setGameId(rs.getInt(4));					
				}
			}
			catch(Exception e)
			{ 
				System.out.println(e);
			} 
		}		
		return winAmt;
	}
	
	//Get Wager_Amount
	public GameRevenue getWagerAmount(int id, int month, int gameType) {
		String sql = "";
		GameRevenue wgrAmt = new GameRevenue();
		if ((month == 0) && (gameType == 0)) {
			sql = "select member_id, sum(wager_amount) as Wager_Amount from REVENUE_ANALYSIS where member_id="+ id +" group by member_id";
			try {				  
				ResultSet rs = stmt.executeQuery(sql); 
				while(rs.next()) {	
					wgrAmt.setMemberId(rs.getInt(1));
					wgrAmt.setWagerAmount(rs.getDouble(2));	
				}
			}
			catch(Exception e)
			{ 
				System.out.println(e);
			} 
		}
		else if((month != 0) && (gameType == 0)) {
			sql = "select member_id, sum(wager_amount) as Wager_Amount, activity_year_month from REVENUE_ANALYSIS where member_id="+ id 
					+ " and activity_year_month="+ month + " group by member_id, activity_year_month";
			try {				  
				ResultSet rs = stmt.executeQuery(sql); 
				while(rs.next()) {	
					wgrAmt.setMemberId(rs.getInt(1));
					wgrAmt.setWagerAmount(rs.getDouble(2));
					wgrAmt.setActivityYearmonth(rs.getInt(3));	
				}
			}
			catch(Exception e)
			{ 
				System.out.println(e);
			} 
		}
		else if((month == 0) && (gameType != 0)) {
			sql = "select member_id, sum(wager_amount) as Wager_Amount, game_id from REVENUE_ANALYSIS where member_id="+ id 
					+ " and game_id="+ gameType	+ " group by member_id, game_id";
			try {				  
				ResultSet rs = stmt.executeQuery(sql); 
				while(rs.next()) {	
					wgrAmt.setMemberId(rs.getInt(1));
					wgrAmt.setWagerAmount(rs.getDouble(2));
					wgrAmt.setGameId(rs.getInt(3));					
				}
			}
			catch(Exception e)
			{ 
				System.out.println(e);
			} 
		}
		else if((month != 0) && (gameType != 0)) {
			sql = "select member_id, sum(wager_amount) as Wager_Amount, activity_year_month, game_id from REVENUE_ANALYSIS where member_id="+ id 
					+ " and activity_year_month="+ month + " and game_id=" + gameType + " group by member_id, activity_year_month, game_id";
			try {				  
				ResultSet rs = stmt.executeQuery(sql); 
				while(rs.next()) {	
					wgrAmt.setMemberId(rs.getInt(1));
					wgrAmt.setWagerAmount(rs.getDouble(2));
					wgrAmt.setActivityYearmonth(rs.getInt(3));
					wgrAmt.setGameId(rs.getInt(4));					
				}
			}
			catch(Exception e)
			{ 
				System.out.println(e);
			} 
		}
		return wgrAmt;
	}
	
	//Get Number_Of_Wagers
	public GameRevenue getNumberOfWagers(int id, int month, int gameType) {
		String sql = "";
		GameRevenue noOfWgr = new GameRevenue();
		if ((month == 0) && (gameType == 0)) {
			sql = "select member_id, count(number_of_wagers) as Number_Of_Wagers from REVENUE_ANALYSIS where member_id="+ id +" group by member_id";
			try {				  
				ResultSet rs = stmt.executeQuery(sql); 
				while(rs.next()) {	
					noOfWgr.setMemberId(rs.getInt(1));
					noOfWgr.setNoOfWagers(rs.getInt(2));		
				}
			}
			catch(Exception e)
			{ 
				System.out.println(e);
			} 
		}
		else if((month != 0) && (gameType == 0)) {
			sql = "select member_id, count(number_of_wagers) as Number_Of_Wagers, activity_year_month from REVENUE_ANALYSIS where member_id="+ id 
					+ " and activity_year_month="+ month + " group by member_id, activity_year_month";
			try {				  
				ResultSet rs = stmt.executeQuery(sql); 
				while(rs.next()) {	
					noOfWgr.setMemberId(rs.getInt(1));
					noOfWgr.setNoOfWagers(rs.getInt(2));
					noOfWgr.setActivityYearmonth(rs.getInt(3));
				}
			}
			catch(Exception e)
			{ 
				System.out.println(e);
			} 
		}
		else if((month == 0) && (gameType != 0)) {
			sql = "select member_id, count(number_of_wagers) as Number_Of_Wagers, game_id from REVENUE_ANALYSIS where member_id="+ id 
					+ " and game_id="+ gameType	+ " group by member_id, game_id";
			try {				  
				ResultSet rs = stmt.executeQuery(sql); 
				while(rs.next()) {	
					noOfWgr.setMemberId(rs.getInt(1));
					noOfWgr.setNoOfWagers(rs.getInt(2));
					noOfWgr.setGameId(rs.getInt(3));
				}
			}
			catch(Exception e)
			{ 
				System.out.println(e);
			} 
		}
		else if((month != 0) && (gameType != 0)) {
			sql = "select member_id, count(number_of_wagers) as Number_Of_Wagers, activity_year_month, game_id from REVENUE_ANALYSIS where member_id="+ id 
					+ " and activity_year_month="+ month + " and game_id=" + gameType + " group by member_id, activity_year_month, game_id";
			try {				  
				ResultSet rs = stmt.executeQuery(sql); 
				while(rs.next()) {	
					noOfWgr.setMemberId(rs.getInt(1));
					noOfWgr.setNoOfWagers(rs.getInt(2));
					noOfWgr.setActivityYearmonth(rs.getInt(3));
					noOfWgr.setGameId(rs.getInt(4));					
				}
			}
			catch(Exception e)
			{ 
				System.out.println(e);
			} 
		}		
		return noOfWgr;
	}	 
}
