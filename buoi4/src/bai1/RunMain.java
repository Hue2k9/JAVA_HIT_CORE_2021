package bai1;
import java.sql.SQLOutput;
import java.util.Scanner;
public class RunMain {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n: ");
        int n = sc.nextInt();
        Sach[] books = new Sach[n];
        for(int i=0; i<n; i++){
            books[i]=new Sach();
            System.out.println("Nhap sach thu "+(i+1));
             books[i].Nhap();
        }
        System.out.println("====Thong tin sach===");
        for(int i=0; i<n; i++) {
            System.out.println("Sach thu "+(i+1));
            books[i].Xuat();
        }

    }
}
