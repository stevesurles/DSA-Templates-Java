package eBinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class binarySearch {
  public int search(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    int m = r / 2;
    while (l <= r) {
      if (nums[m] == target)
        return m;
      if (nums[m] < target) {
        l = m + 1;
      } else {
        r = m - 1;
      }
      m = l + (r - l) / 2;
    }
    return -1;
  }

  public boolean searchMatrix(int[][] matrix, int target) {
    int rows = matrix.length, cols = matrix[0].length;
    int l = 0, r = (rows * cols) - 1;

    while (l <= r) {
      var pIdx = (int) (r + l) / 2;
      var pVal = matrix[(int) (pIdx / cols)][pIdx % cols];

      if (pVal == target)
        return true;

      if (pVal < target) {
        l = pIdx + 1;
      } else {
        r = pIdx - 1;
      }
    }

    return false;
  }

  public int findMin(int[] nums) {
    int l = 0, r = nums.length - 1;
    int result = nums[0];
    while (l <= r) {
      // once l is smaller than r, its sorted section,
      // we take the min and return the result
      if (nums[l] < nums[r]) {
        result = Math.min(result, nums[l]);
        break;
      }
      int m = (int) Math.floor((l + r) / 2);
      result = Math.min(result, nums[m]);

      if (nums[l] <= nums[m]) { // m is on the left, search to right of m
        l = m + 1;
      } else { // m is on the right, search to left of m
        r = m - 1;
      }
    }
    return result;
  }

  public int searchRotatedSortedArray(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    while (l <= r) {
      int m = (l + r) / 2;
      if (nums[m] == target) {
        return m;
      }
      // When dividing the roated array into two halves, one must be sorted.
      if (nums[l] <= nums[m]) {// l side is sorted
        if (nums[l] <= target && target <= nums[m]) {
          r = m - 1;
        } else {
          l = m + 1;
        }
      } else { // r side is sorted
        if (nums[m] <= target && target <= nums[r]) {
          l = m + 1;
        } else {
          r = m - 1;
        }
      }
    }
    return -1;
  }

  class TimeMap {

    HashMap<String, List<Pair<String, Integer>>> map;

    public TimeMap() {
      map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
      if (!map.containsKey(key))
        map.put(key, new ArrayList<>());
      map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
      if (!map.containsKey(key))
        return "";
      List<Pair<String, Integer>> list = map.get(key);
      return search(list, timestamp);
    }

    public String search(List<Pair<String, Integer>> list, int timestamp) {
      int start = 0;
      int end = list.size() - 1;
      while (start < end) {
        int mid = start + (end - start + 1) / 2;
        if (list.get(mid).getValue() <= timestamp)
          start = mid;
        else
          end = mid - 1;
      }
      return list.get(start).getValue() <= timestamp
          ? list.get(start).getKey()
          : "";
    }
  }
   
}
