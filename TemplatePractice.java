import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class TemplatePractice {
  private boolean CONDITION = true;
  private boolean CONDITION_BROKEN = true;

  // two pointer processing
  public int fn(int[] arr) {
    int l = 0, r = arr.length - 1;
    int res = 0;
    while (l < r) {
      // Do logic here with left and right;
      if (CONDITION) {
        l++;
      } else {
        r--;
      }
    }
    return res;
  }

  // two pointer exhaust both
  public int fn2(int[] arr1, int[] arr2) {
    int i1 = 0, i2 = 0, res = 0;

    while (i1 < arr1.length && i2 < arr1.length) {
      // do logic with arr1 & arr2
      if (CONDITION) {
        i1++;
      } else {
        i2++;
      }

    }

    while (i1 < arr1.length) {
      // do logic
      i1++;
    }
    while (i2 < arr2.length) {
      // do logic
      i2++;
    }
    return res;
  }

  public int slidingWindow2(int[] arr) {
    int l = 0;

    for (var r = 0; r < arr.length; r++) {

      if (CONDITION_BROKEN) {
        // remove arr[i] from cur
        l++;
      }
    }
    return 0;
  }

  // build a prefix sum
  // everytime we create a prefix, maintain a count of it necause we may use it
  // multiple times.
  // after
  // check if hashmap should be added to this
  // https://www.youtube.com/watch?v=fFVZt-6sgyo
  public int[] buildPrefixSum(int[] arr) {
    int[] prefix = new int[arr.length];
    prefix[0] = arr[0];
    for (var i = 0; i < arr.length; i++) {
      prefix[i] = prefix[i - 1] + arr[i];
    }
    return prefix;
  }

  // Find number of subarrays that fit an exact criteria
  public int nbrOfSubArraysWExactCriteria(int[] arr, int k) {
    Map<Integer, Integer> counts = new HashMap<>();
    counts.put(0, 1);
    int ans = 0, cur = 0;

    for (int num : arr) {
      // do logic to change cur

      ans += counts.getOrDefault(cur - k, 0);
      counts.put(cur, counts.getOrDefault(cur, 0) + 1);
    }

    return ans;
  }

  // effecient string building
  public String stringBuilder(char[] arr) {
    StringBuilder sb = new StringBuilder();
    for (char c : arr) {
      sb.append(c);
    }

    return sb.toString();
  }

  // Link List: Fast and slow Pointer
  public int fastAndSlow(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    int ans = 0;
    while (fast != null && slow != null) {
      // do logic
      slow = slow.next;
      fast = fast.next.next;
    }
    return ans;
  }

  // Reverse Linked List
  public ListNode reverseLinkedList(ListNode head) {
    ListNode cur = head;
    ListNode prev = null;
    while (cur != null) {
      var next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }

  public int monotonicIncreasingStack1(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    int ans = 0;
    for (int num : arr) {
      while (!stack.empty() && stack.peek() > num) {
        ans += stack.pop();
      }
      stack.push(num);
    }
    return ans;
  }

  public int monotonicIncreasingStack2(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    for (var num : arr) {
      // do logic
      while (!stack.empty() && stack.peek() > num) {
        stack.pop();
      }
      stack.push(num);
    }
    return 0;
  }

  public int[] monotonicIncreasingStack3(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    List<Integer> list = new ArrayList<Integer>();
    for (var num : nums) {
      while (!stack.empty() && stack.peek() > num) {
        list.add(stack.pop());
      }
      stack.push(num);
    }

    // return list.toArray(new Integer[0]);
    return list.stream().mapToInt(i -> i).toArray();
  }

  public int bfs(TreeNode root) {
    int ans = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int levelCount = queue.size();
      for (int i = 0; i < levelCount; i++) {
        TreeNode node = queue.poll();
        //do logic
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
    }

    return ans;
  }
}
