package CountConformingBitmasks;

public class CountConformingBitmasks {
    public static void main(String args[]) {
        int count=solution(1073741727,1073741631,1073741679);
        System.out.println(count);
    }

    private static int solution(int A,int B,int C) {
        int counter=0;
        String binaryA=Integer.toBinaryString(A);
        String binaryB=Integer.toBinaryString(B);
        String binaryC=Integer.toBinaryString(C);
        for (int i = 0; i < binaryA.length(); i++) {
            if(binaryA.charAt(i)!=binaryB.charAt(i)){
                counter++;
            }
            if( binaryA.charAt(i)!=binaryC.charAt(i)){
                counter++;
            }
            if(binaryB.charAt(i)!=binaryC.charAt(i)){
                counter++;
            }
        }
       return counter;
    }
}
