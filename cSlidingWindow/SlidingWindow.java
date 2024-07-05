package cSlidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SlidingWindow {
  boolean WINDOW_CONDITION_BROKEN = true;
  public int fn(int[] arr) {
    int left = 0, ans = 0, curr = 0;
    for (int right = 0; right < arr.length; right++) {
      // do logic here to add arr[right] to curr
      while (WINDOW_CONDITION_BROKEN) {
        // remove arr[left] from curr
        left++;
      }
      // update ans
    }
    return ans;
  }  
  public int maxProfit(int[] prices) {
    int maxProfit = 0, l = 0;

    for (var r = 1; r < prices.length; r++) {
      var newProfit = prices[r] - prices[l];
      maxProfit = Math.max(newProfit, maxProfit);

      if (newProfit < 0) {
        l = r;
      }
    }
    return maxProfit;
  }
  // 3. Longest Substring Without Repeating Characters
  public int lengthOfLongestSubstring(String s) {
    var set = new HashSet<Character>();
    int longestSubstr = 0, l = 0;
    for (var r = 0; r < s.length(); r++) {
      while (set.contains(s.charAt(r))) {
        set.remove(s.charAt(l));
        l++;
      }
      longestSubstr = Math.max(longestSubstr, r - l + 1);
      set.add(s.charAt(r));
    }
    return longestSubstr;
  }

  // 424. Longest Repeating Character Replacement
  public int characterReplacement(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int left = 0, maxChar = 0, maxWindow = 0;

    for (int right = 0; right < s.length(); right++) {
      char ch = s.charAt(right);

      map.put(ch, map.getOrDefault(ch, 0) + 1);
      maxChar = Math.max(maxChar, map.get(ch));

      if (right - left + 1 - maxChar > k) {
        char remove = s.charAt(left);
        map.put(remove, map.get(remove) - 1);
        left++;
      }

      maxWindow = Math.max(maxWindow, right - left + 1);
    }
    return maxWindow;
  }
  
  // 567. Permutation in String
  public boolean checkInclusion(String s1, String s2) {
      if (s1.length() > s2.length()) return false;
      //Create two int arrays
      var s1Count = new int[26];
      var s2Count = new int[26];
      var s1Len = s1.length();
      var s2Len = s2.length();

      //count first s1.count chars
      for (var i = 0; i < s1Len; i++){
          s1Count[s1.charAt(i) - 'a']++;
          s2Count[s2.charAt(i) - 'a']++; 
      }

      //compare first s1.length chars
      if (Arrays.compare(s1Count, s2Count) == 0) return true;

      //Sliding window to compare the remaining
      for (var i = s1Len; i < s2Len; i++){
          //Add char on right
          s2Count[s2.charAt(i) - 'a']++;
          //Decrement char on left
          s2Count[s2.charAt(i - s1Len) - 'a']--; 
          if (Arrays.compare(s1Count, s2Count) == 0) return true;
      }

      return false;
  }  
}
