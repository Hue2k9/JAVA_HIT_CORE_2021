package QuanLyBanHang;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.Formatter;
import java.util.regex.Pattern;

public class NhanVien implements Comparable<NhanVien>{
    private String idStaff;
    private String name;
    private int age;
    private String gender;
    private String address;
    private int totalDays; //Tổng số ngày làm việc
    private String phoneNumber;
    private int salary;
    private ArrayList<String> listStaff = new ArrayList<>();

    public NhanVien(String idStaff, String name, int age, String gender, String address, int totalDays, String phoneNumber) {
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

    public int getSalary() {
        return getTotalDays()*500000;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
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
        String regexPhone = "^[0-9\\-\\+]{9,15}$";
        System.out.print("Phone number: ");
        phoneNumber=sc.nextLine();
        while(!Pattern.matches(regexPhone,phoneNumber)){
            System.out.println("Phone number does not exist!");
            System.out.print("Phone number: ");
            phoneNumber=sc.nextLine();
        }
    }

    public void output(){
        System.out.printf("%-25s%-15s%-10d%-25s%-10d%-20d\n",getName(),getIdStaff(),getAge(),getAddress(),getTotalDays(),getSalary());
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
