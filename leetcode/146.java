class LRUCache {
    HashMap<Integer, DLL> map;
    DLL head;
    DLL last;
    int capacity;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new DLL(-1, -1);
        last = head;
    }
    
    public int get(int key) {
        // move that node to the end of DLL
        // System.out.println("getting:" + key);
        if (!map.containsKey(key))
            return -1;
        DLL node = map.get(key);
        delete(node);
        append(node);
        // System.out.println("returning value:" + node.val);

        return node.val;
    }
    
    public void put(int key, int value) {
        // System.out.println("putting:" + key + "," + value);
        
        DLL newNode = new DLL(key, value);
        if(map.containsKey(key)) {
            // move that node to the end of DLL with updated value
            DLL oldNode = map.get(key);
            delete(oldNode);
            append(newNode);
            map.put(key, newNode);
        } else {
            // remove LRU value (if map is full) and append to map and DLL
            if (map.size() == capacity) {
                DLL toBeDeleted = head.next;
                delete(toBeDeleted);
                map.remove(toBeDeleted.key);
            }
            append(newNode);
            map.put(key, newNode);
        }
    }

    public DLL delete(DLL node) {
        // System.out.println("deleting:" + node.toString());
        if (null == node.next) {
            node.prev.next = null;
            last = node.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.next = null;
        node.prev = null;
        return node;
    }

    public void append(DLL node) {
        // System.out.println("appending:" + node.toString());
        last.next = node;
        node.prev = last;
        last = node;
    }
}
class DLL{
    int key;
    int val;
    DLL prev;
    DLL next;
    DLL() {}
    DLL(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
    public String toString() {
        return "(" + key + "," + val + ")";
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
