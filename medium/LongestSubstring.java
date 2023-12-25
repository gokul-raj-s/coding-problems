import java.util.ArrayList;
import java.util.List;

public class LongestSubstring {

    /**
     * Given a string s, find the length of the longest substring without repeating characters.
     *
     * Example 1:
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     *
     * Example 2:
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     *
     * Example 3:
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     *
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */
    private static int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        int cnt = 1;
        int i = 0;
        int j = 1;
        List<Character> visited = new ArrayList<>();
        visited.add(s.charAt(i));

        while (j < s.length()) {
            if (visited.contains(s.charAt(j))) {
                if (visited.size() > cnt) {
                    cnt = visited.size();
                }
                i++;
                j = i + 1;
                visited.clear();
                visited.add(s.charAt(i));
            } else {
                visited.add(s.charAt(j));
                j++;
            }
        }
        return Math.max(visited.size(), cnt);
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
