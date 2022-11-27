package Codibility.FirstUnique;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class FirstUnique {
    public static void main(String args[]) {
        int[] givenArray=new int[]{4, 10, 5, 4, 2, 10};
        int number=solution(givenArray);
        System.out.println(number);
    }

    public static int solution(int[] A) {
        Set<Integer> input = new LinkedHashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        for (Integer x : A) {
            if (!input.add(x)) {
                duplicates.add(x);
            }
        }
        input.removeAll(duplicates);
        return input.isEmpty() ? -1 : input.iterator().next();
    }

}

