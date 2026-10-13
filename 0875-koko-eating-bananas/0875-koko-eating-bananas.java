class Solution {
     private boolean canFinish(int[] piles, int speed, int h) {
        // This stores the total hours needed for the current speed.
        long hours = 0;
 
        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;
 
            // If hours already cross h,
            // this speed is too slow.
            if (hours > h) {
                return false;
            }
        }
 
        // The speed works only when all piles finish within h hours.
        return hours <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        // The slowest possible eating speed is 1 banana per hour.
        int low = 1;
 
        // The largest pile is the fastest useful speed.
        int high = 0;
 
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
 
        while (low < high) {
            // mid is the eating speed being tested right now.
            int mid = low + (high - low) / 2;
 
            // If mid works, try the left side for a smaller speed.
            if (canFinish(piles, mid, h)) {
                high = mid;
            } else {
                // If mid fails, all smaller speeds fail too.
                low = mid + 1;
            }
        }
 
        return low;
    
    }
}