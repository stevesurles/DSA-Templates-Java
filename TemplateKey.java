import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

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
        arr[i] = stack.pop();
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
}
