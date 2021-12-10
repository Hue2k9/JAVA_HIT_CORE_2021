package bai1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DanhSachSinhVien {
    private ArrayList<SinhVien> danhSach;
    Scanner sc=new Scanner(System.in);
    public DanhSachSinhVien(ArrayList<SinhVien> danhSach) {
        this.danhSach = danhSach;
    }

    public DanhSachSinhVien() {
        this.danhSach=new ArrayList<SinhVien>();
    }
    public void themSinhVien(SinhVien sv){
        this.danhSach.add(sv);
    }
    public void HienThiDanhSachSV(){
        for (SinhVien sv: danhSach) {
            System.out.println(sv);
        }
    }
    //Kiem tra danh sach sinh vien co rong hay khong
    public boolean kiemTraDanhSachRong(){
        return this.danhSach.isEmpty();
    }
    //Lay ra so luong sinh vien
    public int laySoLuongSV(){
        return this.danhSach.size();
    }
    //lam rong danh sach sinh vien
    public void lamRongDanhSach(){
       this.danhSach.removeAll(danhSach);
    }
    //==========
    //Kiem tra sinh vien co ton tai hay khong. Dua tren ma sinh vien
    public boolean kiemTraTonTai(SinhVien sv){
        return this.danhSach.contains(sv);
    }
    //Xoa mot sinh vien ra khoi danh sach
    public boolean XoaMotSinhVien(SinhVien sv){
        return this.danhSach.remove(sv);
    }
    //Tim kiem tat ca sinh vien dua tren ten duoc nhap tu ban phim
    public void timSinhVien(String name){
       for (SinhVien sinhVien : danhSach){
           if (sinhVien.getHoVaTen().indexOf(name)>=0){
               System.out.println(sinhVien);
           }
        }
    }
    //Sap xep danh sach sinh vien giam dan theo diem
    public void sapXepSinhVienGiamDan(){
        Collections.sort(this.danhSach, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien sv1, SinhVien sv2) {
                if (sv1.getDiemTB()<sv2.getDiemTB())
                    return -1;
                else if(sv1.getDiemTB()>sv2.getDiemTB()){
                    return 1;
                }
                else
                    return 0;
            }
        });
    }
}
