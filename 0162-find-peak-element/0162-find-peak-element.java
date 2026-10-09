class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
 
        // Right boundary of the current search range.
        int high = nums.length - 1;
 
        // Keep shrinking the search range until one peak position remains.
        while (low < high) {
            // Calculate the middle index safely.
            int mid = low + (high - low) / 2;
 
            // A rising slope means some peak must exist on the right side.
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                // A falling slope means mid or the left side contains a peak.
                high = mid;
            }
        }
 
        return low;
    }
    
}