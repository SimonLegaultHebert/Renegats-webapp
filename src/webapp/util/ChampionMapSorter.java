package webapp.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import webapp.model.Champion;
import webapp.model.Stats;



public class ChampionMapSorter {

	public static LinkedHashMap<Champion, Stats> sort(HashMap<Champion, Stats> mapToSort) {
		List<Map.Entry<Champion, Stats>> entries = new ArrayList<Map.Entry<Champion, Stats>>(mapToSort.size());
 
		entries.addAll(mapToSort.entrySet());
 
		Collections.sort(entries, new Comparator<Map.Entry<Champion, Stats>>() {
			@Override
			public int compare(final Map.Entry<Champion, Stats> entry1, final Map.Entry<Champion, Stats> entry2) {
				return entry1.getValue().compareTo(entry1.getValue(), entry2.getValue());
			}
		});
 
		LinkedHashMap<Champion, Stats> sortedCrunchifyMap = new LinkedHashMap<Champion, Stats>();
		for (Map.Entry<Champion, Stats> entry : entries) {
			sortedCrunchifyMap.put(entry.getKey(), entry.getValue());
		}
		return sortedCrunchifyMap;
	}
}
