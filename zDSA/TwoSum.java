package zDSA;

import java.util.HashMap;

public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    var nbrIdxMap = new HashMap<Integer, Integer>();
    for (var i = 0; i < nums.length; i++) {
      var complement = target - nums[i];
      if (nbrIdxMap.containsKey(complement)) {
        return new int[] { nbrIdxMap.get(complement), i };
      } else {
        nbrIdxMap.put(nums[i], i);
      }
    }
    return new int[] {};    
  }

}
