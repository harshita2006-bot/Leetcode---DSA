class Solution {
    private boolean canShip (int[] weights, int days, int capacity) {
        int load = 0;
        int usedDays = 1;
        for(int weight : weights) {
            if(load+weight > capacity) {
                usedDays = usedDays + 1;
                load = weight;
            }
            else {
                load = load + weight;
            }
        }
        return usedDays <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for(int weight : weights) {
            low = Math.max(low, weight);
            high = high + weight;
        }
        int answer = high;

        while(low <= high) {
            
            int mid = low + (high - low) / 2;
            if(canShip(weights, days, mid)) {
                answer = mid;
                high = mid - 1;

            }
            else {
                low = mid + 1;
            }

        }
        return answer;
    }
}