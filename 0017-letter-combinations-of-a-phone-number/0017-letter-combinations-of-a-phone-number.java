class Solution{
    String[] m={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> a=new ArrayList<>();
    public List<String> letterCombinations(String digits){
        bt(digits,0,new StringBuilder());
        return a;
    }
    void bt(String s,int i,StringBuilder t){
        if(i==s.length()){
            a.add(t.toString());
            return;
        }
        String x=m[s.charAt(i)-'0'];
        for(char c:x.toCharArray()){
            t.append(c);
            bt(s,i+1,t);
            t.deleteCharAt(t.length()-1);
        }
    }
}