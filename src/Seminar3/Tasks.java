package Seminar3;

import java.util.ArrayList;
import java.util.Objects;
//import java.util.Iterator;

public class Tasks {
    public static void main(String[] args) {
        int[] arr1 = {10, 4, 5, 6, 7, 2, 2, 9};
        int[] arr2 = {10, 4, 2, 6, 7, 2, 5, 9};
        int[] arr3 = {10, 4, 5, 6, 7, 2, 2, 9};
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int num : arr1) {
            list1.add(num);
        }
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int num : arr2) {
            list2.add(num);
        }
        ArrayList<Integer> list3 = new ArrayList<>();
        for (int num : arr3) {
            list3.add(num);
        }

        System.out.println(arraysEqually(list1, list2));
        System.out.println(equallyCountNumToArrays(list1, list2, 2));
        System.out.println(sortEvenNumber(list3));
        System.out.println(removeEvenNum(list1));
    }

    public static boolean arraysEqually(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        if (list1.size() != list2.size()) {
            return false;
        } else {
            for (int i = 0; i < list1.size(); i++) {
                if (!Objects.equals(list1.get(i), list2.get(i))) return false;
            }
        }
        return true;
    }

    public static boolean equallyCountNumToArrays(ArrayList<Integer> list1, ArrayList<Integer> list2, int num) {
        int count = 0;
        for (int i : list1) {
            if (i == num) count++;
        }
        for (int i : list2) {
            if (i == num) count--;
        }
        return count == 0;
    }

    public static ArrayList<Integer> sortEvenNumber(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                int min = list.get(i);
                int minInd = i;
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(j) % 2 == 0 && list.get(j) < min) {
                        min = list.get(j);
                        minInd = j;
                    }
                }
                int temp = list.get(i);
                list.set(i, list.get(minInd));
                list.set(minInd, temp);
            }
        }
        return list;
    }

    public static ArrayList<Integer> removeEvenNum(ArrayList<Integer> list){
        list.removeIf(integer -> integer % 2 == 0); //подсказка IDE
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            if (iterator.next() % 2 == 0) {
//                iterator.remove();
//            }
//        }
        return list;
    }
}
