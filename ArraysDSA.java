import java.util.HashMap;
import java.util.HashSet;

public class ArraysDSA {
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
      count.put(c, count.getOrDefault(c,0) + 1);
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

}
