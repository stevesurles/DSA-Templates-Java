
class Arrays {
  public static void main(String[] args) {
    // Your code here
  }

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
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  public TreeNode(int val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
}

class ListNode {
  int val;
  ListNode next;

  public ListNode() {
  };

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

}