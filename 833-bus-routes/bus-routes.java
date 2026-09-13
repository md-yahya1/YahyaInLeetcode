class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        if(source == target)
        {
            return 0;
        }

        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();

        for(int i=0; i<routes.length; i++)
        {
            for(int stop : routes[i])
            {
                if(!stopToBuses.containsKey(stop))
                {
                    stopToBuses.put(stop, new ArrayList<>());
                }

                stopToBuses.get(stop).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visitedBus = new boolean[routes.length];
        Set<Integer> visistedStop = new HashSet<>();


        queue.offer(source);
        visistedStop.add(source);

        int buses = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();
            buses++;

            for(int i=0; i<size; i++)
            {
                int stop = queue.poll();
                for(int bus : stopToBuses.getOrDefault(stop, new ArrayList<>()))
                {
                    if(visitedBus[bus] == true)
                    {
                        continue;
                    }
                    visitedBus[bus] = true;

                    for(int nextStop : routes[bus])
                    {
                        if(nextStop == target)
                        {
                            return buses;
                        }

                        if(!visistedStop.contains(nextStop))
                        {
                            visistedStop.add(nextStop);
                            queue.offer(nextStop);
                        }
                    }
                }

            }
        }

        return -1;
    }
}