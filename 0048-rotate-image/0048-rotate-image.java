class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i<n-1; i++) {
            for(int j = i+1; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int row = 0; row < n; row++) {
            reverseRow(matrix[row]);
        }
    }
 
    // Reverses one row in place.
    private void reverseRow(int[] row) {
        int left = 0;
        int right = row.length - 1;
 
        // Move both ends inward until the full row is reversed.
        while (left < right) {
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }
}
