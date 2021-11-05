package bai3;
import java.util.Scanner;
public class Hang {
    private String maHang;
    private String tenHang;
    private int donGia;
    Scanner sc= new Scanner(System.in);

    public int getDonGia() {
        return donGia;
    }

    public void Nhap(){
        System.out.print("Ma hang: ");
        maHang=sc.nextLine();
        System.out.print("Ten hang: ");
        tenHang=sc.nextLine();
        System.out.print("Don gia: ");
        donGia=sc.nextInt();
    }
    public void Xuat(){
        System.out.println("Ma hang: "+maHang);
        System.out.println("Ten hang: "+tenHang);
        System.out.println("Don gia: "+donGia+"\n");
    }
}
