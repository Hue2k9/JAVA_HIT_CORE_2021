package bai3;

public class Guns {
    private String weaponName;
    private int ammoNumber;

    public Guns(){

    }
    public Guns(String weaponName, int ammoNumber){
        this.weaponName = weaponName;
        this.ammoNumber = ammoNumber;
    }
    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }
    public String getWeaponName() {
        return weaponName;
    }
    public void setAmmoNumber(int ammoNumber) {
        this.ammoNumber = ammoNumber;
    }
    public int getAmmoNumber() {
        return ammoNumber;
    }
    public int Load(int x){
        return ammoNumber+x;
    }

    public void Shoot(int x){
        this.ammoNumber -= x;
        if (this.ammoNumber<=0)
            System.out.println("Het dan");
    }
}
