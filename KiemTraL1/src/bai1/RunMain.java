package bai1;
import java.util.Scanner;
public class RunMain {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s;
        System.out.print("Nhap vao mot chuoi: ");
        s=sc.nextLine();
        int count=0,sum=0;
        for(int i=0; i<s.length(); i++){
            if (s.charAt(i)>='0' && s.charAt(i)<='9'){
                sum+=(int)s.charAt(i)-48;
                count++;
            }
        }
        System.out.println("Sum= "+sum);
        int tich=1;
        for(int i=1; i<=sum; i++){
            if (sum%i==0){
                tich*=i;
            }
        }
        System.out.println("So ki tu chu so: "+ count);
        System.out.println("Tich cac chu so: "+ tich);
    }
}
