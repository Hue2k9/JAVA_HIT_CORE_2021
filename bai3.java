import java.util.Scanner;
public class bai3 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int count=0,sum=0;
        for(int i=0; i<s.length(); i++){
            if (s.charAt(i)>='0' && s.charAt(i)<='9'){
                   sum+=(int)s.charAt(i)-48;
                   count++;
            }
        }
        if (count>0){
            System.out.println("true");
            System.out.println("TBC cac chu so: " + (double)sum/count);
        }
        else{
            System.out.println("false");
        }
    }
}
