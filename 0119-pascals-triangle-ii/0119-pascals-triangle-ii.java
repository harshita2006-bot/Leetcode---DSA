class Solution {
    public List<Integer> getRow(int rowIndex) {
       List<Integer> ans = new ArrayList<>();

       int n = rowIndex + 1;
       long val = 1;
       ans.add(1);
       for(int i = 1; i<n; i++) {
        val = val * (n-i);
        val = val/i;

        ans.add((int)val);
       }

       return(ans);
    }
}