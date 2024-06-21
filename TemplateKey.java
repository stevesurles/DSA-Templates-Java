import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

//Reference: https://leetcode.com/explore/interview/card/cheatsheets/720/resources/4723/
class TemplateKey {
  private boolean CONDITION = true;
  private boolean WINDOW_CONDITION_BROKEN = true;

  public static void main(String[] args) {
    // Your code here
  }

  // two pointer processing
  public int twoPointer(int[] arr) {
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
  public int twoPointerExhaustBoth(int[] arr1, int[] arr2) {
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
    for (var i = 1; i < arr.length; i++) {
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
  // https://leetcode.com/discuss/study-guide/2347639/A-comprehensive-guide-and-template-for-monotonic-stack-based-problems
  public int[] monotonicIncreasingStack1(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    int[] nextGreater = new int[arr.length];
    int i = 0;
    for (int num : arr) {
      // for monotonic decreasing, flip the > to <
      while (!stack.empty() && stack.peek() > num) {
        // do logic
        nextGreater[i++] = stack.pop(); // TODO verify this

      }

      stack.push(num);
    }
    return nextGreater;
  }

  // check if this works
  public int[] monotonicIncreasingStack2(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    int i = 0;

    for (int num : arr) {
      while (!stack.empty() && stack.peek() > num) {
        arr[i++] = stack.pop();
      }
      stack.push(num);
    }

    return arr;

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

  // Why is dfs iterative with a stack and bfs with a queue?
  // DFS is iterative with a stack because we need to keep track of the nodes that
  // we have visited but have not yet explored. We use a stack to do this because
  // it follows the LIFO principle. This means that the last node that we visited
  // will be the first node that we explore.
  // BFS is iterative with a queue because we need to keep track of the nodes that
  // we have visited but have not yet explored. We use a queue to do this because
  // it follows the FIFO principle. This means that the first node that we visited
  // will be the first node that we explore.
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
      int levelSize = queue.size();
      // do logic for current level
      while (levelSize-- > 0) {
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

  // Graph DFS (recursive)
  class DFSGraphRecursive {
    Set<Integer> seen = new HashSet<>();

    public int graphDFS(int[][] graph) {
      int startNode = graph[0][0];
      seen.add(startNode);
      return dfsGraph(startNode, graph);
    }

    public int dfsGraph(int node, int[][] graph) {
      int ans = 0;
      // do logic
      for (int neighbor : graph[node]) {
        if (!seen.contains(neighbor)) {
          seen.add(neighbor);
          ans += dfsGraph(neighbor, graph);
        }
      }
      return ans;
    }
  }
  //graph iterative
  private int DFSGraphIterative(int[][] graph) {
    Stack<Integer> stack = new Stack<>();
    Set<Integer> seen = new HashSet<>();
    int ans = 0;
    int startNode = graph[0][0];
    stack.push(startNode);
    seen.add(startNode);

    while (!stack.empty()) {
      int node = stack.pop();
      //do logic
      for (int neighbor : graph[node]) {
        if (!seen.contains(neighbor)) {
          seen.add(neighbor);
          stack.push(neighbor);
        }
      }
    }

    return ans;
  }

  //graph BFS
  private int graphBFS(int[][] graph) {
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> seen = new HashSet<>();
    int startNode = graph[0][0];
    queue.add(startNode);
    seen.add(startNode);

    while (!queue.isEmpty()) {
      int node = queue.remove();
      for (int neighbor : graph[node]) {
        if (!seen.contains(neighbor)) {
          seen.add(neighbor);
          queue.add(neighbor);
        }
      }
    }
    
    return ans;
    
  }

  //find top k elements with a priority queue
  public int[] topKElements(int[] arr, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    for (int num : arr) {
      heap.add(num);
      while (heap.size() > k) {
        heap.remove();
      }
    }

    int[] ans = new int[k];
    for (int i = 0; i < ans.length; i++) {
      ans[i] = heap.remove();
    }

    return ans;

  }


  // binary search

  public int binarySearch(int[] arr, int target) {
    int l = 0, r = arr.length - 1;
    while (l < r) {
      var m = l + (r - l) / 2;
      if (arr[m] == target) {
        return m;
      }
      if (arr[m] > target) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    }
    return l;
  }
  // TODO: find examples
  // binary search: duplicate elements, left-most insertion point
  public int binarySearchDupsL(int[] arr, int target) {
    int l = 0;
    int r = arr.length;
    while (l < r) {
      int m = l + (r - l) / 2;
      if (arr[m] >= target) {
        r = m;
      } else {
        l = m + 1;
      }
    }
    return l;
  }

  // binary search: duplicate elements, right-most insertion point
  public int binarySearchDupsR(int[] arr, int target) {
    int l = 0;
    int r = arr.length;
    while (l < r) {
      int m = l + (r - l) / 2;
      if (arr[m] > target) {
        r = m;
      } else {
        l = m + 1;
      }
    }
    return l;
  }

  // binary search: Gready
  final int MINIMUM_POSSIBLE_ANSWER = 0;
  final int MAXIMUM_POSSIBLE_ANSWER = 100;
  public int binarySeachGreedy(int[] arr) {
    int l = MINIMUM_POSSIBLE_ANSWER;
    int r = MAXIMUM_POSSIBLE_ANSWER;
    while (l <= r) {
      var m = l + (r - l) / 2;
      if (check(m)) {
        r = m - 1;
      } else {
        l = m + 1;
      }

    }

    return l;
  }

  public boolean check(int x) {
    boolean res = false;
    //do logic
    return res;
  }

  //backtracking template
  /*
   * public int backtrack(STATE curr, OTHER_ARGUMENTS...) {
   * if (BASE_CASE) {
   * // modify the answer
   * return 0;
   * }
   * 
   * int ans = 0;
   * for (ITERATE_OVER_INPUT) {
   * // modify the current state
   * ans += backtrack(curr, OTHER_ARGUMENTS...)
   * // undo the modification of the current state
   * }
   * }
   */

  //backtracking subsets
  class Subsets {
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
      List<Integer> subset = new ArrayList<Integer>();
      res = new ArrayList<>();
      int i = 0;
      backtracking(nums, subset, i);
      return res;
    }

    private void backtracking(int[] nums, List<Integer> subset, int i) {
      if (i >= nums.length) {
        res.add(new ArrayList<>(subset));
        return;
      }

      subset.add(nums[i]);
      backtracking(nums, subset, i + 1);
      subset.remove(subset.size() - 1);
      backtracking(nums, subset, i + 1);
    }
  }

  //backtracking permutations
  class Permutations {
    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> ans = new ArrayList<>();
      backtrack(new ArrayList<>(), ans, nums);
      return ans;
    }

    public void backtrack(
        List<Integer> curr,
        List<List<Integer>> ans,
        int[] nums) {
      if (curr.size() == nums.length) {
        ans.add(new ArrayList<>(curr));
        return;
      }

      for (int num : nums) {
        if (!curr.contains(num)) {
          curr.add(num);
          backtrack(curr, ans, nums);
          curr.remove(curr.size() - 1);
        }
      }
    }
  }

  //dp template
  /*
   * Map<STATE, Integer> memo = new HashMap<>();
   * 
   * public int fn(int[] arr) {
   * return dp(STATE_FOR_WHOLE_INPUT, arr);
   * }
   * 
   * public int dp(STATE, int[] arr) {
   * if (BASE_CASE) {
   * return 0;
   * }
   * 
   * if (memo.contains(STATE)) {
   * return memo.get(STATE);
   * }
   * 
   * int ans = RECURRENCE_RELATION(STATE);
   * memo.put(STATE, ans);
   * return ans;
   * }
   */
  //Dynamic programming: top-down memoization
  public class dpRecussion {
    public int climbStairs(int n) {
      int memo[] = new int[n + 1];
      return climb_Stairs(0, n, memo);
    }

    public int climb_Stairs(int i, int n, int memo[]) {
      if (i > n) {
        return 0;
      }
      if (i == n) {
        return 1;
      }
      if (memo[i] > 0) {
        return memo[i];
      }
      memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
      return memo[i];
    }
  }

  public class dpIterative {
    public int climbStairs(int n) {
      if (n == 1) {
        return 1;
      }
      int[] dp = new int[n + 1];
      dp[1] = 1;
      dp[2] = 2;
      for (int i = 3; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
      }
      return dp[n];
    }
  }

  //last 2 templates:
  //trie

  // dijkstra's algo

}
