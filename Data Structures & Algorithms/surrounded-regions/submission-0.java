class Solution {
    int m;
    int n;
    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    if(!vis[i][j] && board[i][j] == 'O'){
                        bfs(vis,i,j,board);
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void bfs(boolean[][] vis,int r,int c,char[][] board){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        int[][] dir = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };
        vis[r][c] = true;
        while(!q.isEmpty()){
            int[] a = q.poll();
            int row = a[0];
            int col = a[1];
            for(int[] d:dir){
                int nr = row+d[0];
                int nc = col+d[1];
                if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && board[nr][nc]=='O'){
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }
}
