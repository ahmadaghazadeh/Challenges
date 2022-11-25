package SparseBinaryDecomposition;

public class SparseBinaryDecomposition {
    public static void main(String args[]) {
        int count=solution(26);
        System.out.println(count);
    }

    private static int solution(int N) {
        int result=-1;
        for (int i = N; i > 0; i--) {
            if(isSpare(i)){
                if(isSpare(N-i)){
                    return i;
                }
            }
        }
        return result;
    }

    private static boolean isSpare(int number){
        return Integer.toBinaryString(number).indexOf("11")==-1;
    }
     
}
