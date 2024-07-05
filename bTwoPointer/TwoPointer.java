package bTwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointer {
  private boolean CONDITION = true;

  // Two pointers: one input, opposite ends
  public int fn(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    int ans = 0;

    while (left < right) {
      // do some logic here with left and right
      if (CONDITION) {
        left++;
      } else {
        right--;
      }
    }

    return ans;
  }

  // Two pointers: two inputs, exhaust both
  public int fn(int[] arr1, int[] arr2) {
    int i = 0, j = 0, ans = 0;

    while (i < arr1.length && j < arr2.length) {
      // do some logic here
      if (CONDITION) {
        i++;
      } else {
        j++;
      }
    }

    while (i < arr1.length) {
      // do logic
      i++;
    }

    while (j < arr2.length) {
      // do logic
      j++;
    }

    return ans;
  }

  public boolean isPalindrome(String s) {
    var alphaNumeric = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    int l = 0, r = alphaNumeric.length() - 1;
    while (l < r) {
      if (alphaNumeric.charAt(l) != alphaNumeric.charAt(r))
        return false;
      l++;
      r--;
    }
    return true;
  }

  public int[] twoSum(int[] numbers, int target) {
    int l = 0, r = numbers.length - 1;

    while (l < r) {
      int sum = numbers[l] + numbers[r];
      if (sum == target)
        return new int[] { l + 1, r + 1 };
      if (sum > target) {
        r--;
      } else {
        l++;
      }
    }

    return new int[2];
  }

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

  public int containerWithMostWater(int[] height) {
    int l = 0, r = height.length - 1;
    int maxArea = 0;
    while (l < r) {
      int minHeight = Math.min(height[l], height[r]);
      int width = r - l;
      int area = minHeight * width;
      maxArea = Math.max(maxArea, area);
      if (height[l] < height[r]) {
        l++;
      } else {
        r--;
      }
    }
    return maxArea;
  }
}
