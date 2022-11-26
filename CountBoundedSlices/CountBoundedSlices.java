package CountBoundedSlices;

public class CountBoundedSlices {
    public static void main(String args[]) {
        int[] givenArray=new int[]{3,5,7,6,3};
        System.out.println(solution(givenArray,2));
    }

    private static int solution(int[] A,int K) {
        int count=0;
        int endSlice=3;
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < i+endSlice; j++) {
                if(j<A.length){
                    if(Math.abs(A[j]-A[i])<=K){
                        System.out.println("("+i+","+j+")");
                        count++;
                    }else{
                        break;
                    }
                }
            }
        }
        return count;
    }
     
}
