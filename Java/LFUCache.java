import java.util.LinkedHashMap;
import java.util.Map;

class LFUCache {
	class CacheNode {
		int value, frequency;
		CacheNode() {}
	}

	private int capacity;
	private LinkedHashMap<Integer, CacheNode> map = new LinkedHashMap<>();
	LFUCache(int capacity) { this.capacity = capacity; }

	public void add(int key, int value) {
		if (isFull()) {
			int lfuKey = getLFUKey();
			this.map.remove(lfuKey);
		}
		CacheNode node = new CacheNode();
		node.value = value;
		node.frequency = 0;
		this.map.put(key, node);
	}

	private int getLFUKey() {
		int key = 0, min = Integer.MAX_VALUE;
		for (Map.Entry<Integer, CacheNode> entry : this.map.entrySet()) {
			if (min > entry.getValue().frequency) {
				min = entry.getValue().frequency;
				key = entry.getKey();
			}
		}
		return key;
	}

	public int get(int key) {
		if (!this.map.containsKey(key)) return -1;
		CacheNode temp = this.map.get(key);
		temp.frequency++;
		this.map.put(key, temp);
		return temp.value;
	}

	private boolean isFull() {
		return this.map.size() == this.capacity;
	}
}

/*public class LFUCacheTester {
    public static void main(String args[]) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.add(1, 1);
        lfuCache.add(2, 2);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(2));
    }
}*/
