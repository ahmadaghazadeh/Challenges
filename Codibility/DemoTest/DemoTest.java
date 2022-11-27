package DemoTest;

import java.util.Arrays;

public class DemoTest{
    public static void main(String args[]){  
        int[] givenArray=new int[]{1, 3, 6, 4, 1, 2,7,8};
        System.out.println(solution(givenArray));  
    }  

    public static int solution(int[] A) {
        
        Arrays.sort(A);
        int currentSmallestNumber=1;
        for (int i = 0; i < A.length; i++) {
           if(currentSmallestNumber==A[i] && A[i]>0){
            if(i==A.length-1){
                return ++currentSmallestNumber;
            }else{
                currentSmallestNumber++;
            }
           }else if(currentSmallestNumber<A[i]){
              return currentSmallestNumber;
           }
        }
        return currentSmallestNumber;
    }
}