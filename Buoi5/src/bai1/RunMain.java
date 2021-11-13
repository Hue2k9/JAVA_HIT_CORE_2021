package bai1;
import java.util.Scanner;
import java.util.ArrayList;
public class RunMain {
    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so nguyen duong n: ");
        n=sc.nextInt();
        ArrayList<DieuHoa> dieuHoas = new ArrayList<>(n);
        System.out.println("Nhap thong tin san pham");

        for(int i=0; i<n; i++){
            DieuHoa dh = new DieuHoa();
            dh.nhap();
            dieuHoas.add(dh);
        }
        //Hien thi ds dieu hoa co hang sx Electrolux
        int count=0;
        for(int i=0; i<n; i++){
            if (dieuHoas.get(i).getTenHangSX().equalsIgnoreCase("Electrolux")==true){
                count++;
                if (count==1)
                    System.out.println("===DS dieu hoa hang sx Electrolux===");
                    dieuHoas.get(i).xuat();
            }
        }

        if (count==0){
            System.out.println("Khong co san pham hang Electrolux");
        }
            //Tim min
        int min=dieuHoas.get(0).getGiaBan();
            for(int i=1; i<n; i++){
                if (dieuHoas.get(i).getGiaBan()<min)
                    min=dieuHoas.get(i).getGiaBan();
            }
            System.out.println("===DS dieu hoa hang co gia ban thap nhat===");
            for(int i=0; i<n; i++){
                if (dieuHoas.get(i).getGiaBan()==min )
                    dieuHoas.get(i).xuat();
            }
    }
}
