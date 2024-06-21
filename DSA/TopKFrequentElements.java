package DSA;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
      public int[] topKFrequent(int[] nums, int k) {
        //Create and load counter map O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (var num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        //Sort descending on count O(n log n)
        Queue<Integer> maxPQ = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        
        //Use Priority Queue size O(n log n)
        for (var entry : map.entrySet()) {
            maxPQ.add(entry.getKey());
        }
        
        //Load array or use lambda
        var res = new int[k];
        for(var i = k - 1; i >= 0; i--) {
            res[i] = maxPQ.poll();
        }
        return res;
    }
}
