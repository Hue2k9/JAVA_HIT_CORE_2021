package bai3;

public class RunMain {
    public static void main(String[] args){
        LopHoc lop=new LopHoc();
        lop.Nhap();
        System.out.println("===Thong tin lop hoc===");
        lop.Xuat();
        System.out.println("So luong sv K15: "+lop.getSvK15());
        System.out.println();
        System.out.println("===Danh sach sv sau khi sap xep===");
        lop.SortSV();
    }
}
