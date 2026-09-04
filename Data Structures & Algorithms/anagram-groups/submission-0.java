class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sor = new String(arr);
            if(!map.containsKey(sor)){
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(sor,l);
            }
            else{
                map.get(sor).add(s);
            }
        }
        return new ArrayList<>(map.values());
    }
}
