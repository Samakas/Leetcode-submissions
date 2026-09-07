class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st = new HashSet<>();
        int max = 0;
        int l = 0;
        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            while(st.contains(c)){
                st.remove(s.charAt(l));
                l++;
            }
            st.add(c);
            max = Math.max(max,r-l+1);
        }
        return max;
    }
}
