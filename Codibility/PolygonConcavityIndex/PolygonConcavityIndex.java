package Codibility.PolygonConcavityIndex;

public class PolygonConcavityIndex {
    public static void main(String args[]) {
        Point2D[] givenArray=new Point2D[]{
            new Point2D(0,2),
            new Point2D(2,2),
            new Point2D(2,0),
            new Point2D(1,-2),
            new Point2D(1,-1),
            new Point2D(0,-2),
            new Point2D(-2,-2),
            new Point2D(-2,0),
            new Point2D(-2,2)

            // new Point2D(-1,3),
            // new Point2D(1,2),
            // new Point2D(1,1),
            // new Point2D(3,1),
            // new Point2D(0,-1),
            // new Point2D(-2,1),
            // new Point2D(-1,2)

            // new Point2D(-1,3),
            // new Point2D(1,2),
            // new Point2D(3,1),
            // new Point2D(0,-1),
            // new Point2D(-2,1),
        };
            
        System.out.println(solution(givenArray));
    }

    private static int solution(Point2D[] A) {
     
        int N = A.length;
        int prev = 0;
    
        int curr = 0;
    
        for (int i = 0; i < N; i++) {
    
            Point2D temp[]= { A[i],
                    A[(i + 1) % N],
                    A[(i + 2) % N] };
    
            curr = cross(temp);
            System.out.println("***********");
            for (Point2D point2d : temp) {
                System.out.println(point2d.x +","+point2d.y);
            }
            if (curr != 0) {
    
                if (curr * prev < 0) {
                    System.out.println("xxxx");
                    for (Point2D point2d : temp) {
                        System.out.println(point2d.x +","+point2d.y);
                    }
                    System.out.println("Xxxx");
                    return i+1;
                }
                else {
                    prev = curr;
                }
            }
        }
        return -1;
    }

    private static int cross(Point2D A[])
    {
        int X1 = (A[1].x - A[0].x);
    
        int Y1 = (A[1].y - A[0].y);
    
        int X2 = (A[2].x - A[0].x);
    
        int Y2 = (A[2].y - A[0].y);
    
        return (X1 * Y2 - Y1 * X2);
    }

    
}
