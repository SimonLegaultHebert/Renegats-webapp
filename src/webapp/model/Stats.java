package webapp.model;

import java.text.DecimalFormat;
import java.util.Date;

public class Stats {
	
	private int totalSessionsPlayed;
	private int totalSessionsLost;
	private int totalSessionsWon;
	private int totalChampionKills;
	private int totalMinionKills;
	private int totalDoubleKills;
	private int totalTripleKills;
	private int totalQuadraKills;
	private int totalPentaKills;
	private int totalDeathsPerSession;
	private int totalAssists;
	private int totalTurretsKilled;
	private int totalFirstBlood;
	private int maxLargestKillingSpree;
	private int maxLargestCriticalStrike;
	private int maxChampionsKilled;
	private int maxTimeSpentLiving;
	
	private double winrate;
	private double averageCS;
	private double averageKills;
	private double averageDeaths;
	private double averageAssists;
	private double kda;
	private String maxTimeSpentLivingStringFormat;
	
	public Stats(){
		
	}

	public int getTotalSessionsPlayed() {
		return totalSessionsPlayed;
	}

	public void setTotalSessionsPlayed(int totalSessionsPlayed) {
		this.totalSessionsPlayed = totalSessionsPlayed;
	}

	public int getTotalSessionsLost() {
		return totalSessionsLost;
	}

	public void setTotalSessionsLost(int totalSessionsLost) {
		this.totalSessionsLost = totalSessionsLost;
	}

	public int getTotalSessionsWon() {
		return totalSessionsWon;
	}

	public void setTotalSessionsWon(int totalSessionsWon) {
		this.totalSessionsWon = totalSessionsWon;
	}

	public int getTotalChampionKills() {
		return totalChampionKills;
	}

	public void setTotalChampionKills(int totalChampionKills) {
		this.totalChampionKills = totalChampionKills;
	}

	public int getTotalMinionKills() {
		return totalMinionKills;
	}

	public void setTotalMinionKills(int totalMinionKills) {
		this.totalMinionKills = totalMinionKills;
	}

	public int getTotalDoubleKills() {
		return totalDoubleKills;
	}

	public void setTotalDoubleKills(int totalDoubleKills) {
		this.totalDoubleKills = totalDoubleKills;
	}

	public int getTotalTripleKills() {
		return totalTripleKills;
	}

	public void setTotalTripleKills(int totalTripleKills) {
		this.totalTripleKills = totalTripleKills;
	}

	public int getTotalQuadraKills() {
		return totalQuadraKills;
	}

	public void setTotalQuadraKills(int totalQuadraKills) {
		this.totalQuadraKills = totalQuadraKills;
	}

	public int getTotalPentaKills() {
		return totalPentaKills;
	}

	public void setTotalPentaKills(int totalPentaKills) {
		this.totalPentaKills = totalPentaKills;
	}

	public int getTotalDeathsPerSession() {
		return totalDeathsPerSession;
	}

	public void setTotalDeathsPerSession(int totalDeathsPerSession) {
		this.totalDeathsPerSession = totalDeathsPerSession;
	}

	public int getTotalAssists() {
		return totalAssists;
	}

	public void setTotalAssists(int totalAssists) {
		this.totalAssists = totalAssists;
	}

	public int getTotalTurretsKilled() {
		return totalTurretsKilled;
	}

	public void setTotalTurretsKilled(int totalTurretsKilled) {
		this.totalTurretsKilled = totalTurretsKilled;
	}

	public int getTotalFirstBlood() {
		return totalFirstBlood;
	}

	public void setTotalFirstBlood(int totalFirstBlood) {
		this.totalFirstBlood = totalFirstBlood;
	}

	public int getMaxLargestKillingSpree() {
		return maxLargestKillingSpree;
	}

	public void setMaxLargestKillingSpree(int maxLargestKillingSpree) {
		this.maxLargestKillingSpree = maxLargestKillingSpree;
	}

	public int getMaxLargestCriticalStrike() {
		return maxLargestCriticalStrike;
	}

	public void setMaxLargestCriticalStrike(int maxLargestCriticalStrike) {
		this.maxLargestCriticalStrike = maxLargestCriticalStrike;
	}

	public int getMaxChampionsKilled() {
		return maxChampionsKilled;
	}

	public void setMaxChampionsKilled(int maxChampionsKilled) {
		this.maxChampionsKilled = maxChampionsKilled;
	}

	public int getMaxTimeSpentLiving() {
		return maxTimeSpentLiving;
	}

	public void setMaxTimeSpentLiving(int maxTimeSpentLiving) {
		this.maxTimeSpentLiving = maxTimeSpentLiving;
	}

	public double getWinrate() {
		return winrate;
	}

	public void setWinrate(double winrate) {
		this.winrate = winrate;
	}

	public double getAverageCS() {
		return averageCS;
	}

	public void setAverageCS(double averageCS) {
		this.averageCS = averageCS;
	}

	public double getAverageKills() {
		return averageKills;
	}

	public void setAverageKills(double averageKills) {
		this.averageKills = averageKills;
	}

	public double getAverageDeaths() {
		return averageDeaths;
	}

	public void setAverageDeaths(double averageDeaths) {
		this.averageDeaths = averageDeaths;
	}

	public double getAverageAssists() {
		return averageAssists;
	}

	public void setAverageAssists(double averageAssists) {
		this.averageAssists = averageAssists;
	}

	public double getKda() {
		return kda;
	}

	public void setKda(double kda) {
		this.kda = kda;
	}
	
	public String getMaxTimeSpentLivingStringFormat() {
		return maxTimeSpentLivingStringFormat;
	}

	public void setMaxTimeSpentLivingStringFormat(String maxTimeSpentLivingStringFormat) {
		this.maxTimeSpentLivingStringFormat = maxTimeSpentLivingStringFormat;
	}

	/**
	 * Calculate and set all the average values.
	 */
	public void calculateAverageValues(){
		DecimalFormat df = new DecimalFormat("#.#");
		DecimalFormat df2D = new DecimalFormat("#.##");
		
		double calWinrate = (double)totalSessionsWon / totalSessionsPlayed;
		calWinrate = calWinrate * 100;
		setWinrate(Double.valueOf(df.format(calWinrate)));
		
		double calAverageCs = (double)totalMinionKills / totalSessionsPlayed;
		setAverageCS(Double.valueOf(df.format(calAverageCs)));
		
		double calAverageKills = (double)totalChampionKills / totalSessionsPlayed;
		setAverageKills(Double.valueOf(df.format(calAverageKills)));

		double calAverageDeaths = (double)totalDeathsPerSession / totalSessionsPlayed;
		setAverageDeaths(Double.valueOf(df.format(calAverageDeaths)));
		
		double calAverageAssists = (double)totalAssists / totalSessionsPlayed;
		setAverageAssists(Double.valueOf(df.format(calAverageAssists)));
		
		double calKda = (averageKills + averageAssists) / averageDeaths;
		setKda(Double.valueOf(df2D.format(calKda)));
		
		calculateMaxTimeSpentLivingString();
	}
	
	/**
	 * Change the seconds to MM:SS.
	 */
	private void calculateMaxTimeSpentLivingString(){
		Date date  = new Date(maxTimeSpentLiving * 1000);
		String newFormat = date.getMinutes() + ":" + date.getSeconds();
		setMaxTimeSpentLivingStringFormat(newFormat);
	}

	@Override
	public String toString() {
		return "Stats [totalSessionsPlayed=" + totalSessionsPlayed
				+ ", totalSessionsLost=" + totalSessionsLost
				+ ", totalSessionsWon=" + totalSessionsWon
				+ ", totalChampionKills=" + totalChampionKills
				+ ", totalMinionKills=" + totalMinionKills
				+ ", totalDoubleKills=" + totalDoubleKills
				+ ", totalTripleKills=" + totalTripleKills
				+ ", totalQuadraKills=" + totalQuadraKills
				+ ", totalPentaKills=" + totalPentaKills
				+ ", totalDeathsPerSession=" + totalDeathsPerSession
				+ ", totalAssists=" + totalAssists + ", totalTurretsKilled="
				+ totalTurretsKilled + ", totalFirstBlood=" + totalFirstBlood
				+ ", maxLargestKillingSpree=" + maxLargestKillingSpree
				+ ", maxLargestCriticalStrike=" + maxLargestCriticalStrike
				+ ", maxChampionsKilled=" + maxChampionsKilled
				+ ", maxTimeSpentLiving=" + maxTimeSpentLiving + ", winrate="
				+ winrate + ", averageCS=" + averageCS + ", averageKills="
				+ averageKills + ", averageDeaths=" + averageDeaths
				+ ", averageAssists=" + averageAssists + ", kda=" + kda
				+ ", maxTimeSpentLivingStringFormat="
				+ maxTimeSpentLivingStringFormat + "]";
	}

	public int compareTo(Stats value1, Stats value2) {
		int compareTo = 0;
		if(value1.getTotalSessionsPlayed() > value2.getTotalSessionsPlayed()){
			compareTo = -1;
		}else if(value1.getTotalSessionsPlayed() < value2.getTotalSessionsPlayed()){
			compareTo = 1;
		}
		return compareTo;
	}
	
	
}
