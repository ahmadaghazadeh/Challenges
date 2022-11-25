package BinaryGap;
public class BinaryGap {
    public static void main(String args[]) {
        System.out.println(solution(1041));
    }

    private static int solution(int N) {
        int countGap=0;
        String binaryString=Integer.toBinaryString(N);
        int index=0;
        
        while(index<binaryString.length()-1 && index>=0){
            int first=findOne(binaryString, index);        
            int second=findOne(binaryString, first+1);
            index=second;
            if(second-first-1>countGap){
                countGap=second-first-1;
            }
        }
        return countGap;
    }
    private static int findOne(String binary,int index){
        for (int i = index; i < binary.length(); i++) {
            if(binary.charAt(i)=='1'){
                return i;
            }
        }
        return -1;
    }
}
