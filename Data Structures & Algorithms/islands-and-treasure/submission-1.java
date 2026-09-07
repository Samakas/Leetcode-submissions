class Solution {
    int INF = 2147483647;
    int row;
    int col;
    public void islandsAndTreasure(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        }

        int[][] dir = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        while(!q.isEmpty()){
            int[] a = q.poll();
            int r1 = a[0];
            int c1 = a[1];
            for(int[] d:dir){
                int nr = r1+d[0];
                int nc = c1+d[1];
                if(nr>=0 && nr<row && nc>=0 && nc<col && grid[nr][nc]==INF){
                    grid[nr][nc] = grid[r1][c1] + 1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }
}