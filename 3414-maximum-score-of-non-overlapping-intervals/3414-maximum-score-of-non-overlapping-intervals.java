import java.util.*;

class Solution {
    static class I {
        int l,r,w,id;
        I(int l,int r,int w,int id){
            this.l=l;
            this.r=r;
            this.w=w;
            this.id=id;
        }
    }

    static class S {
        long w;
        int[] a;
        S(long w,int[] a){
            this.w=w;
            this.a=a;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n=intervals.size();
        I[] b=new I[n];

        for(int i=0;i<n;i++){
            List<Integer> x=intervals.get(i);
            b[i]=new I(x.get(0),x.get(1),x.get(2),i);
        }

        Arrays.sort(b,(x,y)->x.r==y.r?x.l-y.l:x.r-y.r);

        int[] rs=new int[n];
        for(int i=0;i<n;i++) rs[i]=b[i].r;

        S[][] dp=new S[5][n+1];

        for(int k=0;k<=4;k++)
            for(int i=0;i<=n;i++)
                dp[k][i]=new S(0,new int[0]);

        for(int i=1;i<=n;i++){
            I x=b[i-1];

            for(int k=1;k<=4;k++){
                S skip=dp[k][i-1];

                int p=prev(rs,x.l,i-1);
                S old=dp[k-1][p];

                int[] a=Arrays.copyOf(old.a,old.a.length+1);
                a[a.length-1]=x.id;
                Arrays.sort(a);

                S take=new S(old.w+x.w,a);

                if(take.w>skip.w||(take.w==skip.w&&cmp(take.a,skip.a)<0))
                    dp[k][i]=take;
                else
                    dp[k][i]=skip;
            }
        }

        return dp[4][n].a;
    }

    static int prev(int[] r,int x,int n){
        int l=0,h=n;
        while(l<h){
            int m=(l+h)>>>1;
            if(r[m]<x) l=m+1;
            else h=m;
        }
        return l;
    }

    static int cmp(int[] a,int[] b){
        int n=Math.min(a.length,b.length);

        for(int i=0;i<n;i++){
            if(a[i]!=b[i])
                return Integer.compare(a[i],b[i]);
        }

        return Integer.compare(a.length,b.length);
    }
}