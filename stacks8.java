import java.util.*;

public class Solution {

    public static int maximalRectangle(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            // Build the histogram for this row
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1)
                    heights[j] += 1;
                else
                    heights[j] = 0;
            }
            // Calculate max area for this histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        int[] extendedHeights = Arrays.copyOf(heights, n + 1); // append 0 as sentinel

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && extendedHeights[i] < extendedHeights[stack.peek()]) {
                int height = extendedHeights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }

    // Driver code to read input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(maximalRectangle(matrix));
        sc.close();
    }
}
