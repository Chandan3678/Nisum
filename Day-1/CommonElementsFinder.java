package day2;



import java.util.*;

public class CommonElementsFinder {

    public static List<Integer> findCommonElements(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);

        set1.retainAll(list2);

        return new ArrayList<>(set1);
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);

        List<Integer> common = findCommonElements(list1, list2);

        System.out.println("Common Elements: " + common);
    }
}
