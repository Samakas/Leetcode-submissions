class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        int[][] dir = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };
        int min = 0;
        while(!q.isEmpty() && fresh>0){
            int s = q.size();
            while(s-- >0){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                for(int[] d:dir){
                    int nr = r+d[0];
                    int nc = c+d[1];
                    if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
            min++;
        }

        return fresh == 0 ? min : -1;
    }
}
