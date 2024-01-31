package Codibility.MaxPathFromTheLeftTopCorner;

public class MaxPathFromTheLeftTopCorner {
    public static void main(String args[]) {
        int[][] givenArray=new int[][]{
        {9,9,7},
        {9,7,2},
        {6,9,5},
        {9,1,2}
        };
        String number=solution(givenArray);
        System.out.println(number);
    }

    static class Path{
        public int weight;
        public String path;
    }
    
    public static String solution(int[][] A) {
        Path path=new Path();
        path.path="";
        path.weight=0;
        return checkPath(A,0,0,path).path;
    }



    private static Path checkPath(int[][] t, int i,int j,Path path){
        int maxTurns=path.weight;
        path.path+=t[i][j];
        path.weight+= t[i][j];
        if(i<t.length-1){
          
            Path newPath=checkPath(t,  i+1, j,path);
            if(path.weight>maxTurns){
                path=newPath;
            }
        }

        if(j<t[0].length-1){
 
            Path newPath=checkPath(t,  i, j+1,path);
            if(path.weight>maxTurns){
                path=newPath;
            } 
        }
        return path;
    }


}

