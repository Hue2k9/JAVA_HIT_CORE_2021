import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n>0)
            System.out.print("n is a positive number");
        else if (n<0)
            System.out.print("n is a negative number");
        else
            System.out.print("n is equal to 0");
    }
}