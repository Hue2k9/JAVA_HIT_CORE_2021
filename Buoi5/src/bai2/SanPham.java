package bai2;
import java.util.Scanner;
public class SanPham {
    private String maSP;
    private String tenSP;
    private int soLuong;
    private int donGia;
    Scanner sc=new Scanner(System.in);

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, int soLuong, int donGia, Scanner sc) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.sc = sc;
    }

    public int getThanhTien(){
        return soLuong*donGia;
    }

    public void InputSP(){
        System.out.print("Ma san pham: ");
        maSP=sc.nextLine();
        System.out.print("Ten san pham: ");
        tenSP=sc.nextLine();
        System.out.print("So luong: ");
        soLuong=sc.nextInt();
        System.out.print("Don gia: ");
        donGia=sc.nextInt();
    }
    public void OutputSP(){
        System.out.println("Ma san pham: "+maSP);
        System.out.println("Ten san pham: "+tenSP);
        System.out.println("So luong: "+soLuong);
        System.out.println("Don gia: "+donGia);
        System.out.println();
    }
}
