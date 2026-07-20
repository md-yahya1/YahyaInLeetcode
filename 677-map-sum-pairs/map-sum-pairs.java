class MapSum {

    HashMap<String, Integer> map;
    public MapSum() {
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        
        int total = 0;

        for(String value : map.keySet())
        {
            if(value.startsWith(prefix))
            {
                total += map.get(value);
            }
        }

        return total;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */