/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> (a.start - b.start));

        int end = -1;
        for(Interval interval : intervals) {
            if(end > interval.start) {
                return false;
            }
            end = interval.end;
        }
        return true;
    }
}
