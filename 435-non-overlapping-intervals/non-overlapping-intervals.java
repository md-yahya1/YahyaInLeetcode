class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int notOverLapping = 1;
        int freeTime = intervals[0][1];

        for(int i=1; i<intervals.length; i++)
        {
            int start = intervals[i][0];
            if(freeTime <= start)
            {
                freeTime = intervals[i][1];
                notOverLapping++;
            }
        }

        return intervals.length - notOverLapping;

    }
}