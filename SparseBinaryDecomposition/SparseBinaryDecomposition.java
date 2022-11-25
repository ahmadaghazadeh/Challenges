package SparseBinaryDecomposition;

public class SparseBinaryDecomposition {
    public static void main(String args[]) {
        int count=solution(74901729);
        System.out.println(count);
    }

    private static int solution(int N) {
        if (N <= 2)
           return N;
        for (int i = (N/2); i > 0; i--) {
            if(isSpare(i)){
                if(isSpare(N-i)){
                    return i;
                }
            }
        }
        return -1;
    }

    private static boolean isSpare(int number){
        return Integer.toBinaryString(number).indexOf("11")==-1;
    }
     
}
