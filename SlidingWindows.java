import java.util.Arrays;

public class SlidingWindows {
  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length())
      return false;
    // Create two int arrays
    var s1Count = new int[26];
    var s2Count = new int[26];
    var s1Len = s1.length();
    var s2Len = s2.length();

    // count first s1.count chars
    for (var i = 0; i < s1Len; i++) {
      s1Count[s1.charAt(i) - 'a']++;
      s2Count[s2.charAt(i) - 'a']++;
    }

    // compare first s1.length chars
    if (Arrays.compare(s1Count, s2Count) == 0)
      return true;

    // Sliding window to compare the remaining
    for (var i = s1Len; i < s2Len; i++) {
      // Add char on right
      s2Count[s2.charAt(i) - 'a']++;
      // Decrement char on left
      s2Count[s2.charAt(i - s1Len) - 'a']--;
      if (Arrays.compare(s1Count, s2Count) == 0)
        return true;
    }

    return false;

  }
}
