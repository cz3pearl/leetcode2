import java.util.ArrayList;


public class InsertInterval {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        boolean inserted = false;
        for(Interval interval : intervals){
        	if(interval.start > newInterval.end){
        		if(!inserted){
        			result.add(newInterval);
        			inserted = true;
        		}
        		result.add(interval);
        	} else if(interval.end < newInterval.start) {
        		result.add(interval);
        	} else {
        		newInterval.start = Math.min(newInterval.start, interval.start);
        		newInterval.end = Math.max(newInterval.end, interval.end);
        	}
        }
        
        if(!inserted)
        	result.add(newInterval);
    	return result;
    }
     
}
