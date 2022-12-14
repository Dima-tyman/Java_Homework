package Seminar2;

public class Task2 {
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] res = floodFill(image, 1,1,2);
        for (int[] re : res) {
            for (int j : re) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    public static void dfs(int[][] image, int sr, int sc, int color, int sourse) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length ||
                image[sr][sc] != sourse || image[sr][sc] == color) {
            //do nothing
        } else {
            image[sr][sc] = color;
            dfs(image, sr + 1, sc, color, sourse);
            dfs(image, sr, sc + 1, color, sourse);
            dfs(image, sr - 1, sc, color, sourse);
            dfs(image, sr, sc - 1, color, sourse);
        }
    }
}
