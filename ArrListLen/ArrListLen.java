package ArraryChallenge;

public class Challenge1 {
    
    public static void main(String args[]) {
        int[] givenArray=new int[]{1,4,-1,3,2};
        System.out.println(solution(givenArray));
    }

    private static int solution(int[] A)  {
         int length=1;
         int nextItem=0;
         while(A[nextItem]!=-1){
            nextItem=A[nextItem];
            length++;
         }
         return length;
    }

}
