class Solution{
    public String convert(String s,int n){
        if(n==1||n>=s.length())return s;
        StringBuilder[] a=new StringBuilder[n];
        for(int i=0;i<n;i++)a[i]=new StringBuilder();
        int r=0,d=1;
        for(char c:s.toCharArray()){
            a[r].append(c);
            if(r==0)d=1;
            else if(r==n-1)d=-1;
            r+=d;
        }
        StringBuilder ans=new StringBuilder();
        for(StringBuilder x:a)ans.append(x);
        return ans.toString();
    }
}