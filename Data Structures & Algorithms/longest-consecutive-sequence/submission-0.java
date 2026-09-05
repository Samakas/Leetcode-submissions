class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i:nums){
            s.add(i);
        }
        int ans = 0;
        for(int n:s){
            if(!s.contains(n-1)){
                int len = 1;
                while(s.contains(n+len)){
                    len++;
                }
                ans = Math.max(ans,len);
            }
        }
        return ans;
    }
}
