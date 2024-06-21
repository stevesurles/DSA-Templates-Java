package DSA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
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
}
