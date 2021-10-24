import java.util.Scanner;
import java.lang.Math;
public class bai2 {
    private static int n;
    public static void InputArr(int[] a, int n){
        Scanner sc=new Scanner(System.in);
        for(int i=0; i<n; i++){
            System.out.print("a["+i+"]= ");
            a[i] = sc.nextInt();
        }
    }
    public static void OutputArr(int[] a, int n){
        for(int i=0; i<n; i++){
            System.out.print(a[i]+" ");
        }
    }
    public static void InsertArr(int[] a, int n, int x,int vt){
        for(int i=n-1; i>=vt; i--)
            a[i]=a[i-1];
            a[vt]=x;
            n++;
    }
    public static void DeleteArr(int[] a, int vt){
        for(int i=vt; i<n-1; i++)
            a[i]=a[i+1];
            n--;
    }
    public static void Reverse(int[] a, int n){
        System.out.println("Mang sau khi dao nguoc: ");
        for(int i=n-1; i>=0; i--){
            System.out.print(a[i]+" ");
        }
    }
    public static void Divide(int[] a, int n){
        int count=0;
        System.out.println("a[1]= "+a[1]);
        for(int i=0; i<n; i++){
            if (a[i]%a[1]==0 && a[i]!=a[1]){
                count++;
            }
        }
        if (count!=0){
            System.out.print("Cac phan tu chia het cho a[1]: ");
            for(int i=0; i<n; i++){
                if (a[i]%a[1]==0 && a[i]!=a[1]){
                    System.out.print(a[i]+" ");
                }
            }
        }
        else{
            System.out.println("Khong co phan tu nao chia het cho a[1] trong mang");
        }
    }
    public static int Prime(int b){
        if (b<=1)
            return 0;
        for(int i=2; i<=Math.sqrt(b); i++)
            if (b%i==0)
                return 0;
        return 1;
    }
    public static void SumPrimes(int[] a, int n){
        int sum=0,count=0;
        for(int i=0; i<n; i++){
            if (Prime(a[i])==1){
                sum+=a[i];
                count++;
            }
        }
        if (count!=0){
            System.out.println("Tong cac so nguyen to trong mang: "+sum);
        }
        else{
            System.out.println("Khong co SNT nao trong mang");
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int choose;
        System.out.print("Nhap so phan tu trong mang: ");
        n=sc.nextInt();
        int[] a=new int[n];
        int x,k,m;

       do{
           System.out.print("\nNhap lua chon: ");
           choose=sc.nextInt();
           switch (choose){
               case 1:{
                   InputArr(a,n);
                   break;
               }
               case 2:{
                   System.out.print("Mang vua nhap la: ");
                   OutputArr(a,n);
                   break;
               }
               case 3:{
                   System.out.print("\nNhap phan tu muon them: ");
                   x=sc.nextInt();
                   System.out.print("\nNhap vi tri: ");
                   k=sc.nextInt();
                   InsertArr(a,n,x,k);
                   break;
               }
               case 4:{
                   System.out.print("\nNhap vi tri muon xoa: ");
                   m=sc.nextInt();
                   DeleteArr(a,m);
                   break;
               }
               case 5:{
                   Reverse(a,n);
                   break;
               }
               case 6:{
                   Divide(a,n);
                   break;
               }
               case 7:{
                   SumPrimes(a,n);
                   break;
               }
               case 8:{
                   return;
               }
           }
       }   while(choose!=8);
    }
}
