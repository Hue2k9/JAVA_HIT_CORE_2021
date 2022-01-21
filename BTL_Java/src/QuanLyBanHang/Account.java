package QuanLyBanHang;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account implements Comparable<Account>{
    private String username;
    private String password;
    private String fullName;
    private String phone;
    private String address;
    private String email;


    public Account(String username, String password, String fullName, String phone, String address, String email) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public Account() {
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public void input(){
        String regexUserName = "^[a-zA-Z0-9]{6,}$";
        String regexPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,}$";
        String regexEmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        String regexPhone = "^[0-9\\-\\+]{9,15}$";
        Scanner sc=new Scanner(System.in);
        System.out.print("Full name: ");
        fullName=sc.nextLine();
        System.out.print("User name: ");
        username=sc.nextLine();
        while(!Pattern.matches(regexUserName,username)){
            System.out.print("Enter user name : ");
            username=sc.nextLine();
        }
        System.out.print("Password: ");
        password=sc.nextLine();
        while(!Pattern.matches(regexPassword,password)){
            System.out.print("Enter pass word: ");
            password=sc.nextLine();
        }
        System.out.print("Enter password again: ");
        String passwordAgain=sc.nextLine();
        while (!passwordAgain.equals(password)){
            System.out.println("Passwords are not the same");
            System.out.println("Enter password again: ");
            passwordAgain=sc.nextLine();
        }
        /*
        System.out.print("Email: ");
        email=sc.nextLine();
        while (!Pattern.matches(regexEmail,email)){
            System.out.print("Email: ");
            email=sc.nextLine();
        }

         */
        System.out.print("Phone: ");
        phone=sc.nextLine();
        while(!Pattern.matches(regexPhone,phone)){
            System.out.print("Phone: ");
            phone=sc.nextLine();
        }

    }
    public void output(){

    }
    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public int compareTo(Account o) {
        return getUsername().compareTo(o.getUsername());
    }
}