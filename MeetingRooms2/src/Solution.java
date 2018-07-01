import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	 //Definition for an interval.
	  public class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }
	 
    public int minMeetingRooms(Interval[] intervals) {
        int endingTime=0, endtime = 0;
        int room = 0;
        Interval meetingHours;
        int[] reserved;
        
        if (intervals.length == 0) return 0;
        // sort intervals with start time ??
        
        System.out.println("intervals is:" + intervals.toString());
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval o1, Interval o2)
            {
                    if (o1.start == o2.start) {
                        return 0;
                    } else {
                        return o1.start < o2.start ? -1 : 1;
                    }
            }
        });
        System.out.println("intervals is:" + intervals.toString());
        
        // get the latest end time
        for (int i=0; i<intervals.length;i++){
            endtime = intervals[i].end;
            
            if (endingTime < endtime) endingTime = endtime;
        }
        
        // meeting hours
        meetingHours = new Interval(0, endingTime);
        
        // each meeting state
        reserved = new int[intervals.length];

        while (!checkReserved(reserved)){
            for (int i=0; i<intervals.length;i++){
                if (reserved[i] == 0 && meetingHours.start <= intervals[i].start){
                    meetingHours.start = intervals[i].end;
                    reserved[i] = 1;
                    if (meetingHours.start == meetingHours.end) {
                        break;
                    }
                }
            }
            meetingHours.start = 0;
            room++;
        }
        
        System.out.println("endingTime is " + endingTime);
        return room;
        
    }
    
    public boolean checkReserved(int[] reserved){
        boolean done = true;
        for (int i=0;i<reserved.length;i++){
            if (reserved[i] == 0) done = false;
        }
        return done;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
