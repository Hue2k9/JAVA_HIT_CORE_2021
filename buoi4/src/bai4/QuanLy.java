package bai4;
import java.util.Scanner;
public class QuanLy {
    private String Maql;
    private String hoTen;
    Scanner sc=new Scanner(System.in);
    public void Nhap(){
        System.out.print("Nhap ma ql: ");
        Maql=sc.nextLine();
        System.out.println("Ho ten: ");
        hoTen=sc.nextLine();
    }
    public void Xuat(){
        System.out.println("Ma ql: "+Maql);
        System.out.println("Ho ten: "+hoTen);
    }
}
