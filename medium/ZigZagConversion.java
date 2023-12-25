import java.util.HashMap;

public class ZigZagConversion {

    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
     * (you may want to display this pattern in a fixed font for better legibility)
     * <p>
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     * Write the code that will take a string and make this conversion given a number of rows:
     * string convert(string s, int numRows);
     * <p>
     * Example 1:
     * Input: s = "PAYPALISHIRING", numRows = 3
     * Output: "PAHNAPLSIIGYIR"
     * <p>
     * Example 2:
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * <p>
     * Example 3:
     * Input: s = "A", numRows = 1
     * Output: "A"
     */
    private static String convert(String s, int numRows) {
        if (s.length() < 3 || numRows == 1) {
            return s;
        }
        StringBuilder output = new StringBuilder();
        HashMap<Integer, String> matrix = new HashMap<>();
        int pos = 0;
        int rowCnt = 0;

        while (pos < s.length()) {
            while (pos < s.length() && rowCnt < numRows) {
                if (matrix.containsKey(rowCnt)) {
                    matrix.put(rowCnt, matrix.get(rowCnt) + s.charAt(pos));
                } else {
                    matrix.put(rowCnt, s.substring(pos, pos + 1));
                }
                rowCnt++;
                pos++;
            }
            rowCnt -= 2;
            while (pos < s.length() && rowCnt > -1) {
                if (matrix.containsKey(rowCnt)) {
                    matrix.put(rowCnt, matrix.get(rowCnt) + s.charAt(pos));
                } else {
                    matrix.put(rowCnt, s.substring(pos, pos + 1));
                }
                rowCnt--;
                pos++;
            }
            rowCnt += 2;
        }

        for (int i = 0; i < numRows; i++) {
            if (matrix.get(i) != null) {
                output.append(matrix.get(i));
            }
        }
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
