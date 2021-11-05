package bai5;
import java.util.Scanner;
import java.lang.Math;
public class RunMain {
    public static boolean isPrime(int n){
        if (n<=1)
            return false;
        for(int i=2; i<=Math.sqrt(n); i++)
            if (n%i==0)
                return false;
        return true;
    }
    public static boolean isPrime(long n){
        if (n<=1)
            return false;
        for(int i=2; i<=Math.sqrt(n); i++)
            if (n%i==0)
                return false;
        return true;
    }
    public static boolean isPrime(float n){
        if (n==(int)n){
            if (n<=1)
                return false;
            for(int i=2; i<=Math.sqrt(n); i++)
                if (n%i==0)
                    return false;
            return true;
        }
        else
            return false;
    }
    public static boolean isPrime(double n){
        if (n==(int)n){
            if (n<=1)
                return false;
            for(int i=2; i<=Math.sqrt(n); i++)
                if (n%i==0)
                    return false;
            return true;
        }
        else
            return false;
    }
    public static void main(String[] args){
        System.out.println("===Check prime===");
        System.out.println("5 is "+isPrime(5));
        System.out.println("4l is "+isPrime(4l));
        System.out.println("5.0f is "+isPrime(5.0f));
        System.out.println("7.7392918 is "+isPrime(7.7392918));
    }
}
