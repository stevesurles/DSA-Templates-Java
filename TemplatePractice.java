import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Arrays;

public class TemplatePractice {
  private boolean CONDITION = true;
  private boolean WINDOW_CONDITION_BROKEN = true;

  
  public int fn(int[][] graph) {
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> seen = new HashSet<>();
    int ans = 0;
    queue.add(graph[0][0]);
    seen.add(graph[0][0]);
    while (!queue.isEmpty()) {
      var node = queue.remove();
      //do logic
      ans += node;
      for (var neighbor : graph[node]) {
        if (!seen.contains(neighbor)) {

          seen.add(neighbor);
          queue.add(neighbor);  
        }
      }
    }

    
  }
  

}
