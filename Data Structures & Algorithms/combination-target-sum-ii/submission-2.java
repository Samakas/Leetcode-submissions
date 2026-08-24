class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates,target,new ArrayList<>(),0);
        return ans;
    }

    void backtrack(int[] nums,int target,List<Integer> l,int s){
        if(target==0){
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i=s;i<nums.length;i++){
            
            if(i>s && nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]>target) break;

            l.add(nums[i]);
            backtrack(nums,target-nums[i],l,i+1);
            l.remove(l.size()-1);
        }
    }
}
