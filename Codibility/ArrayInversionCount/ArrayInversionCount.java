package Codibility.ArrayInversionCount;

public class ArrayInversionCount {
    public static void main(String args[]) {
        int[] givenArray=new int[]{-1,6,3,4,7,4};
        System.out.println(solution(givenArray));
    }

    private static int solution(int[] A) {
        int result=-1;
        if (A.length>=1000000000)
           return result;

        for (int i = 0; i < A.length; i++) {
            for (int j = 1; j < A.length; j++) {
                if(A[i]>A[j])
                   result++;
            }
        }
        return result;
    }
 
}
