package Seminar1;

public class Task2 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        for (int i = 0; i < arr.length; i++) System.out.print(arr[i]);
        System.out.println();
        System.out.println(removeElement(arr, 2));
        for (int i = 0; i < arr.length; i++) System.out.print(arr[i]);
    }

    public static int removeElement(int[] nums, int val) {

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (i == j) j++;
                else {
                    nums[j] = nums[i];
                    nums[i] = val;
                    j++;
                }
            }
        }
        return j;
    }
}
