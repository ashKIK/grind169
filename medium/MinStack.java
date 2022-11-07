import java.util.Stack;

public class MinStack {

  // https://leetcode.com/problems/min-stack/description/

  private final Stack<int[]> stack;

  public MinStack() {
    this.stack = new Stack<>();
  }

  public void push(int val) {
    if (stack.isEmpty()) {
      stack.push(new int[]{val, val});
    } else {
      int min = Math.min(val, stack.peek()[1]);
      stack.push(new int[]{val, min});
    }
  }

  public void pop() {
    stack.pop();
  }

  public int top() {
    return stack.peek()[0];
  }

  public int getMin() {
    return stack.peek()[1];
  }
}
