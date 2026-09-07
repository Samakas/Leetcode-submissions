
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    count++;
                    bfs(i,j,grid,vis);
                }
            }
        }
        return count;
    }
    private void bfs(int r,int c,char[][] grid,boolean[][] vis){
        int[] arr = {r,c};
        Queue<int[]> q = new LinkedList<>();
        q.offer(arr);
        vis[r][c] = true;
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };
        int n = grid.length;
        int m = grid[0].length;
        while(!q.isEmpty()){
            int[] mat = q.poll();
            int row = mat[0];
            int col = mat[1];
            for(int[] a:directions){
                int nr = row+a[0];
                int nc = col+a[1];
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc] =='1' && !vis[nr][nc]){
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }

}