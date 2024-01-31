package Codibility.Test1;

public class Test1 {
    public static void main(String args[]) {
        int[] givenArray=new int[]{4,3,0,1,2,5};
        String count=solution("bytdag",givenArray);
        System.out.println(count);
    }

    public static String solution( String S, int[] A) {
        int nextItem=0;
        String result="";
        
        for (int i = 0; i < A.length; i++) {
            result+=S.charAt(nextItem);
            nextItem=A[nextItem];
            if(nextItem==0){
                break;
            }
        }
        return result;
    }


}

