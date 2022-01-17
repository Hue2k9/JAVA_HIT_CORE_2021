package bai1;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;
public class RunMain {
    public static Scanner sc =new Scanner(System.in);
    public static void main(String[] args){
       LopHoc lopHoc=new LopHoc();
       //Nhap
        System.out.print("Nhap ma lop hoc: ");
        lopHoc.setMaLH(sc.nextLine());
        System.out.print("Nhap ten lop hoc: ");
        lopHoc.setTenLH(sc.nextLine());
        System.out.print("Nhap ngay mo: ");
        lopHoc.setNgayMo(sc.nextLine());
        System.out.print("Nhap so luong sinh vien: ");
        lopHoc.setN(sc.nextInt());
        sc.nextLine();
        ArrayList<SinhVien> dsSinhVien = new ArrayList<>(lopHoc.getN());

        for(int i=0; i<lopHoc.getN(); i++){
            SinhVien sv = new SinhVien();
            System.out.println("---Nhap sinh vien thu "+(i+1)+":");
            System.out.print("Nhap ma sinh vien: ");
            sv.setMaSv(sc.nextLine());
            //Nhap ho ten, que quan
            sv.Nhap();
            System.out.print("Nhap nganh hoc: ");
            sv.setNganh(sc.nextLine());
            System.out.print("Nhap khoa hoc: ");
            sv.setKhoaHoc(sc.nextInt());
            sc.nextLine();
            dsSinhVien.add(sv);
        }
        lopHoc.setX(dsSinhVien);
        System.out.print("Nhap giao vien: ");
        lopHoc.setGiaoVien(sc.nextLine());

        //Xuat
        System.out.println("\n\n-----THONG TIN LOP HOC-------");
        System.out.printf("%12s %10s","Ma lop: ",lopHoc.getMaLH());
        System.out.printf("%15s %10s", "Ten lop: ",lopHoc.getTenLH());
        System.out.println();
        System.out.printf("%12s %10s","Giao vien: ",lopHoc.getGiaoVien());
        System.out.printf("%15s %10s","Ngay mo: ",lopHoc.getNgayMo());
        System.out.println();
        System.out.println("Danh sach sinh vien trong lop: ");
        System.out.printf("%10s %20s %12s %12s %12s %12s","Mã SV", "Họ tên", "Ngày sinh", "Quê quán", "Ngành học", "Khoá học");
        System.out.println();
        for(int i=0; i< lopHoc.getN(); i++){
            XuatSV(lopHoc.getX().get(i));
        }
        System.out.println("---------------------------------");
        int countK15=0;
        for(SinhVien x : lopHoc.getX()){
            if (x.getKhoaHoc()==15)
                countK15++;
        }
        if (countK15 == 0) {
            System.out.println("\n * Không có sinh viên khoá 15 nào.");
        } else {
            System.out.println("\n * Có " + countK15 + " sinh viên khoá 15: ");
            System.out.printf("%10s %20s %12s %12s %12s %12s", "Mã SV", "Họ tên", "Ngày sinh", "Quên quán", "Ngành học", "Khoá học.");
            System.out.println();
            for (SinhVien x : lopHoc.getX()) {
                if (x.getKhoaHoc() == 15) {
                    XuatSV(x);
                }
            }
        }
        System.out.println("--------------------------------------------");
        //Sap xep danh sach lop hoc tang dan. in ra
        SapXep(lopHoc.getX());
        System.out.println("\\n * Danh sách sinh viên sau khi sắp xếp là: ");
        System.out.printf("\"%10s %20s %12s %12s %12s %12s\", \"Mã SV\", \"Họ tên\", \"Ngày sinh\", \"Quên quán\", \"Ngành học\", \"Khoá học.\"");
        System.out.println();
        for(SinhVien x : lopHoc.getX()){
            XuatSV(x);
        }
        System.out.println("--------------------------------------------");

    }

    public static void XuatSV(SinhVien sv){

    }
    public static void SapXep(ArrayList<SinhVien> dsSV){
         for(int i=0; i<dsSV.size()-1; i++){
             for(int j=i+1; j<dsSV.size(); j++){
                 if (dsSV.get(i).getKhoaHoc()>dsSV.get(j).getKhoaHoc()){
                     SinhVien temp = dsSV.get(i);
                     dsSV.set(i,dsSV.get(j));
                     dsSV.set(j,temp);
                 }
             }
         }
    }
}
