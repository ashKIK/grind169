import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

  // https://leetcode.com/problems/longest-substring-without-repeating-characters/

  // TC: O(N)
  // SC: O(N)
  public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int l = 0;
    int res = 0;
    for (int r = 0; r < s.length(); r++) {
      while (set.contains(s.charAt(r))) {
        set.remove(s.charAt(l));
        l++;
      }
      set.add(s.charAt(r));
      res = Math.max(res, r - l + 1);
    }
    return res;
  }
}
