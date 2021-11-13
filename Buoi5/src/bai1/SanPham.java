package bai1;
import java.util.Scanner;
import java.util.ArrayList;
public class SanPham {
    protected String maSP;
    protected String tenSP;
    protected String tenHangSX;
    protected String ngayNhap;
    Scanner sc = new Scanner(System.in);

    public void setTenHangSX(String tenHangSX) {
        this.tenHangSX = tenHangSX;
    }

    protected String getTenHangSX() {
        return tenHangSX;
    }

    protected void nhap(){
        System.out.print("Ma san pham: ");
        maSP = sc.nextLine();
        System.out.print("Ten san pham: ");
        tenSP = sc.nextLine();
        System.out.print("Ten hang san xuat: ");
        tenHangSX = sc.nextLine();
        System.out.print("Ngay nhap: ");
        ngayNhap = sc.nextLine();
    }
    protected void xuat(){
        System.out.println("Ma san pham: "+maSP);
        System.out.println("Ten san pham: "+tenSP);
        System.out.println("Ten hang san xuat: "+tenHangSX);
        System.out.println("Ngay nhap: "+ngayNhap);
    }
}
