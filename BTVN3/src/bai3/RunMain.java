package bai3;
import java.util.Random;
public class RunMain {
    public static void main(String[] args){
        Guns DiepBeDe = new Guns();
        Guns DoanXinhGai = new Guns();
        Random rand = new Random();

        DiepBeDe.setWeaponName("Ak47");
        DiepBeDe.setAmmoNumber(100);
        DoanXinhGai.setWeaponName("APS95");
        DoanXinhGai.setAmmoNumber(100);

        while(DiepBeDe.getAmmoNumber()>0 && DoanXinhGai.getAmmoNumber()>0){
            DiepBeDe.Shoot(rand.nextInt(10)+1);
            DoanXinhGai.Shoot(rand.nextInt(10)+1);
            if (DiepBeDe.getAmmoNumber()<=0){
                System.out.print("\nDoan xinh gai thang");
                break;
            }
            else if (DoanXinhGai.getAmmoNumber()<=0){
                System.out.print("\nDiep be de thang");
                break;
            }
            else if (DiepBeDe.getAmmoNumber()==0 && DoanXinhGai.getAmmoNumber()==0){
                DiepBeDe.Load(rand.nextInt(10)+1);
                DoanXinhGai.Load(rand.nextInt(10)+1);
            }
            else {
                System.out.println("Continue: " + DiepBeDe.getAmmoNumber() + " - " + DoanXinhGai.getAmmoNumber());
            }
            DiepBeDe.Load(rand.nextInt(10)+1);
            DoanXinhGai.Load(rand.nextInt(10)+1);
        }
    }
}
