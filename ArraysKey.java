
class Arrays {
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


  //two pointer exhaust both
  public int twoPointerExhaustBoth(int[] arr1, int[] arr2) {
    int i1 = 0, i2 = 0, res = 0;

    while (i1 < arr1.length && i2 < arr1.length) {
      //do logic with arr1 & arr2
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
}
