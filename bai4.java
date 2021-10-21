import java.util.Scanner;
public class bai4 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap vao 1 chuoi: ");
        String s=sc.nextLine();
        //Xoa khoang trang o 2 dau
        s=s.trim();
        //Giua cac tu chi co 1 khoang trang
        for(int i=0; i<s.length(); i++){
            s=s.replace("  "," ");
            i++;
        }

        //Bo ky tu chu so
        s=s.replace("[0-9]","");
        //Chuyen chu thuong thanh hoa
        String s1="";
        s1+=s.charAt(0);
        if (s.charAt(0)>='a' && s.charAt(0)<='z'){
            s1=s1.toUpperCase();
        }
        for(int i=1; i<s.length(); i++){
            String k="";
            k+=s.charAt(i);
            if (s.charAt(i-1)==' '){
                k=k.toUpperCase();
            }
            s1+=k;
        }
        System.out.print(s1);
    }
}
