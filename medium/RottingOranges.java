public class RottingOranges {

  // https://leetcode.com/problems/rotting-oranges/description/

  // TC: O(4*M*N) ~ O(M*N)
  public int orangesRotting(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 2) {
          rotAdj(grid, i, j, 2);
        }
      }
    }

    int minutes = 2;
    for (int[] row : grid) {
      for (int cell : row) {
        if (cell == 1) {
          return -1;
        }
        minutes = Math.max(minutes, cell);
      }
    }
    return minutes - 2;
  }

  private void rotAdj(int[][] grid, int i, int j, int minutes) {
    if (i < 0 || i >= grid.length
        || j < 0 || j >= grid[0].length
        || grid[i][j] == 0
        || (grid[i][j] > 1 && grid[i][j] < minutes)) {
      return;
    }
    grid[i][j] = minutes;
    rotAdj(grid, i - 1, j, minutes + 1);
    rotAdj(grid, i + 1, j, minutes + 1);
    rotAdj(grid, i, j - 1, minutes + 1);
    rotAdj(grid, i, j + 1, minutes + 1);
  }
}
