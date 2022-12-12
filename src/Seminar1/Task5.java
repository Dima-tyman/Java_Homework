package Seminar1;

public class Task5 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder palindrom = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90)         //65..90  -  A..Z
                palindrom.append((char) (s.charAt(i) + 32));
            else if (s.charAt(i) >= 97 && s.charAt(i) <= 122)   //97..122 - a..z
                palindrom.append(s.charAt(i));
            else if (s.charAt(i) >= 48 && s.charAt(i) <= 57)   //48..57 - 0..9
                palindrom.append(s.charAt(i));
        }
        return palindrom.toString().equals(palindrom.reverse().toString());
    }
}
