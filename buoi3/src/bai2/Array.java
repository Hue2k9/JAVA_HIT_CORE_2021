package bai2;
import java.util.Scanner;
import java.lang.Math;
public class Array {
     private int n;
     private int[] a;
     Scanner sc=new Scanner(System.in);
     //Constructor
     public Array(){

     }
   public Array(int[] a, int n){
        this.a =a;
        this.n=n;
     }
   //getter, setter
     public void setA(int[] a) {
        this.a = a;
    }
     public int[] getA() {
        return a;
    }
     public void setN(int n){
         this.n=n;
     }
     public int getN(){
         return n;
     }
     public void InputData(){
         System.out.print("\nNhap so phan tu cua mang: ");
         n=sc.nextInt();
         a=new int[n];
         for(int i=0; i<n; i++){
             System.out.print("a["+i+"]= ");
             a[i]=sc.nextInt();
         }
     }
     public void Show(){
         for(int i=0; i<n; i++){
             System.out.print(a[i]+" ");
         }
     }
     public int Sum(){
         int sum=0;
         for(int i=0; i<n; i++){
             sum+=a[i];
         }
         return sum;
     }
     public void Filter(boolean flag){
        if (flag==true){
            for(int i=0; i<n; i++){
                if (a[i]%2==0)
                    System.out.print(a[i]+" ");
            }
        }
        else{
            for(int i=0; i<n; i++){
                if (a[i] % 2!=0)
                    System.out.print(a[i]+" ");
            }
        }
     }
}
