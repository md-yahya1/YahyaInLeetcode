class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        
        int n = nums1.length;

        int pair[][] = new int[n][2];

        for(int i=0; i<n; i++)
        {
            pair[i][0] = nums2[i];
            pair[i][1] = nums1[i];
        }

        Arrays.sort(pair, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long res=0, runningSum = 0;

        for(int[] p : pair)
        {
            pq.add(p[1]);

            runningSum += p[1];
            if(pq.size() > k)
            {
                runningSum -= pq.poll();
            }
            if(pq.size() == k)
            {
                res = Math.max(res, runningSum*p[0]);
            }
        }

        return res;
    }
}