package bai1;
import java.util.Scanner;
public class DieuHoa extends SanPham{
    private int congSuat;
    private int giaBan;
    Scanner sc = new Scanner(System.in);

    public DieuHoa() {
    }

    public DieuHoa(int congSuat, int giaBan, Scanner sc) {
        this.congSuat = congSuat;
        this.giaBan = giaBan;
        this.sc = sc;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void nhap(){
        super.nhap();
        System.out.print("Cong suat: ");
        congSuat=sc.nextInt();
        System.out.print("Gia ban: ");
        giaBan=sc.nextInt();
    }

    public void xuat(){
        super.xuat();
        System.out.println("Cong suat: "+congSuat);
        System.out.println("Gia ban: "+giaBan);
        System.out.println();
    }
}
