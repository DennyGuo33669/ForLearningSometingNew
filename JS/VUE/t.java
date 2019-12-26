// public class Cube{ // 创建Cube类
//     private double length; // 定义私有三个变量
//     private double width;
//     private double height;
//     public Cube(double l, double w, double h){ // 创建构造方法
//         length = l;
//         width = w;
//         height = h;
//     }

//     public double getLength(){ // 声明获得各数据成员方法
//         return length;
//     }

//     public double getWidth(){ 
//         return width;
//     }

//     public double getHeight(){ 
//         return height;
//     }

//     public void setLength(double l){ // 声明修改各数据成员方法
//         length = l;
//     }

//     public void setWidth(double w){
//         width = w;
//     }

//     public void setHeight(double h){
//         height = h;
//     }

//     public double getVolume(){ // 声明getVolume方法
//         return length*width*height;
//     }

//     public static void main(String args[]){ //main方法
//         Cube cube = new Cube(1,1,1) // 生成实例对象cube
//         System.out.println("体积" + cube.getVolume()); // 调用println方法
//     }
// }


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

    public void setRadius(){
        radius = r;
    }

    public double getArea(){
        return 3.14 * radius * radius;
    }
}

class Cylinder extends Circle{
    private double height;

    public Cylinder(double h){
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

public class Test(){
    public static void main(String args[]){
        Cylinder cy = new Cylinder(5,10);
        System.out.println(cy.getVolume());
    }
}