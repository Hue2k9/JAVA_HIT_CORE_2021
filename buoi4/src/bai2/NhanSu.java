package bai2;
import java.util.Scanner;
public class NhanSu {
    private String maNhanSu;
    private String hoTen;
    private Date date = new Date();
    Scanner sc = new Scanner(System.in);
    public void Nhap(){
        System.out.print("Ma nhan su: ");
        maNhanSu = sc.nextLine();
        System.out.print("Ho ten: ");
        hoTen = sc.nextLine();
        date.Nhap();
    }
    public void Xuat(){
        System.out.println("Ma nhan su: "+maNhanSu);
        System.out.println("Ho ten: "+hoTen);
        date.Xuat();
    }
}
