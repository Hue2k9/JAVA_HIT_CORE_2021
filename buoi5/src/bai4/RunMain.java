package bai4;

public class RunMain {
    public static void main(String[] args){
       Sum<Integer> s1 = new Sum<>(1,2);
       Sum<Long> s2 = new Sum<>(3l,4l);
       Sum<Float> s3 = new Sum<>(1f,2f);
       Sum<Double> s4 = new Sum<>(3.4444,9.7522);

       System.out.println("Tong (int): "+(s1.getA()+s1.getB()));
       System.out.println("Tong (long): "+(s2.getA()+s2.getB()));
       System.out.println("Tong (float): "+(s3.getA()+s3.getB()));
       System.out.println("Tong (double): "+(s4.getA()+s4.getB()));
    }
}
