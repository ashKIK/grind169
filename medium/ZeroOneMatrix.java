import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

  // https://leetcode.com/problems/01-matrix/

  public int[][] updateMatrix(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    int[] dir = new int[]{0, 1, 0, -1, 0};
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (mat[i][j] == 0) {
          queue.offer(new int[]{i, j});
        } else {
          mat[i][j] = -1;
        }
      }
    }
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int r = cur[0];
      int c = cur[1];
      for (int i = 0; i < 4; i++) {
        int nr = r + dir[i];
        int nc = c + dir[i + 1];
        if ((nr >= 0 && nr < m) && (nc >= 0 && nc < n) && mat[nr][nc] == -1) {
          mat[nr][nc] = mat[r][c] + 1;
          queue.offer(new int[]{nr, nc});
        }
      }
    }
    return mat;
  }
}
