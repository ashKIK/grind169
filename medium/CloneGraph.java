import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

  // https://leetcode.com/problems/clone-graph/description/

  // Definition for a Node.
  class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }

  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    return cloneGraph(node, new HashMap<>());
  }

  private Node cloneGraph(Node node, Map<Integer, Node> nodeByVal) {
    if (nodeByVal.containsKey(node.val)) {
      return nodeByVal.get(node.val);
    }
    Node clone = nodeByVal.computeIfAbsent(node.val, k -> new Node(node.val));
    for (Node neighbor : node.neighbors) {
      clone.neighbors.add(cloneGraph(neighbor, nodeByVal));
    }
    return clone;
  }
}

