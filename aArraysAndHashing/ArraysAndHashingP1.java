package aArraysAndHashing;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ArraysAndHashingP1 {

  // https://leetcode.com/problems/valid-anagram/
  public void fn(String s) {
    // Array with size
    int[] arr = new int[s.length()];

    // Create and initialize an array with values
    int[] nums = new int[] { 1, 2, 3, 4 };

    // Declare hashset and check if value exists
    HashSet<Integer> set = new HashSet<>(s.length());
    set.contains('a');

    // HashMap contains
    Map<Character, Integer> map = new HashMap<>();
    map.containsKey('a');

    // HashMap counter with char array
    for (Character c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    // HashMap get
    map.get('a');

    // Loop through HashMap entries checking value for each key
    for (var entrySet : map.entrySet()) {
      if (entrySet.getValue() == 1)
        System.out.println(1);
    }

    // Counter occurances of characters with array
    for (Character c : s.toCharArray()) {
      arr[c - 'a']++;
    }

  }
}
