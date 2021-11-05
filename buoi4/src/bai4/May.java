package bai4;
import java.util.Scanner;
public class May {
    private String maMay;
    private String kieuMay;
    private String tinhTrang;
    Scanner sc=new Scanner(System.in);
    public void Nhap(){
        System.out.print("Ma may: ");
        maMay=sc.nextLine();
        System.out.print("Kieu may: ");
        kieuMay=sc.nextLine();
        System.out.print("Tinh trang: ");
        tinhTrang=sc.nextLine();
    }
    public void Xuat(){
        System.out.println("Ma may: "+maMay);
        System.out.println("Kieu may: "+kieuMay);
        System.out.println("Tinh trang: "+tinhTrang+"\n");
    }
}
