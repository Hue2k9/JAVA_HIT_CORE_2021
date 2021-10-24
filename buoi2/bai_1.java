import java.util.Scanner;
public class bai_1 {
    public static int Max(int a, int b, int c){
        int max=a;
        if (b>max)
            max=b;
        if (c>max)
            max=c;
        return max;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap 3 so nguyen duong: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.print("Max= "+ Max(a,b,c));
    }
}
