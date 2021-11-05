package bai4;
import java.sql.SQLOutput;
import java.util.Scanner;
public class PhongMay {
    private String maPhong;
    private String tenPhong;
    private double dienTich;
    private QuanLy x=new QuanLy();
    private May[] y;
    private int n;
    Scanner sc=new Scanner(System.in);
    public void Nhap(){
        System.out.print("Ma phong: ");
        maPhong=sc.nextLine();
        System.out.print("Ten phong: ");
        tenPhong=sc.nextLine();
        System.out.print("Dien tich: ");
        dienTich=sc.nextDouble();
        System.out.print("So may trong phong: ");
        n=sc.nextInt();
        y=new May[n];
        for(int i=0; i<n; i++){
            System.out.println("May thu "+(i+1));
            y[i]=new May();
            y[i].Nhap();
        }
    }
    public void Xuat(){
        System.out.println("===Thong tin phong may===");
        System.out.println("Ten phong: "+tenPhong);
        System.out.println("Ma phong: "+maPhong);
        System.out.println("Dien tich: "+dienTich);
        System.out.println("So may trong phong: "+n);
        for(int i=0; i<n; i++){
            System.out.println("May thu "+(i+1));
            y[i].Xuat();
        }
    }
}
