package Seminar1;

public class Task4 {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                temp.append(s.charAt(i));
            }
            else if (!temp.toString().equals("")) { //появилась подсказка, изменил в соответствии с ней
                sb.append(temp.reverse());
                sb.append(' ');
                temp.delete(0, temp.length());
            }
        }
        if (!temp.toString().equals("")) {
            sb.append(temp.reverse());
        } else
            sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
