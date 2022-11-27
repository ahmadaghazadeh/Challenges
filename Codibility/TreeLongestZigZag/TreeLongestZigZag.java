package Codibility.TreeLongestZigZag;

public class TreeLongestZigZag {
    public static void main(String args[]) {
        Tree tree=new Tree(5);
        
        tree.l = new Tree(3);
        tree.l.l = new Tree(20);
        tree.l.l.l = new Tree(6);
        tree.r = new Tree(10);
        tree.r.l = new Tree(1);
        tree.r.r = new Tree(15);
        tree.r.r.l = new Tree(30);
        tree.r.r.r = new Tree(8);
        tree.r.r.l.r = new Tree(9);
        
        int count=solution(tree);
        System.out.println(count);
    }

    public static int solution(Tree T) {
        // write your code in Java SE 8
        return checkPath(T, 0, true, true);
    }

    private static int checkPath(Tree t, int turns,boolean left,boolean right){
        int maxTurns=turns;
        int turnsL=turns;
        int turnsR=turns;
        if(t.l!=null){
            if(!left){
                turnsL++;
            }
            maxTurns=Math.max(checkPath(t.l, turnsL, true, false), maxTurns);
        }

        if(t.r!=null){
            if(!right){
                turnsR++;
            }
            maxTurns=Math.max(checkPath(t.r, turnsR, false, true), maxTurns);
        }
        return maxTurns;
    }

}

