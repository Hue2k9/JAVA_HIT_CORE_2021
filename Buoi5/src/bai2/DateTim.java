package bai2;
import java.util.Scanner;

public class DateTim {
    private int ngay;
    private int thang;
    private int nam;
    Scanner sc = new Scanner(System.in);


    public int getNgay() {
        return ngay;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public DateTim(){}

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public DateTim(int ngay, int thang, int nam, Scanner sc) {
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
        this.sc = sc;
    }

    public void InputDate(){
        System.out.print("Nhap ngay: ");
        ngay=sc.nextInt();
        System.out.print("Thang: ");
        thang=sc.nextInt();
        System.out.print("Nam: ");
        nam=sc.nextInt();
    }
    public void OutputDate(){
        System.out.println("Ngay "+ngay+"/"+thang+"/"+nam);
    }
}
