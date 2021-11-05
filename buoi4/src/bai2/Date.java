package bai2;
import java.util.Scanner;
public class Date {
    private int d;
    private int m;
    private int y;
    Scanner sc =new Scanner(System.in);
    public void Nhap(){
        System.out.print("Ngay: ");
        d = sc.nextInt();
        System.out.print("Thang: ");
        m = sc.nextInt();
        System.out.print("Nam: ");
        y = sc.nextInt();
    }
    public void Xuat(){
        System.out.println("Ngay: "+d+"/"+m+"/"+y);
    }
}
