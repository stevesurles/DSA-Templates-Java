package zDSA;
import java.util.HashSet;

public class LengthOfLongestSubstring {
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
}
