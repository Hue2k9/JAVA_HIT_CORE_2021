package bai2;
import java.util.Scanner;
public class DateTime {
    private int ngay;
    private int thang;
    private int nam;

    public DateTime() {
    }

    public DateTime(int ngay, int thang, int nam) {
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }

    public void InputDate(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ngày: ");
        ngay = sc.nextInt();
        System.out.print("Nhập tháng: ");
        thang = sc.nextInt();
        System.out.print("Nhập năm: ");
        nam = sc.nextInt();
    }
    public String OutputDate(){
        return ngay + "/" + thang + "/" + nam;
    }
}
