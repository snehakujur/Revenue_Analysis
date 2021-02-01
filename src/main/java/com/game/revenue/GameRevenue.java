package com.game.revenue;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GameRevenue {
	
	private int memberId;
	private int gameId;
	private double wagerAmount;
	private int noOfWagers;
	private double winAmount;
	private int activityYearmonth;
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public double getWagerAmount() {
		return wagerAmount;
	}
	public void setWagerAmount(double wagerAmount) {
		this.wagerAmount = wagerAmount;
	}
	public int getNoOfWagers() {
		return noOfWagers;
	}
	public void setNoOfWagers(int noOfWagers) {
		this.noOfWagers = noOfWagers;
	}
	public double getWinAmount() {
		return winAmount;
	}
	public void setWinAmount(double winAmount) {
		this.winAmount = winAmount;
	}
	public int getActivityYearmonth() {
		return activityYearmonth;
	}
	public void setActivityYearmonth(int activityYearmonth) {
		this.activityYearmonth = activityYearmonth;
	}		
}
