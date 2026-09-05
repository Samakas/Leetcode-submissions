class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        PriorityQueue<Integer> ans = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for(int n:map.keySet()){
            ans.add(n);
        }
        int[] arr = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] = ans.poll();
        }

        return arr;
    }
}
