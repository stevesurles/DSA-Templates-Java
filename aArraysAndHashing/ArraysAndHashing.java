package aArraysAndHashing;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class ArraysAndHashing {
  public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<Integer>();
    for (int num : nums) {
      if (set.contains(num)) {
        return true;
      }
      set.add(num);
    }
    return false;
  }

  // https://leetcode.com/problems/valid-anagram/
  public boolean isAnagramMap(String s, String t) {
    HashMap<Character, Integer> count = new HashMap<>();

    for (Character c : s.toCharArray()) {
      count.put(c, count.getOrDefault(c, 0) + 1);
    }

    for (Character c : t.toCharArray()) {
      count.put(c, count.getOrDefault(c, 0) - 1);
    }

    for (var entry : count.entrySet()) {
      if (entry.getValue() != 0) {
        return false;
      }
    }
    return true;

  }

  public boolean isAnagramArray(String s, String t) {
    int[] count = new int[26];

    for (Character c : s.toCharArray()) {
      count[c.charValue() - 'a']++;
    }

    for (Character c : t.toCharArray()) {
      count[c.charValue() - 'a']--;
    }

    for (var num : count) {
      if (num != 0) {
        return false;
      }
    }
    return true;

  }

  public int[] topKFrequentSorting(int[] nums, int k) {
    // build map<num, frequence>
    Map<Integer, Integer> count = new HashMap<>();
    for (int num : nums)
      count.put(num, count.getOrDefault(num, 0) + 1);

    // sort list from count.keyset() by count.get(num),
    List<Integer> list = new ArrayList<>(count.keySet());
    Collections.sort(list, (a, b) -> count.get(b) - count.get(a));

    // transfer results from list to int[];
    int[] res = new int[k];
    for (int i = 0; i < k; i++)
      res[i] = list.get(i);

    return res;
  }

  public int[] topKFrequentHeap(int[] nums, int k) {

    Map<Integer, Integer> count = new HashMap<>();
    for (int num : nums) {
      count.put(num, count.getOrDefault(num, 0) + 1);
    }

    Queue<Integer> heap = new PriorityQueue<>((a, b) -> count.get(b) - count.get(a));
    for (int key : count.keySet()) {
      heap.add(key);
    }

    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      ans.add(heap.poll());
      if (heap.size() > k)
        heap.poll();
    }

    return ans.stream().mapToInt(i -> i).toArray();
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    var map = new HashMap<String, List<String>>();
    for (var str : strs) {
      var key = new char[26];
      for (var c : str.toCharArray()) {
        key[c - 'a']++;
      }
      String keyStr = String.valueOf(key);
      if (!map.containsKey(keyStr))
        map.put(keyStr, new ArrayList<String>());
      map.get(keyStr).add(str);
    }
    return new ArrayList<>(map.values());
  }

  // Encode and Decode Strings
  public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
      var encoded = new StringBuilder();
      for (var str : strs) {
        // store in string length + # + string;
        encoded.append(str.length()).append("#").append(str);
      }
      return encoded.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
      List<String> list = new ArrayList<>();
      int start = 0;
      while (start < s.length()) {
        int end = start;
        // place j before #
        while (s.charAt(end) != '#')
          end++;
        // get length
        int length = Integer.valueOf(s.substring(start, end));
        // use length to get the original string
        start = end + 1 + length;
        list.add(s.substring(end + 1, start));
      }
      return list;
    }
  }

  public int longestConsecutive(int[] nums) {
    int maxLen = 0;
    // 1. Create and load a hashset
    Set<Integer> set = new HashSet<>(); // [100,4,200,1,3,2]
    for (var num : nums) {
      set.add(num);
    }

    // 2. Count Sequences
    for (var num : nums) { // [100,4,200,1,3,2]
      int curLen = 0;
      // a. Identify if cur index is start by subtracting 1 from the current value
      if (!set.contains(num - 1)) {
        // a. increment cur index by 1 and check if it exists.
        while (set.contains(num)) {
          // b. if its exists then increment the result by 1.
          curLen++;
          num++;
          maxLen = Math.max(maxLen, curLen);
        }
      }
    }
    return maxLen;
  }

  public bool IsValidSudoku(char[][] board) {
        var row = new HashSet<char>[9];
        var col = new HashSet<char>[9];
        var box = new HashSet<char>[9];
        for(var i = 0; i < 9; i++ ){
            row[i] = new HashSet<char>();
            col[i] = new HashSet<char>();
            box[i] = new HashSet<char>();
        }
        for(var r = 0; r < 9; r++ ){
            for(var c = 0; c < 9; c++ ){
                var val = board[r][c];
                if (val == '.') continue;
                if (!row[r].Add(val)) return false;
                if (!col[c].Add(val)) return false;
                var b = (3 * (r/3)) + c/3;
                if (!box[b].Add(val)) return false;
            }            
        }
        return true;
    }

  // move into above
  // var rowBox=3*(i/3)+j/3;
  // var colBox = 3 * (i % 3) + j % 3;!subVlues.Add(board[rowBox][colBox])
  public bool IsValidSudoku2(char[][] board) {
        for(int i = 0; i < board.Length; i++){
            HashSet<int> rowValues = new HashSet<int>();
            HashSet<int> colValues = new HashSet<int>();
            HashSet<int> subVlues = new HashSet<int>();

            for(int j = 0; j < board.Length; j++){
                if(board[i][j] != '.' && !rowValues.Add(board[i][j])){
                    return false;
                }

                 if(board[j][i] != '.'  && !colValues.Add(board[j][i])){
                    return false;
                 }

                var rowBox = 3 * (i/3) + j/3;
                var colBox = 3 * (i%3) + j%3;

                if(board[rowBox][colBox] != '.' && !subVlues.Add(board[rowBox][colBox])){
                    return false;
                 }
            } 
        }  
        return true;
    }
    public int[] productExceptSelf(int[] nums) {
        
        int prefix = 1, suffix = 1;
        int[] res = new int[nums.length];

        for (var i = 0; i < nums.length; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }
        for (var i = nums.length - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
        }
        return res;
    }
}
