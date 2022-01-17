package QuanLyBanHang;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
public class NhanVien implements Comparable<NhanVien>{
    private String idStaff;
    private String name;
    private int age;
    private String gender;
    private String address;
    private int totalDays; //Tổng số ngày làm việc
    private int phoneNumber;
    private ArrayList<String> listStaff = new ArrayList<>();

    public NhanVien(String idStaff, String name, int age, String gender, String address, int totalDays, int phoneNumber) {
        this.idStaff = idStaff;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.totalDays = totalDays;
        this.phoneNumber = phoneNumber;

    }

    public NhanVien(ArrayList<String> listStaff) {
        this.listStaff = listStaff;
    }

    public NhanVien() {
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public ArrayList<String> getListStaff() {
        return listStaff;
    }

    public void setListStaff(ArrayList<String> listStaff) {
        this.listStaff = listStaff;
    }

    public void input(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Staff name: ");
        name=sc.nextLine();
        System.out.print("Id staff: ");
        idStaff=sc.nextLine();
        System.out.print("Age: ");
        age=sc.nextInt();
        sc.nextLine();
        System.out.print("Genger: ");
        gender=sc.nextLine();
        System.out.print("Address: ");
        address=sc.nextLine();
        System.out.print("Total of working days: ");
        totalDays=sc.nextInt();
        sc.nextLine();
        System.out.println("Phone number: ");
        phoneNumber=sc.nextInt();
        sc.nextLine();
    }

    public void output(){
        System.out.println("Staff name: "+getName());
        System.out.println("Id staff: "+getIdStaff());
        System.out.println("Age: "+getAge());
        System.out.println("Gender: "+getGender());
        System.out.println("Address: "+getAddress());
        System.out.println("Total of working days: "+getTotalDays());
        System.out.println("Salary: "+getTotalDays()*500000+" VND");
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "idStaff='" + idStaff + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", totalDays=" + totalDays +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    @Override
    public int compareTo(NhanVien o) {
        return 0;
    }
}
