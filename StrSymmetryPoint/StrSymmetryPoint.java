package StrSymmetryPoint;

public class StrSymmetryPoint {
    public static void main(String args[]) {
        String givenString="racecar";
        int number=solution(givenString);
        System.out.println(number);
    }

    public static int solution(String S) {
        if(S.length()%2==0){
            return 0;
        }
        int mide=((S.length()-1)/2);
        for (int i = 0; i < mide-1; i++) {
            if(S.charAt(mide-1-i)!=S.charAt(mide+1+i)){
                return 0;
            }
        }
        return mide;
    }
}

