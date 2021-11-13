package bai3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class LopHoc {
    private String maLopHoc;
    private String tenLopHoc;
    private String ngayMo;
    private String giaoVien;
    private int n;
    ArrayList<SinhVien> x = new ArrayList<>(n);

    public LopHoc() {
    }

    public LopHoc(String maLopHoc, String tenLopHoc, String ngayMo, String giaoVien, int n, ArrayList<SinhVien> x) {
        this.maLopHoc = maLopHoc;
        this.tenLopHoc = tenLopHoc;
        this.ngayMo = ngayMo;
        this.giaoVien = giaoVien;
        this.n = n;
        this.x = x;
    }

    public void Nhap(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Ma lop hoc: ");
        maLopHoc=sc.nextLine();
        System.out.print("Ten lop hoc: ");
        tenLopHoc=sc.nextLine();
        System.out.print("Ngay mo: ");
        ngayMo=sc.nextLine();
        System.out.print("Ten giao vien: ");
        giaoVien=sc.nextLine();
        System.out.print("So luong sinh vien: ");
        n=sc.nextInt();
        for(int i=0; i<n; i++){
            SinhVien sv = new SinhVien();
            System.out.println("Nhap sv thu "+(i+1));
            sv.Nhap();
            x.add(sv);
        }
    }
    public int getSvK15(){
        int count=0;
        for(int i=0; i<n; i++){
            if (x.get(i).getKhoaHoc()==15)
                count++;
        }
        return count;
    }
    public void Sort(){
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if (x.get(i).getKhoaHoc()>x.get(j).getKhoaHoc())
                    Collections.swap(x,i,j);
            }
        }
    }
    public void SortSV(){
        Sort();
        for(int i=0; i<n; i++){
            System.out.println("STT "+(i+1));
            x.get(i).Xuat();
        }
    }
    public void Xuat(){
        System.out.println("Ma lop: "+maLopHoc);
        System.out.println("Ten lop: "+tenLopHoc);
        System.out.println("Ngay mo: "+ngayMo);
        System.out.println("Ten giao vien: "+giaoVien);
        System.out.println("So luong sinh vien: "+ n);
        int count=0;
        for(int i=0; i<n; i++){
            System.out.println("SV thu "+(i+1));
            x.get(i).Xuat();
        }
    }
}
