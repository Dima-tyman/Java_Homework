package Seminar2;

public class Task1 {
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, AreaOfIsland(i, j, grid));
                }
            }
        }
        return max;
    }

    public static int AreaOfIsland(int row, int column, int[][] arr) {
        if (row < 0 || row >= arr.length || column < 0 || column >= arr[0].length) {
            return 0;
        } else if (arr[row][column] == 1) {
            arr[row][column] = 0;
            return 1 +
                    AreaOfIsland(row + 1, column, arr) +  //down
                    AreaOfIsland(row, column + 1, arr) +  //right
                    AreaOfIsland(row - 1, column, arr) +  //up
                    AreaOfIsland(row, column - 1, arr);   //left
        } else {
            return 0;
        }
    }
}
