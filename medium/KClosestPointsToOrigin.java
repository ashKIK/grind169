import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

  // https://leetcode.com/problems/k-closest-points-to-origin/description/

  // sort all the points by their distance to the origin and get top K closest
  // TC: O(NlogN)
  // offline solution
  public int[][] kClosestSort(int[][] points, int K) {
    Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
    return Arrays.copyOfRange(points, 0, K);
  }

  // max-heap
  // TC: O(NlogK)
  // offline and online
  public int[][] kClosestMaxHeap(int[][] points, int K) {
    PriorityQueue<int[]> pq = new PriorityQueue<>(K,
        (p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]
    );
    for (int[] point : points) {
      pq.offer(point);
      if (pq.size() > K) {
        pq.poll();
      }
    }
    int[][] kClosest = new int[K][2];
    int i = 0;
    while (!pq.isEmpty()) {
      kClosest[i++] = pq.poll();
    }
    return kClosest;
  }

  // quick-select
  // TC: O(N), WC: O(N^2)
  // offline and not stable (K elements closest are not sorted in ascending order)
  public int[][] kClosest(int[][] points, int k) {
    int l = 0;
    int r = points.length - 1;
    while (l <= r) {
      int mid = helper(points, l, r);
      if (mid == k) {
        break;
      }
      if (mid < k) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return Arrays.copyOfRange(points, 0, k);
  }

  private int helper(int[][] A, int l, int r) {
    int[] pivot = A[l];
    while (l < r) {
      while (l < r && compare(A[r], pivot) >= 0) {
        r--;
      }
      A[l] = A[r];
      while (l < r && compare(A[l], pivot) <= 0) {
        l++;
      }
      A[r] = A[l];
    }
    A[l] = pivot;
    return l;
  }

  private int compare(int[] p1, int[] p2) {
    return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
  }
}
