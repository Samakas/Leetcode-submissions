class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int n:piles){
            max = Math.max(n,max);
        }
        int hi = max;
        int l = 1;
        int ans = hi;
        while(l<=hi){
            int mid = l+(hi-l)/2;
            if(caneat(piles,h,mid)){
                ans = mid;
                hi = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return ans;
    }

    public boolean caneat(int[] piles,int h,int i){
        int total = 0;
        for(int p:piles){
            total+=Math.ceil((double)p/i);
        }
        return total<=h;
    }
}
