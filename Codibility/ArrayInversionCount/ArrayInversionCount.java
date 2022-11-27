package Codibility.ArrayInversionCount;

public class ArrayInversionCount {
    public static void main(String args[]) {
        int[] givenArray=new int[]{-1,6,3,4,7,4};
        System.out.println(solution(givenArray));
    }

    private static int solution(int[] A) {
        int result=0;
        if (A.length>=1000000000)
           return -1;

        for (int i = 0; i < A.length-1; i++) {
            for (int j = i+1; j < A.length; j++) {
                if(A[i]>A[j]){
                    result++;
                   }
                }
            }
        return result;
    }
}
