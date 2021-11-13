package bai3;
import java.util.Scanner;
public class SinhVien extends Nguoi {
    private String maSV;
    private String nganh;
    private int khoaHoc;
    SinhVien(){};

    public SinhVien(String hoTen, String ngaySinh, String queQuan, String maSV, String nganh, int khoaHoc) {
        super(hoTen, ngaySinh, queQuan);
        this.maSV = maSV;
        this.nganh = nganh;
        this.khoaHoc = khoaHoc;
    }

    public SinhVien(String maSV, String nganh, int khoaHoc) {
        this.maSV = maSV;
        this.nganh = nganh;
        this.khoaHoc = khoaHoc;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public void setKhoaHoc(int khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getNganh() {
        return nganh;
    }

    public int getKhoaHoc() {
        return khoaHoc;
    }
    public void Nhap(){
        super.Nhap();
        Scanner sc= new Scanner(System.in);
        System.out.print("Ma sinh vien: ");
        maSV=sc.nextLine();
        System.out.print("Nganh: ");
        nganh=sc.nextLine();
        System.out.print("Khoa hoc: ");
        khoaHoc=sc.nextInt();
    }
    public void Xuat(){
        super.Xuat();
        System.out.println("Ma sinh vien: "+maSV);
        System.out.println("Nganh: "+nganh);
        System.out.println("Khoa hoc: "+khoaHoc);
        System.out.println();
    }

}
