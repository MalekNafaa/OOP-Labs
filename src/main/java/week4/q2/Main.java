package week4.q2;



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        // DISPLAYINFO TEST
        /*Shape shape1 = new Shape("Red", FillType.FILLED);
        shape1.displayInfo();*/

        // EXTRA ARRAY TEST
        /*ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Shape("Blue",FillType.FILLED));
        shapes.add(new Shape("Red",FillType.FILLED));
        shapes.add(new Shape("Yellow",FillType.NOT_FILLED));
        System.out.println(shapes);*/

        //trying cricle
/*
        Circle circle = new Circle("Red", FillType.FILLED, 5.0);
        circle.displayInfo();
        System.out.println(circle.calculateCircumference(3.14,5.0));
        System.out.println(circle.calculateCircumference(5.0));
*/

        Rectangle rectangle = new Rectangle("Blue", FillType.NOT_FILLED, 4.0, 6.0);
        rectangle.displayInfo();
        System.out.println(rectangle.getArea());
}
}
