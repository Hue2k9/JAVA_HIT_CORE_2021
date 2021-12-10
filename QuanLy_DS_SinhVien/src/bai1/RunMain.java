package bai1;
import java.sql.SQLOutput;
import java.util.Scanner;
public class RunMain {
    public static void main(String[] args){
       Scanner sc=new Scanner(System.in);
       int choose;
       DanhSachSinhVien ds =new DanhSachSinhVien();
       do{
           System.out.println("========MENU========");
           System.out.println("" +
                   "1. Thêm sinh viên vào danh sách\n" +
                   "    2. Hien thi sinh vien\n" +
                   "    3. Kiểm tra danh sách có rỗng hay không\n" +
                   "    4. Lấy ra số lượng sinh viên trong ds\n" +
                   "    5. Làm rỗng ds sinh viên\n" +
                   "    6. Xóa một sinh viên ra khỏi danh sách dựa trên MSV\n" +
                   "    7. Kiểm tra sv có tồn tại trong ds hay không, dựa trên\n" +
                   "      sv\n" +
                   "    8. Tìm kiếm một sinh viên dựa trên tên\n" +
                   "    9. Xuất ra danh sách sinh viên có điểm từ cao đến thấp" +
                   "0. Thoát");
           System.out.print("Nhập lựa chọn: ");
           choose=sc.nextInt();
           sc.nextLine();
           switch (choose){
               case 1:{
                   System.out.print("Nhập mã sinh viên: ");
                   String maSV=sc.nextLine();
                   System.out.print("Họ và tên: ");
                   String hoVaTen=sc.nextLine();
                   System.out.print("Năm sinh: ");
                   int namSinh=sc.nextInt();
                   System.out.print("Điểm: ");
                   double diem=sc.nextDouble();
                   SinhVien sv=new SinhVien(maSV,hoVaTen,namSinh,diem);
                   ds.themSinhVien(sv);
                   break;
               }
               case 2:{
                   ds.HienThiDanhSachSV();
                   break;
               }
               case 3:{
                   System.out.println("Danh sach rong? "+ds.kiemTraDanhSachRong());
                   break;
               }
               case 4:{
                   System.out.println("So luong sv: "+ds.laySoLuongSV());
                   break;
               }
               case 5:{
                   ds.lamRongDanhSach();
                   break;
               }
               case 6:{
                   System.out.println("Nhap ma sinh vien: ");
                   String maSinhVien=sc.nextLine();
                   SinhVien sv=new SinhVien(maSinhVien);
                   System.out.println("Ma sv co ton tai?"+ds.kiemTraTonTai(sv));
                   break;
               }
               case 7:{
                   System.out.println("Nhap ma sinh vien: ");
                   String maSinhVien=sc.nextLine();
                   SinhVien sv=new SinhVien(maSinhVien);
                   ds.XoaMotSinhVien(sv);
                   break;
               }
               case 8:{
                   System.out.print("Nhap ho ten sv: ");
                   String hoTen=sc.nextLine();
                   System.out.println("Ket qua tim kiem: ");
                   ds.timSinhVien(hoTen);
                   break;
               }
               case 9:{
                   ds.sapXepSinhVienGiamDan();
                   break;
               }
               case 0:{
                   return;
               }
           }
       } while (choose!=0);
    }
}
