package javaTest;



class Circle{
    private double radius;

    public Circle(double r){
        radius = r;
    }
    
    public Circle(){

    }

    public double getRadius(){
        return radius;
    }

    public void setRadius(double r){
        radius = r;
    }

    public double getArea(){
        return 3.14 * radius * radius;
    }
}



class Cylinder extends Circle{
    private double height;

    public Cylinder(double r,double h){
        super(r);
        height = h;
    }

    public double getHeight(){
        return height;
    }

    public void setHeight(double h){
        height = h;
    }

    public double getArea(){
        return 2 * super.getArea() + 2 * 3.14 * getRadius() * height;
    }

    public double getVolume(){
        return super.getArea() * height;
    }
}


public class test {
	public static void main(String args[]){
        Cylinder cy = new Cylinder(5,10);
        System.out.println(cy.getVolume());
    }

}
