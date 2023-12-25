public class LongestPalindromicSubstring {

    /**
     * Given a string s, return the longest palindromic substring in s.
     *
     * Example 1:
     * Input: s = "babad"
     * Output: "bab"
     * Explanation: "aba" is also a valid answer.
     *
     * Example 2:
     * Input: s = "cbbd"
     * Output: "bb"
     */
    private static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        int i = 0;
        String longestPalindrome = "";

        while (i < s.length() - 1) {
            int j = s.length();
            while (j > i) {
                if (s.charAt(i) == s.charAt(j - 1)) {
                    if (isPalindrome(s.substring(i, j)) && s.substring(i, j).length() > longestPalindrome.length()) {
                        longestPalindrome = s.substring(i, j);
                        break;
                    }
                }
                j--;
            }
            i++;
            if (longestPalindrome.length() > s.length() + i) {
                break;
            }
        }
        return longestPalindrome;
    }

    private static boolean isPalindrome(String input) {
        int start = 0;
        int end = input.length() - 1;

        while (start < end && input.charAt(start) == input.charAt(end)) {
            start++;
            end--;
        }

        return start >= end;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
