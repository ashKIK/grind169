import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

  // https://leetcode.com/problems/insert-interval/

  // TC: O(N)
  // SC: O(N)
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> result = new ArrayList<>();
    int[] toAdd = newInterval;

    for (int[] interval : intervals) {
      // No overlap and toAdd appears before current interval, add toAdd to result
      if (toAdd[1] < interval[0]) {
        result.add(toAdd);
        // save the previous interval to toAdd for next loop use
        toAdd = interval;
      } else if (toAdd[0] > interval[1]) {
        // No overlap and toAdd appears after current interval, add current interval to result
        result.add(interval);
      } else {
        // Has overlap, update the toAdd to the merged interval
        toAdd = new int[]{
            Math.min(interval[0], toAdd[0]),
            Math.max(interval[1], toAdd[1])};
      }
    }
    result.add(toAdd);
    return result.toArray(new int[result.size()][]);
  }
}
