package dStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Stack {
  public boolean isValid(String s) {
    HashMap<Character, Character> openToClose = new HashMap<Character, Character>() {
      {
        put('(', ')');
        put('[', ']');
        put('{', '}');
      }
    };
    var openStack = new Stack<Character>();
    for (var c : s.toCharArray()) {
      if (openToClose.containsKey(c)) {
        openStack.push(c);
      } else {
        if (openStack.size() == 0)
          return false;
        Character matchingOpen = openStack.pop();
        if (openToClose.get(matchingOpen) != c)
          return false;
      }
    }
    if (openStack.size() == 0) {
      return true;
    } else {
      return false;
    }
  }

  class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
      this.stack = new Stack<Integer>();
      this.minStack = new Stack<Integer>();
    }

    public void push(int val) {
      this.stack.push(val);
      // The min stack may be empty, so we need to check it
      val = Math.min(val, minStack.isEmpty() ? val : minStack.peek());
      minStack.push(val);
    }

    public void pop() {
      this.stack.pop();
      this.minStack.pop();
    }

    public int top() {
      return this.stack.peek();
    }

    public int getMin() {
      return this.minStack.peek();
    }
  }

  public int evalRPN(String[] tokens) {
    var stack = new Stack<Integer>();
    var i = 0;
    while (i < tokens.length) {
      switch (tokens[i]) {
        case "+": {
          stack.push(stack.pop() + stack.pop());
          break;
        }
        case "*": {
          stack.push(stack.pop() * stack.pop());
          break;
        }
        case "-": {
          var first = stack.pop();
          var second = stack.pop();
          stack.push(second - first);
          break;
        }
        case "/": {
          var first = stack.pop();
          var second = stack.pop();
          stack.push(second / first);
          break;
        }
        default: {
          stack.push(Integer.parseInt(tokens[i]));
        }
      }
      i++;
    }
    return stack.pop();
  }

  class Solution {
    private int n;
    private List<String> res = new ArrayList<>();
    Stack<Character> stack = new Stack<>();

    public List<String> generateParenthesis(int n) {
      this.n = n;
      this.backTrack(0, 0);
      return this.res;
    }

    private void backTrack(int open, int closed) {
      if (open == this.n && closed == this.n) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : stack.toArray()) {
          sb.append(obj);
        }
        res.add(sb.toString());
      }

      if (open < this.n) {
        stack.push('(');
        this.backTrack(open + 1, closed);
        stack.pop();
      }

      if (closed < open) {
        stack.push(')');
        this.backTrack(open, closed + 1);
        stack.pop();
      }
    }
  }

  public int[] dailyTemperatures(int[] temperatures) {
    int[] result = new int[temperatures.length];
    Stack<Integer> stack = new Stack<>();

    for (var curDay = 0; curDay < temperatures.length; curDay++) {
      while (stack.size() > 0 && temperatures[curDay] > temperatures[stack.peek()]) {
        int prevDay = stack.pop();
        result[prevDay] = curDay - prevDay;
      }
      stack.push(curDay);
    }
    return result;
  }
  
  public int carFleet(int target, int[] position, int[] speed) {
      if (position.length == 1) return 1;
      Stack<Double> stack = new Stack<>();
      int[][] combine = new int[position.length][2];
      for (int i = 0; i < position.length; i++) {
          combine[i][0] = position[i];
          combine[i][1] = speed[i];
      }

      Arrays.sort(combine, java.util.Comparator.comparingInt(o -> o[0]));
      for (int i = combine.length - 1; i >= 0; i--) {
          double currentTime = (double) (target - combine[i][0]) /
          combine[i][1];
          if (!stack.isEmpty() && currentTime <= stack.peek()) {
              continue;
          } else {
              stack.push(currentTime);
          }
      }
      return stack.size();
  }  
}
