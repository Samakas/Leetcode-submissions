class Solution {
    List<String> res = new ArrayList<>();
    Map<Character,String> dig = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return res;
        dig.put('2',"abc");
        dig.put('3',"def");
        dig.put('4',"ghi");
        dig.put('5',"jkl");
        dig.put('6',"mno");
        dig.put('7',"pqrs");
        dig.put('8',"tuv");
        dig.put('9',"wxyz");
        recur(digits,new StringBuilder(),0);
        return res;
    }

    void recur(String digit,StringBuilder ans,int id){
        if(id==digit.length()){
            res.add(ans.toString());
            return;
        }
        String curr = dig.get(digit.charAt(id));
        for(char c:curr.toCharArray()){
            ans.append(c);
            recur(digit,ans,id+1);
            ans.deleteCharAt(ans.length()-1);
        }
    }
}
