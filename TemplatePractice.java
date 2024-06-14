import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.Arrays;

public class TemplatePractice {
  private boolean CONDITION = true;
  private boolean WINDOW_CONDITION_BROKEN = true;

  public int bfs(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int levelCount = queue.size();
      while (levelCount-- > 0) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }        
      }
    }
  }

}
