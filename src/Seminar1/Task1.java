package Seminar1;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abcd", "pq"));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder("");
        int idx = word1.length(), jdx = word2.length();
        int i = 0, j = 0;

        while (i < idx || j < jdx) {
            if (i < idx) {
                sb.append(word1.charAt(i));
                i++;
            }
            if (j < jdx) {
                sb.append(word2.charAt(j));
                j++;
            }
        }

        return sb.toString();
    }
}

