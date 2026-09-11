class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1;
        int freeTime = intervals[0][1];

        for(int i=1; i<intervals.length; i++)
        {
            int startTime = intervals[i][0];
            if(freeTime <= startTime)
            {
                count++;
                freeTime = intervals[i][1];
            }
        }

        return intervals.length - count;
    }
}