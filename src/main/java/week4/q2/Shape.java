package week4.q2;

import java.awt.*;

public class Shape {
    private String color;
    private FillType fillType;
    public Shape(String color,FillType fillType) {
        this.color = color;
        this.fillType=fillType;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color)
    {
        this.color=color;
    }
    public FillType getFillType() {
        return fillType;
    }
    public void setColor(FillType fillType)
    {
        this.fillType=fillType;
    }
    public void displayInfo()
    {
        System.out.println("Color: "+color +" FillType: "+fillType);
    }
    public String toString(){
        return "Shape: "+color +" FillType: "+fillType;
    }
}

class Circle extends Shape
{
    private double radius;
    private static final double PI=3.14;
    public Circle(String color,FillType fillType,double radius)
    {
        super(color,fillType);
        this.radius=radius;
    }
    public double getArea()
    {
        return PI*radius*radius;
    }
    public double calculateCircumference(double PI, double r)
    {
        return 2*PI*r;
    }
    public double calculateCircumference(double r)
    {
        return 2*PI*r;
    }
    @Override
    public void displayInfo()
    {
        super.displayInfo();
        System.out.println("Area: "+getArea());

    }

    /*@Override
    public String toString()
    {
        return super.toString() +" Radius: "+radius;
    }*/
}

class Rectangle extends Shape
{
    private double width;
    private double height;
    public Rectangle(String color,FillType fillType,double width,double height)
    {
        super(color,fillType);
        this.width=width;
        this.height=height;

    }

    public double getArea()
    {
        return width*height;
    }
    @Override
    public void displayInfo()
    {
        super.displayInfo();
        System.out.println("Width: "+width);
        System.out.println("Height: "+height);

    }


}