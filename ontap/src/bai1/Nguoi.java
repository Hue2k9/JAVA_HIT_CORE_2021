package bai1;
import java.util.Scanner;
public class Nguoi {
    protected String hoTen;
    protected String ngaySinh;
    protected String queQuan;

    public Nguoi() {
    }

    public Nguoi(String hoTen, String ngaySinh, String queQuan) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
    }

    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho ten: ");
        hoTen= sc.nextLine();
        System.out.print("Nhap ngay sinh: ");
        ngaySinh=sc.nextLine();
        System.out.print("Que quan: ");
        queQuan=sc.nextLine();
    }
    public void Xuat(){
        System.out.printf("%20s %12s %12s", hoTen, ngaySinh, queQuan);
/*    String str= "";
    str+=String.format("%20s %12s %12s", hoTen,ngaySinh,queQuan);
    return str;
*/
    }
}
