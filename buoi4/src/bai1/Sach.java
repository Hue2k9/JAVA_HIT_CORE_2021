package bai1;
import java.util.Scanner;
public class Sach {
    private String maSach;
    private String tenSach;
    private String NXB;
    private int soTrang;
    private int giaTien;
    Scanner sc = new Scanner(System.in);
    public void Nhap(){
        System.out.print("Nhap ma sach: ");
        maSach=sc.nextLine();
        System.out.print("Nhap ten sach: ");
        tenSach=sc.nextLine();
        System.out.print("Nha xuat ban: ");
        NXB = sc.nextLine();
        System.out.print("So trang: ");
        soTrang = sc.nextInt();
        System.out.print("Gia tien: ");
        giaTien = sc.nextInt();
    }
    public void Xuat(){
        System.out.println("Ma sach: "+maSach);
        System.out.println("Ten sach: "+tenSach);
        System.out.println("NXB: "+NXB);
        System.out.println("So trang: "+soTrang);
        System.out.println("Gia tien: "+giaTien+"\n");
    }
}
