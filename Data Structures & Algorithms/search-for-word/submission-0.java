class Solution {
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && board[i][j]==word.charAt(0)){
                    if(dfs(board,word,0,vis,i,j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, String word,int id,boolean[][] vis,int r,int c){
        if(r<0 || r>=m || c<0 || c>=n || vis[r][c] || board[r][c]!=word.charAt(id)){
            return false;
        }
        if(id==word.length()-1) return true;
        vis[r][c] = true;
        boolean found = dfs(board,word,id+1,vis,r+1,c)||
        dfs(board,word,id+1,vis,r-1,c)||
        dfs(board,word,id+1,vis,r,c+1)||
        dfs(board,word,id+1,vis,r,c-1);

        vis[r][c] = false;
        return found;
    }
}
