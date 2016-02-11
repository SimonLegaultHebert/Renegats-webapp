package webapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Summoner {

	private int id;
	private String name;
	private int profileIconId;
	private LinkedHashMap<Champion, Stats> mostPlayedChampions;
	private Stats summaryStats;
	private RankedDivision rankedDivision;
	
	public Summoner(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProfileIconId() {
		return profileIconId;
	}

	public void setProfileIconId(int profileIconId) {
		this.profileIconId = profileIconId;
	}

	public LinkedHashMap<Champion, Stats> getMostPlayedChampions() {
		return mostPlayedChampions;
	}

	public void setMostPlayedChampions(LinkedHashMap<Champion, Stats> mostPlayedChampions) {
		this.mostPlayedChampions = mostPlayedChampions;
	}

	public Stats getSummaryStats() {
		return summaryStats;
	}

	public void setSummaryStats(Stats summaryStats) {
		this.summaryStats = summaryStats;
	}

	public RankedDivision getRankedDivision() {
		return rankedDivision;
	}

	public void setRankedDivision(RankedDivision rankedDivision) {
		this.rankedDivision = rankedDivision;
	}

	@Override
	public String toString() {
		return "Summoner [id=" + id + ", name=" + name + ", profileIconId="
				+ profileIconId + ", mostPlayedChampions="
				+ mostPlayedChampions + ", summaryStats=" + summaryStats
				+ ", rankedDivision=" + rankedDivision + "]";
	}

}
