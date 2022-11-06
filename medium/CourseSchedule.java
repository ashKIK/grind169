import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {

  // https://leetcode.com/problems/course-schedule/description/

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (prerequisites == null || prerequisites.length == 0) {
      return true;
    }

    int[] inDegree = new int[numCourses];
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    for (int[] prerequisite : prerequisites) {
      adjList.computeIfAbsent(prerequisite[1], k -> new ArrayList<>()).add(prerequisite[0]);
      inDegree[prerequisite[0]]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0) {
        queue.offer(i);
      }
    }
    int count = 0;
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      count++;
      for (Integer child : adjList.getOrDefault(cur, List.of())) {
        if (--inDegree[child] == 0) {
          queue.offer(child);
        }
      }
    }
    return count == numCourses;
  }
}
