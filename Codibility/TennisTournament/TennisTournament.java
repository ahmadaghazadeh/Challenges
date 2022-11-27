package Codibility.TennisTournament;

public class TennisTournament {
    public static void main(String args[]) {
        System.out.println(solution(10,3));
    }

    private static int solution(int P, int C) {
        int pairs=P/2;
        if(pairs>C)
            return C;
        else{
            return pairs;
        }
    }
     
}
