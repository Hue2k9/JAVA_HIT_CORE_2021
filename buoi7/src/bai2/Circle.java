package bai2;
import java.lang.Math;
public class Circle implements Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return 3.14*(radius*radius);
    }

    @Override
    public double getPerimeter() {
        return 2*3.14*radius;
    }
}
