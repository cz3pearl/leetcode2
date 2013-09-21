import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class MergeIntervals {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    	if(intervals.size() == 0)
    		return intervals;
    	Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
    	});
        
    	ArrayList<Interval> resultList = new ArrayList<Interval>();
    	Interval lastInterval = intervals.get(0);
    	int size = intervals.size();
    	for(int i = 1; i < size; i++){
    		Interval interval = intervals.get(i);
    		if(lastInterval.end >= interval.start){
    			lastInterval.end = Math.max(interval.end, lastInterval.end);
    		} else {
    			resultList.add(lastInterval);
    			lastInterval = interval;
    		}
    	}
    	resultList.add(lastInterval);
    	return resultList;
    }
}
