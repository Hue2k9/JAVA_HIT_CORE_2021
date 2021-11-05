package bai2;
import java.util.Scanner;
public class RunMain {
    public static void main(String[] args){
        NhanSu x = new NhanSu();
        System.out.println("===Nhap thong tin nhan su=== ");
        x.Nhap();
        System.out.println("Thong tin nhan su: ");
        x.Xuat();
    }
}
