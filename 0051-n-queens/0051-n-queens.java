class Solution{
    List<List<String>> ans=new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n){
        char[][] b=new char[n][n];
        for(char[] r:b)Arrays.fill(r,'.');
        solve(0,n,b);
        return ans;
    }
    
    void solve(int r,int n,char[][] b){
        if(r==n){
            List<String> x=new ArrayList<>();
            for(char[] row:b)x.add(new String(row));
            ans.add(x);
            return;
        }
        
        for(int c=0;c<n;c++){
            if(ok(r,c,n,b)){
                b[r][c]='Q';
                solve(r+1,n,b);
                b[r][c]='.';
            }
        }
    } 
    boolean ok(int r,int c,int n,char[][] b){
        for(int i=0;i<r;i++)
            if(b[i][c]=='Q')return false;           
        for(int i=r-1,j=c-1;i>=0&&j>=0;i--,j--)
            if(b[i][j]=='Q')return false;  
        for(int i=r-1,j=c+1;i>=0&&j<n;i--,j++)
            if(b[i][j]=='Q')return false; 
        return true;
    }
}