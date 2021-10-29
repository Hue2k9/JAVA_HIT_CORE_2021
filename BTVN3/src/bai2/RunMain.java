package bai2;
public class RunMain {
    public static void main(String[] args){
       Array arr1 = new Array();
       Array arr2 = new Array();
       arr1.InputData();
       arr2.InputData();
       double k=(double)arr1.Sum()/arr1.getN();
       double b=(double)arr2.Sum()/arr2.getN();
       if (k>b)
           System.out.print("Arr1 lon hon arr2");
       else if (b>k)
           System.out.print("Arr2 lon hon arr1");
       else
           System.out.print("Bye");
    }
}
