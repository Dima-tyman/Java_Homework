package Seminar1;

public class Task3 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0}, nums2 = {2,5,6};
        int m = 3,  n = 3;
        for (int i : nums1) System.out.print(i);
        System.out.println();
        merge(nums1, m, nums2, n);
        for (int i : nums1) System.out.print(i);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        m--; n--;
        for (int i = m + n + 1; i >= 0; i--) {
            if (n < 0 || m >= 0 && nums1[m] > nums2[n]) {
                nums1[i] = nums1[m];
                m--;
            } else {
                nums1[i] = nums2[n];
                n--;
            }
        }
    }
}
