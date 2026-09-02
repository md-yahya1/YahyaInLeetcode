class Solution {
    public long totalCost(int[] costs, int k, int candidates) {

        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int l = 0;
        int r = costs.length - 1;

        long sum = 0;

        for (int i = 0; i < candidates && l <= r; i++) {
            left.add(costs[l++]);
        }

        for (int i = 0; i < candidates && l <= r; i++) {
            right.add(costs[r--]);
        }

        while (k-- > 0) {
            if (left.isEmpty()) {
                // right
                sum += right.poll();

                if(l <= r)
                {
                    right.add(costs[r--]);
                }
            } else if (right.isEmpty()) {
                // left

                sum += left.poll();

                if(l <= r)
                {
                    left.add(costs[l++]);
                }
            } else if (left.peek() <= right.peek()) {
                // left
                sum += left.poll();

                if(l <= r)
                {
                    left.add(costs[l++]);
                }
            } else {
                // right
                sum += right.poll();

                if(l <= r)
                {
                    right.add(costs[r--]);
                }
            }
        }

        return sum;

    }
}