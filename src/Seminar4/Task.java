package Seminar4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class Task {
    public static void main(String[] args) {
        //simplifyPath
        String path = "/../";
        System.out.println(simplifyPath(path));
        System.out.println();
        //maxAreaOfIsland(stack)
        int[][] grid = {{1,1,1,0,0,0,0,0,1,1,0,0,0},
                        {1,1,1,0,0,0,0,0,0,1,0,0,0},
                        {0,1,1,1,1,1,0,0,0,0,0,0,0},
                        {0,1,1,1,0,0,0,0,1,1,1,0,0},
                        {0,0,0,1,0,0,0,0,0,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,1,1,0},
                        {0,0,0,0,0,0,1,0,0,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,1,0,0}};
        System.out.println(maxAreaOfIsland(grid));
        System.out.println();
        //updateMatrix
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        System.out.println(Arrays.deepToString(updateMatrix(mat)));
    }

    static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        //fill stack
        for (String s : path.split("/")) {
            if (Objects.equals(s, "..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!Objects.equals(s, "") && !Objects.equals(s, ".") && !Objects.equals(s, "..")) {
                stack.push(s);
            }
        }
        //unpack stack
        StringBuilder resPath = new StringBuilder();
        if (stack.isEmpty()) {
            return "/";
        }
        while (!stack.isEmpty()) {
            resPath.insert(0, "/" + stack.pop());
        }
        return resPath.toString();
    }

    static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{i, j});
                    grid[i][j] = 0;
                    int counter = 0;
                    while (!stack.isEmpty()) {
                        int[] curCell = stack.pop();
                        int curRow = curCell[0];
                        int curCol = curCell[1];
                        if (curCol + 1 < grid[0].length && grid[curRow][curCol + 1] != 0) {
                            stack.push(new int[]{curRow, curCol + 1});
                            grid[curRow][curCol + 1] = 0;
                        }
                        if (curRow + 1 < grid.length && grid[curRow + 1][curCol] != 0) {
                            stack.push(new int[]{curRow + 1, curCol});
                            grid[curRow + 1][curCol] = 0;
                        }
                        if (curCol - 1 >= 0 && grid[curRow][curCol - 1] != 0) {
                            stack.push(new int[]{curRow, curCol - 1});
                            grid[curRow][curCol - 1] = 0;
                        }
                        if (curRow - 1 >= 0 && grid[curRow - 1][curCol] != 0) {
                            stack.push(new int[]{curRow - 1, curCol});
                            grid[curRow - 1][curCol] = 0;
                        }
                        counter++;
                    }
                    max = Math.max(max, counter);
                }
            }
        }
        return max;
    }

    static boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null ^ root.right == null) {
            return false;
        }
        Stack<TreeNode> stackLeft = new Stack<>();
        stackLeft.push(root.left);
        Stack<TreeNode> stackRight = new Stack<>();
        stackRight.push(root.right);
        while (!stackLeft.isEmpty()) {
            TreeNode currentLeft = stackLeft.pop();
            TreeNode currentRight = stackRight.pop();
            if (currentLeft.val != currentRight.val) return false;
            if (currentLeft.left == null ^ currentRight.right == null ||
                    currentLeft.right == null ^ currentRight.left == null) return false;
            if (currentLeft.left != null) {
                stackLeft.push(currentLeft.left);
                stackRight.push(currentRight.right);
            }
            if (currentLeft.right != null) {
                stackLeft.push(currentLeft.right);
                stackRight.push(currentRight.left);
            }
        }
        return true;
    }

    static int[][] updateMatrix(int[][] mat) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        final int EMPTY = Integer.MAX_VALUE;
        int[][] steps = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        //fill stack
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = EMPTY;
                }
            }
        }
        //
        while (!queue.isEmpty()) {
            int[] curCell = queue.poll();
            int curRow = curCell[0];
            int curCol = curCell[1];
            for (int[] step : steps) {
                int newRow = curRow + step[0];
                int newCol = curCol + step[1];
                if (newRow >= 0 && newRow < mat.length &&
                        newCol >= 0 && newCol < mat[0].length &&
                        mat[newRow][newCol] == EMPTY) {
                    mat[newRow][newCol] = mat[curRow][curCol] + 1;
                    queue.add(new int[]{newRow, newCol});
                }
            }

        }
        return mat;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}