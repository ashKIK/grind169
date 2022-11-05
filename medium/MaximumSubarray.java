public class MaximumSubarray {

  // https://leetcode.com/problems/maximum-subarray/description/

  // TC: O(N)
  // SC: O(1)
  // Kadane
  public int maxSubArray(int[] nums) {
    int res = nums[0];
    int temp = nums[0];

    for (int i = 1; i < nums.length; i++) {
      temp = Math.max(nums[i], temp + nums[i]);
      res = Math.max(res, temp);
    }
    return res;
  }
}
