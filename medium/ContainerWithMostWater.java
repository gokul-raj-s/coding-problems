public class ContainerWithMostWater {

    /**
     * You are given an integer array height of length n.
     * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
     * Find two lines that together with the x-axis form a container, such that the container contains the most water.
     * Return the maximum amount of water a container can store.
     * <p>
     * Example 1:
     * Input: height = [1,8,6,2,5,4,8,3,7]
     * Output: 49
     * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
     * In this case, the max area of water (blue section) the container can contain is 49.
     * <p>
     * Example 2:
     * Input: height = [1,1]
     * Output: 1
     */
    private static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;

        int maxArea = 0;

        while (i < j) {
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j-i));
            if (height[i] < height[j]) {
                i++;
            } else if (height[j] < height[i]) {
                j--;
            } else {
                i++;
                j--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
