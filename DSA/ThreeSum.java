package DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    // 1. sort nums O(n log n)
    Arrays.sort(nums);
    // 2. Create outer for loop i (left)
    for (int i = 0; i < nums.length; i++) {
      // skip if i - 1 exists and equals i;
      if (i > 0 && nums[i - 1] == nums[i])
        continue;
      // 2. create left and right pointers j (mid) & k (right)
      int j = i + 1, k = nums.length - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum < 0) {
          j++;
        } else if (sum > 0) {
          k--;
        } else {
          res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k])));
          j++;
          while (j < k && nums[j - 1] == nums[j])
            j++;
        }
      }
    }
    return res;
  }
}
