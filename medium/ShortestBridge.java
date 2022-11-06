import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

  // https://leetcode.com/problems/shortest-bridge/description/

  private final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public int shortestBridge(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] vis = new boolean[m][n];
    boolean found = false;
    Queue<int[]> q = new LinkedList<>();
    // dfs to find an island
    for (int i = 0; i < m; i++) {
      if (found) {
        break;
      }
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          dfs(grid, i, j, q, vis);
          found = true;
          break;
        }
      }
    }
    // bfs to expand and meet the other island
    int step = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      while (size-- > 0) {
        int[] cur = q.poll();
        for (int[] dir : dirs) {
          int x = cur[0] + dir[0];
          int y = cur[1] + dir[1];
          if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y]) {
            if (grid[x][y] == 1) {
              return step;
            }
            q.offer(new int[]{x, y});
            vis[x][y] = true;
          }
        }
      }
      step++;
    }
    return -1;
  }

  private void dfs(int[][] grid, int i, int j, Queue<int[]> q, boolean[][] vis) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || vis[i][j] || grid[i][j] == 0) {
      return;
    }
    vis[i][j] = true;
    q.offer(new int[]{i, j});
    for (int[] dir : dirs) {
      dfs(grid, i + dir[0], j + dir[1], q, vis);
    }
  }
}
