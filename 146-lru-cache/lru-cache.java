class LRUCache {

    class Node{
        int key, val;
        Node prev, next;

        Node(int k, int v)
        {
            this.key = k;
            this.val = v;
        }
    }

    public int capacity;
    public Node head;
    public Node tail;

    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;

    }
    
    public int get(int key) {
        
        if(!map.containsKey(key))
        {
            return -1;
        }
        else{
            Node node = map.get(key);

            remove(node);
            insert(node);

            return node.val;
        }
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            node.val = value;

            remove(node);
            insert(node);
        }
        else{
            if(capacity == map.size())
            {
                Node lastNode = tail.prev;
                remove(lastNode);
                map.remove(lastNode.key);
            }

            Node newNode = new Node(key, value);

            insert(newNode);
            map.put(key, newNode);
        }
    }

    public void insert(Node node)
    {
        Node nextNode = head.next;

        head.next = node;
        node.prev = head;

        node.next = nextNode;
        nextNode.prev = node;
    }

    public void remove(Node node)
    {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */