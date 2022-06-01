import java.util.Arrays;

public class SortRectangles {
    public static void main(String[] args) {
        ComparableRectangle[] rectangles={new ComparableRectangle(5, 3),
            new ComparableRectangle(3, 2),
            new ComparableRectangle(8, 5)};
        for(ComparableRectangle rect:rectangles)
        {
            System.out.println(rect);
        }
        Arrays.sort(rectangles);
        for(ComparableRectangle rect:rectangles)
        {
            System.out.println(rect);
        }
    }
}
