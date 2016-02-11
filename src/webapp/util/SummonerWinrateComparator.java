package webapp.util;

import java.util.Comparator;

import webapp.model.Summoner;

/**
 * Rank summoners by winrate. (Descending order)
 * @author Leg
 *
 */
public class SummonerWinrateComparator implements Comparator<Summoner>{

	@Override
	public int compare(Summoner sum1, Summoner sum2) {
		int compareTo = 0;	
		if(sum1.getSummaryStats().getWinrate() > sum2.getSummaryStats().getWinrate()){
			compareTo = -1;
		}else if(sum1.getSummaryStats().getWinrate() < sum2.getSummaryStats().getWinrate()){
			compareTo = 1;
		}
		return compareTo;
	}

}