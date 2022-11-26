package CountBoundedSlices;

public class CountBoundedSlices {
    public static void main(String args[]) {
        int[] givenArray=new int[]{3,5,7,6,3};
        System.out.println(solution(givenArray,2));
    }

    private static int solution(int[] N,int K) {
        int count=0;
        for (int i = 0; i < N.length; i++) {
            int min=N[i];
            int max=N[i];
            for (int j = i; j < N.length; j++) {
                if(min>=N[j]){
                    min=N[j];
                }
                if(max<=N[j]){
                    max=N[j];
                }
                if(max-min<=K){
                    System.out.println("("+i+","+j+")");
                    count++;
                }else{
                    break;
                }
            }
        }
        return count;
    }
     
}
