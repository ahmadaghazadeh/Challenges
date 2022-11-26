import java.util.Arrays;

public class FirstUnique {
    public static void main(String args[]) {
        int[] givenArray=new int[]{6, 4, 4, 6};
        int number=solution(givenArray);
        System.out.println(number);
    }

    public static int solution(int[] A) {
        int sorted[]=A.clone();
        Arrays.sort(sorted);
        for (int i = 0; i < sorted.length; i++) {
            int count=0;
            for (int j = 0; j < sorted.length; j++) {
                if(A[i]==sorted[j]){
                    count++;
                    if(count>1){
                        break;
                    }                      
                }     
            }
            if(count==1){
                return A[i];
            }
        }
        return -1;
    }

}

