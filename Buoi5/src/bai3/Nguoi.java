package bai3;
import java.util.Scanner;
public class Nguoi {
    protected String hoTen;
    protected String ngaySinh;
    protected String queQuan;

    public Nguoi(String hoTen, String ngaySinh, String queQuan) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
    }
    public Nguoi(){

    }

    public void Nhap(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Ho ten: ");
        hoTen=sc.nextLine();
        System.out.print("Ngay sinh: ");
        ngaySinh=sc.nextLine();
        System.out.print("Que quan: ");
        queQuan=sc.nextLine();
    }
    public void Xuat(){
        System.out.println("Ho ten: "+hoTen);
        System.out.println("Ngay sinh: "+ngaySinh);
        System.out.println("Que quan: "+queQuan);
    }
}
