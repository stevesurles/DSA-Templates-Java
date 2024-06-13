import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class TemplateKey {
  private boolean CONDITION = true;
  private boolean WINDOW_CONDITION_BROKEN = true;

  public static void main(String[] args) {
    // Your code here
  }

  // two pointer processing
  public int twoPointer(int[] arr) {
    int l = 0, r = arr.length() - 1;
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
  public int twoPointerExhaustBoth(int[] arr1, int[] arr2) {
    int i1 = 0, i2 = 0, res = 0;

    while (i1 < arr1.length() && i2 < arr1.length()) {
      // do logic with arr1 & arr2
      if (CONDITION) {
        i1++;
      } else {
        i2++;
      }

    }

    while (i1 < arr1.length()) {
      // do logic
      i1++;
    }
    while (i2 < arr2.length()) {
      // do logic
      i2++;
    }
    return res;
  }

  // sliding window
  public int slidingWindow(int[] arr) {
    int l = 0, ans = 0, curr = 0;

    for (int r = 0; r < arr.length; r++) {
      // do logic here to add arr[r] to curr

      while (WINDOW_CONDITION_BROKEN) {
        // remove arr[l] from curr
        l++;
      }

      // update ans
    }

    return ans;
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

  // Monotonic increasing stack
  public int monotonicIncreasingStack(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    int ans = 0;

    for (int num : arr) {
      // for monotonic decreasing, flip the > to <
      while (!stack.empty() && stack.peek() > num) {
        // do logic
        stack.pop();
      }

      stack.push(num);
    }
    return ans;
  }

  // Binary tree: DFS (recursive)
  public int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int ans = 0;
    dfs(root.left);
    dfs(root.right);
    return ans;
  }

  // Binary tree: DFS (iterative)
  public int dfsIterative(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    int ans = 0;
    while (!stack.empty()) {
      TreeNode node = stack.pop();
      // Do Logic
      if (node.left != null) {
        stack.push(node.left);
      }
      if (node.right != null) {
        stack.push(node.right);
      }
    }
    return ans;
  }

  // Binary Tree BFS
  public int bfs(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int ans = 0;

    while (!queue.isEmpty()) {
      int len = queue.size();
      // do logic for current level
      for (int i = 0; i < len; i++) {
        TreeNode node = queue.poll();
        // do logic
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
