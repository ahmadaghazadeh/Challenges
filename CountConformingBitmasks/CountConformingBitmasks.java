package CountConformingBitmasks;


public class Lesson2CyclicRotation {
    public static void main(String args[]) {
        int[] givenArray=new int[]{};
        int[] result=solution(givenArray,3);
        for (int i = 0; i < result.length; i++) {
            System.out.print(" "+ result[i]);
          
        }
        System.out.println();
    }

    private static int[] solution(int[] A,int k) {
         for (int i = 1; i <= k; i++) {
            A=rotationOneTime(A);
         }
         return A;
    }
    private static int[] rotationOneTime(int[] A){
        if(A.length<1){
            return A;
        }
        int temp1=A[A.length-1];
        int temp2=A[0];
        for (int i = 0; i < A.length-1; i++) {
             temp2=A[i];
             A[i]=temp1;
             temp1=temp2;
        }
        A[A.length-1]=temp2;       
        return A;  
    }

    
}
