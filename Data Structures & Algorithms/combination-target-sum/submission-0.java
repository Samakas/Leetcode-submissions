class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums,target,new ArrayList<>(),0);
        return ans;
    }
    void backtrack(int[] nums,int target,List<Integer> l,int s){
        if(target==0){
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i=s;i<nums.length;i++){
            if(nums[i]>target) continue;
            l.add(nums[i]);
            backtrack(nums,target-nums[i],l,i);
            l.remove(l.size()-1);
        }
    }
}
