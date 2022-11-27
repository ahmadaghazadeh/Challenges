package StrSymmetryPoint;

public class StrSymmetryPoint {
    public static void main(String args[]) {
        String givenString="x1x";
        int number=solution(givenString);
        System.out.println(number);
    }

    public static int solution(String S) {
        if(S.length()==1){
            return 0;
        }
        if(S.length()%2==0 && S.length()!=1){
            return -1;
        }
        int mide=((S.length()-1)/2);
        for (int i = 0; i < mide; i++) {
            if(S.charAt(mide-1-i)!=S.charAt(mide+1+i)){
                return -1;
            }
        }
        return mide;
    }
}

