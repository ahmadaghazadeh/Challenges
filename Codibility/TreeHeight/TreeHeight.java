package Codibility.TreeHeight;

public class TreeHeight {
    public static void main(String args[]) {
        Tree tree=null;
        
        int count=solution(tree);
        System.out.println(count);
    }

    public static int solution(Tree T) {
        // write your code in Java SE 8
        if(T==null)
        return 0;
        return checkPath(T, 0, true, true);
    }

    private static int checkPath(Tree t, int hight,boolean left,boolean right){
        int maxhight=hight;
        int hightL=hight;
        int hightR=hight;
        if(t.l!=null){
            hightL++;
            maxhight=Math.max(checkPath(t.l, hightL, true, false), maxhight);
        }

        if(t.r!=null){
            hightR++;
            maxhight=Math.max(checkPath(t.r, hightR, false, true), maxhight);
        }
        return maxhight;
    }

}

