class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        recurse(nums,0,new ArrayList<>());
        return ans;
    }

    void recurse(int[] nums,int i,List<Integer> l){
        if(i==nums.length){
            ans.add(new ArrayList<>(l));
            return;
        }
        l.add(nums[i]);
        recurse(nums,i+1,l);
        l.remove(l.size()-1);
        recurse(nums,i+1,l);
    }
}
