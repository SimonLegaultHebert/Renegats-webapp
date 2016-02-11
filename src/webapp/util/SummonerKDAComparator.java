package webapp.util;

import java.util.Comparator;

import webapp.model.Summoner;

/**
 * Rank summoners by KDA. (Descending order)
 * @author Leg
 *
 */
public class SummonerKDAComparator implements Comparator<Summoner>{

	@Override
	public int compare(Summoner sum1, Summoner sum2) {
		int compareTo = 0;	
		if(sum1.getSummaryStats().getKda() > sum2.getSummaryStats().getKda()){
			compareTo = -1;
		}else if(sum1.getSummaryStats().getKda() < sum2.getSummaryStats().getKda()){
			compareTo = 1;
		}
		return compareTo;
	}

}
