package io.octoprime.algo.math;

public class OverLappingRectangle {

    static public class Point
    {
        int x;
        int y;

        Point(int a, int b )
        {
            x = a;
            y = b;
        }
    }

    public static  boolean doOverlap(  Point[] rect1, Point[] rect2)
    {
        if ( rect1[0].x > rect2[0].x || rect1[1].x > rect2[1].x ) return false;
        if ( rect1[0].y < rect2[0].y || rect1[1].y < rect2[1].y ) return false;

        return true;
    }

    public static void main(String[] args)
    {
        Point l1 = new Point(0, 10);
        Point r1 = new Point(10, 0);


        Point l2 = new Point(5, 5);
        Point r2 = new Point (15, 0);

        boolean isOverlapped =  OverLappingRectangle.doOverlap( new Point[] {l1,r1}, new Point[]{l2,r2});

        System.out.println("rectangle overlaps: " +  (isOverlapped ? "true":"false"));
    }
}
