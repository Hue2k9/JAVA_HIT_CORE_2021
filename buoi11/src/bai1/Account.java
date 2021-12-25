package bai1;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Account implements Comparable<Account>{
    private long id;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String createAt;
    static Pattern pattern;
    static Matcher matcher;

    public Account(long id, String fullName, String username, String password, String email, String phone, String createAt) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.createAt = createAt;
    }

    public Account() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
    public void input(){
        String regexUserName = "^[a-zA-Z0-9]{6,}$";
        String regexPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,}$";
        String regexEmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        String regexPhone = "^[0-9\\-\\+]{9,15}$";

        Scanner sc=new Scanner(System.in);
        System.out.print("id: ");
        id=sc.nextInt();
        sc.nextLine();
        System.out.print("Full name: ");
        fullName=sc.nextLine();
        System.out.print("User name: ");
        username=sc.nextLine();
        while(!Pattern.matches(regexUserName,username)){
            System.out.print("Enter user name : ");
            username=sc.nextLine();
        }
        System.out.print("Pass word: ");
        password=sc.nextLine();
        while(!Pattern.matches(regexPassword,password)){
            System.out.print("Enter pass word: ");
            password=sc.nextLine();
        }
        System.out.print("Email: ");
        email=sc.nextLine();
        while (!Pattern.matches(regexEmail,email)){
            System.out.print("Email: ");
            email=sc.nextLine();
        }
        System.out.print("Phone: ");
        phone=sc.nextLine();
        while(!Pattern.matches(regexPhone,phone)){
            System.out.print("Phone: ");
            phone=sc.nextLine();
        }
        /*
        System.out.print("Create at: ");
        createAt=sc.nextLine();
         */
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", createAt='" + createAt + '\'' +
                '}';
    }
    public String hidePassword(){
        return "Account{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", createAt='" + createAt + '\'' +
                '}';
    }
    @Override
    public int compareTo(Account o) {
        return getUsername().compareTo(o.getUsername());
    }
}
