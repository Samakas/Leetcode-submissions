class Solution {
    int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1  && !vis[i][j]){
                    bfs(grid,i,j,vis);
                }
            }
        }
        return max;
    }

    public void bfs(int[][] grid,int r,int c,boolean[][] vis){
        Queue<int[]> q = new LinkedList<>();
        vis[r][c] = true;
        q.offer(new int[]{r,c});
        int[][] dir = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };
        int count = 1;
        while(!q.isEmpty()){
            int[] a = q.poll();
            int row = a[0];
            int col = a[1];
            for(int[] d:dir){
                int nr = row+d[0];
                int nc = col + d[1];
                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1 && !vis[nr][nc]){
                    count++;
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        max = Math.max(count,max);
    }
}
