import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

  // https://leetcode.com/problems/combination-sum/description/

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    solve(0, candidates, new ArrayList<>(), result, target);
    return result;
  }

  private void solve(int index, int[] candidates, List<Integer> temp, List<List<Integer>> result, int target) {
    if (target < 0) {
      return;
    }
    if (target == 0) {
      result.add(new ArrayList<>(temp));
      return;
    }
    for (int i = index; i < candidates.length; i++) {
      temp.add(candidates[i]);
      solve(i, candidates, temp, result, target - candidates[i]);
      temp.remove(temp.size() - 1);
    }
  }
}
