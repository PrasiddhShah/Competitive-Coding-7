// Time Complexity : O(nlog(max-min))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
 * Approach
 * we are using binary search to find the element, idea here is to check how many numbers are
 * smaller then the mid, if it will smaller then k move low to mid +1 else high, eventually when
 * low < high will become false ans will be at low
 * 
 * to check how many numbers are smaller then mid we use  seprate function
 * we rely of the 2 unique property of the matrix that row are also sorted and columns are sorted
 * 
 * we start from max row and 0 col and start checking if the value is smaller the mid 
 * we increase the count by i+1 and increase j
 * else recrease i
 * in the end return count
 * 
 */

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessOrEqual(matrix, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;

    }

    private int countLessOrEqual(int[][] matrix, int value) {
        int n = matrix.length;
        int count = 0;
        int i = n - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= value) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }
}