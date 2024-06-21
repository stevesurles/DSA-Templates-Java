package DSA;

public class ContainerWithMostWater {
  public int maxArea(int[] height) {
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
