package Seminar5;

import java.util.*;

public class Task {
    public static void main(String[] args) {
        String[] words1 = {"leetcode","is","amazing","as","is"}, words2 = {"amazing","leetcode","is"};
        System.out.println(countWords(words1, words2));
        System.out.println();
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd) 5.txt(abhcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
        System.out.println(findDuplicate(paths));
    }

    public static int countWords(String[] words1, String[] words2) {
        if (words1.length > words2.length) {
            return countWords(words2, words1);
        }
        Map<String, Integer> map1 = new HashMap<>();
        for (String word : words1) {
            map1.putIfAbsent(word, 0);
            map1.put(word, map1.get(word) + 1);
        }
        Map<String, Integer> map2 = new HashMap<>();
        for (String word : words2) {
            map2.putIfAbsent(word, 0);
            map2.put(word, map2.get(word) + 1);
        }
        int count = 0;
        for (String word : map1.keySet()) {
            if (map1.get(word) == 1 && map2.containsKey(word) && map2.get(word) == 1) {
                count++;
            }
        }
        return count;
    }

    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String string : paths) {
            String[] files = string.split(" ");
            String path = files[0];
            for (int i = 1; i < files.length; i++) {
                String content = files[i].split("\\(")[1].split("\\)")[0];
                String file = files[i].split("\\(")[0];
                map.putIfAbsent(content, new ArrayList<String>());
                map.get(content).add(path + "/" + file);
            }
        }
        List<List<String>> lists = new ArrayList<>();
        for (List<String> list : map.values()) {
            if (list.size() > 1) {
                lists.add(list);
            }
        }
        return lists;
    }
}
