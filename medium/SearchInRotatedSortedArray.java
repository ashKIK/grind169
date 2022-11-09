public class SearchInRotatedSortedArray {

  // https://leetcode.com/problems/search-in-rotated-sorted-array/description/

  // TC: O(logN)
  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      // right half of the array is sorted
      if (nums[mid] <= nums[high]) {
        if (target > nums[mid] && target <= nums[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      } else {
        // left half of the array is sorted
        if (target >= nums[low] && target < nums[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
    }
    return -1;
  }
}
