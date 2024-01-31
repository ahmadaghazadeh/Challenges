import java.util.Arrays;

public class DemoCodility {
    public static void main(String args[]) {
        int[] givenArray=new int[]{1, 3, 6, 4, 1, 2};
        System.out.println(solution(givenArray));
    }

    private static int solution(int[] A) {
        int tempArray[]= Arrays.stream(A).sorted().toArray();
        int smallestNumber=0;
        for(int i=0; i < tempArray.length; i++){
            if(tempArray[i]>smallestNumber){
                if(smallestNumber+1==tempArray[i])
                    smallestNumber=tempArray[i];
                else
                    return smallestNumber+1;
            }
        }
        return smallestNumber+1;
    }

}
