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

  class DFSGraph {
    Set<Integer> seen = new HashSet<>();
    
    private int fn(int[][] graph) {
      int START_NODE = 0;
      seen.add(START_NODE);
      return dfsGraph(START_NODE, graph);
    }
    
    private int dfsGraph(int node, int[][] graph) {
      int ans = 0;
      for (int neighbor : graph[node]) {
        if (!seen.contains(neighbor)) {
          seen.add(neighbor);
          ans += neighbor;
          dfsGraph(neighbor, graph);
        }
      }
      return ans;
    }
  }

}
