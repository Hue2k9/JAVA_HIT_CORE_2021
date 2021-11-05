package bai3;
import java.util.Scanner;
public class Phieu {
    private String maPhieu;
    private  int n;
    private Hang[] x;
    Scanner sc = new Scanner(System.in);

    void Nhap(){
        System.out.print("Ma phieu: ");
        maPhieu = sc.nextLine();
        System.out.print("Nhap so luong mat hang: ");
        n= sc.nextInt();
        x=new Hang[n];
        for(int i=0; i<n; i++){
            x[i]=new Hang();
            x[i].Nhap();
        }
    }
    void Xuat(){
        int sum=0;
        System.out.println("===Thong tin mat hang===");
        System.out.println("Ma phieu: "+ maPhieu);
        System.out.println("So luong mat hang: "+n);
        for(int i=0; i<n; i++){
            x[i].Xuat();
            sum+=x[i].getDonGia();
        }
        System.out.println("Tong tien cua phieu: "+sum);
    }
}
