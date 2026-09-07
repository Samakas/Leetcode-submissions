class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> m = new HashMap<>();
        int l = 0;
        int res = 0;
        int max = 0;
        for(int r= 0;r<s.length();r++){
            char c = s.charAt(r);
            m.put(c,m.getOrDefault(c,0)+1);
            max = Math.max(max,m.get(c));
            while((r-l+1)-max>k){
                m.put(s.charAt(l),m.get(s.charAt(l))-1);
                l++;
            }
            res = Math.max(res,r-l+1);
        }
        return res;
    }
}
