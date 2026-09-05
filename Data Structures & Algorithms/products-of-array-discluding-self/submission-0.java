class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        pre[0] = 1;
        int prop = 1;
        for(int i=1;i<nums.length;i++){
            prop = prop*nums[i-1];
            pre[i] = prop;
        }
        int[] suf = new int[nums.length];
        suf[nums.length-1] = 1;
        int pros = 1;
        for(int i=nums.length-2;i>=0;i--){
            pros = pros*nums[i+1];
            suf[i] = pros;
        }
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i] = pre[i]*suf[i];
        }
        return ans;
    }
}  
