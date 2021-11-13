package bai2;
import java.util.ArrayList;
import java.util.Scanner;

public class Phieu {
    private String maPhieu;
    private String tenPhieu;
    private DateTim a = new DateTim();
    private int n;

    Scanner sc = new Scanner(System.in);
    ArrayList<SanPham> x = new ArrayList<>();

    private int thanhTien=0;

    public Phieu() {
    }

    public Phieu(String maPhieu, String tenPhieu, DateTim a, int n, ArrayList<SanPham> x, Scanner sc, int thanhTien) {
        this.maPhieu = maPhieu;
        this.tenPhieu = tenPhieu;
        this.a = a;
        this.n = n;
        this.x = x;
        this.sc = sc;
        this.thanhTien = thanhTien;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getTenPhieu() {
        return tenPhieu;
    }

    public void setTenPhieu(String tenPhieu) {
        this.tenPhieu = tenPhieu;
    }

    public DateTim getA() {
        return a;
    }

    public void setA(DateTim a) {
        this.a = a;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public ArrayList<SanPham> getX() {
        return x;
    }

    public void setX(ArrayList<SanPham> x) {
        this.x = x;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public void InputPhieu(){
        System.out.print("Ma phieu: ");
        maPhieu=sc.nextLine();
        System.out.print("Ten phieu: ");
        tenPhieu=sc.nextLine();
        a.InputDate();
        System.out.print("Nhap so luong san pham: ");
        n=sc.nextInt();
        for(int i=0; i<n; i++){
            SanPham sp = new SanPham();
            sp.InputSP();
            x.add(sp);
        }
    }
    public void OutputPhieu(){
        System.out.println("===THONG TIN PHIEU===");
        System.out.println("Ma phieu: "+maPhieu);
        System.out.println("Ten phieu: "+tenPhieu+"\n");
        //a.OutputDate();
        for(int i=0; i<n; i++){
            x.get(i).OutputSP();
            thanhTien+=x.get(i).getThanhTien();
        }
        System.out.println("Tong thanh tien: "+thanhTien);
    }

}
