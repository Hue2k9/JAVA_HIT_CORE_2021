package bai4;

public class Sum <N>{
    private N A;
    private N B;

    public Sum(N a, N b) {
        A = a;
        B = b;
    }

    public Sum() {
    }

    public N getA() {
        return A;
    }

    public void setA(N a) {
        A = a;
    }

    public N getB() {
        return B;
    }

    public void setB(N b) {
        B = b;
    }

}
