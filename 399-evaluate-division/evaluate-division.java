class Solution {

    class Pair{
        String node;
        double value;

        Pair(String node, double value)
        {
            this.node = node;
            this.value = value;
        }
    }

    public double dfs(String src, String dest, Map<String, List<Pair> > graph, Set<String> visited)
    {
        if(src.equals(dest))
        {
            return 1.0;
        }

        visited.add(src);

        for(Pair p : graph.get(src))
        {
            if(visited.contains(p.node))
            {
                continue;
            }

            double result = dfs(p.node, dest, graph, visited);

            if(result != -1.0)
            {
                return p.value*result;
            }
        }

        return -1.0;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String, List<Pair> > graph = new HashMap<>(); 

        // build the graph
        for(int i=0; i<equations.size(); i++)
        {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());

            graph.get(a).add(new Pair(b, value));
            graph.get(b).add(new Pair(a, 1.0/value));

        }

        double[] ans = new double[queries.size()];

        for(int i=0; i<queries.size(); i++)
        {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if(!graph.containsKey(src) || !graph.containsKey(dest))
            {
                ans[i] = -1.0;
            }
            else{
                ans[i] = dfs(src, dest, graph, new HashSet<>());
            }

        }

        return ans;
    }
}