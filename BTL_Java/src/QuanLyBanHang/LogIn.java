package QuanLyBanHang;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LogIn {
    private Account acc=new Account();
     private ArrayList<Account> listAccount = new ArrayList<Account>();
     private String user;
     private ArrayList<Product> listQuantity = new ArrayList<>();
     private ArrayList<Account> listAdmin=new ArrayList<Account>();
     static Connection conn = SqlServerConnection.getJDBCConnection();
    static Statement statement;
    static {
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    public void addAccountToList(){
        List<Account> accounts = SQLProcessing.readAllAccount();
        accounts=SQLProcessing.readAllAccount();
        for(Account s : accounts){
            String userName=s.getUsername().trim();
            String passWord=s.getPassword().trim();
            s.setPassword(passWord);
            s.setUsername(userName);
            listAccount.add(s);
        }
        List<Account> admin= SQLProcessing.readAdminAccount();
        admin=SQLProcessing.readAdminAccount();
        for(Account s: admin){
            String userName=s.getUsername().trim();
            String passWord=s.getPassword().trim();
            s.setPassword(passWord);
            s.setUsername(userName);
            listAdmin.add(s);
            listAccount.add(s);
        }
    }
    public int checkAdmin(){
        for(Account s: listAdmin){
            if (user.equalsIgnoreCase(s.getUsername()))
                return 1;
        }
        return 0;
    }
    public void SignUp(){
        acc.input();
        SQLProcessing sql =new SQLProcessing();
        int count=0;
        for(Account s: listAccount){
            if(acc.getUsername().equalsIgnoreCase(s.getUsername())){
                System.out.println("This account has already existed. Please choose another name.");
                break;
            }
            count++;
        }
        if(count==listAccount.size()){
            System.out.println("Congratulations, you have successfully registered an account.");
            sql.addAccountToSQL(acc);
        }

    }
    public int SignIn(){
        Scanner sc=new Scanner(System.in);
        System.out.print("User name: ");
        String userName=sc.nextLine();
        System.out.print("Password: ");
        String passWord=sc.nextLine();
        int count=0;
        for(Account acc:listAccount){
            if(acc.getUsername().equalsIgnoreCase(userName)){
                if(acc.getPassword().equals(passWord)){
                    System.out.println("=====  Hello "+acc.getFullName()+" !=====");
                    user=acc.getUsername();
                    return 1;
                }
                else{
                    System.out.println("Incorrect username or password!");
                    break;
                }
            }
            count++;
        }
        if(count==listAccount.size())
            System.out.println("Incorrect username or password!");
        return 0;
    }
     public void ChangePassword(){
         SQLProcessing sql = new SQLProcessing();
         Scanner sc=new Scanner(System.in);
         System.out.print("Enter old password: ");
         String oldPassword=sc.nextLine();
         String regexPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,}$";
         System.out.println("Enter new password: ");
         String newPassword=sc.nextLine();
         System.out.print("Enter password again: ");
         String passwordAgain=sc.nextLine();
         int count=0;
         if (Pattern.matches(regexPassword,newPassword)){
             for(Account s : listAccount){
                 if (user.equalsIgnoreCase(s.getUsername()) && oldPassword.equals(s.getPassword())){
                     if (!passwordAgain.equals(newPassword)){
                         System.out.println("Passwords are not the same");
                         break;
                     }
                     else{
                         s.setPassword(newPassword);
                         int k=sql.updateAccount(user,s.getPassword(),s.getFullName(),s.getPhone(),s.getAddress(),s.getEmail());
                         System.out.println("Change password successfully!");
                         break;
                     }
                 }
                 count++;
             }
             if(count==listAccount.size())
                 System.out.println("You just entered the wrong password!");
         }
         else{
             System.out.println("Password change failed. Password is too weak. Please change another password!");
         }
     }
     public void PersonalInformation(){
         System.out.println("========Personal information===============");
        for(Account acc: listAccount){
            if (acc.getUsername().equalsIgnoreCase(user)){
                System.out.println("user name: "+acc.getUsername());
                System.out.println("Full name: "+acc.getFullName());
                System.out.println("Address: "+acc.getAddress());
                System.out.println("Phone number: "+acc.getPhone());
                System.out.println("Email: "+acc.getEmail());
                System.out.println("============================================");
                break;
            }
        }
     }
     public void ChangeInformation(){
        SQLProcessing sql=new SQLProcessing();
        Scanner sc=new Scanner(System.in);
        int choose=0;
        do{
            System.out.println("1. Change name");
            System.out.println("2. Change address");
            System.out.println("3. Change phone number");
            System.out.println("4. Change email");
            System.out.println("5. Change password");
            System.out.println("6. Exit");
            System.out.print("Enter your choose: ");
             choose=sc.nextInt();
            sc.nextLine();
            switch (choose){
                case 1:{
                    System.out.print("Enter new name: ");
                    String newName=sc.nextLine();
                    for(Account s:listAccount){
                        if (user.equalsIgnoreCase(s.getUsername())){
                            s.setFullName(newName);
                            int k=SQLProcessing.updateAccount(user,s.getPassword(),s.getFullName(),s.getPhone(),s.getAddress(),s.getEmail());
                            System.out.println("Your name has been changed!");
                            break;
                        }
                    }
                    break;
                }
                case 2:{
                    System.out.print("Enter new address: ");
                    String newChange=sc.nextLine();
                    for(Account s:listAccount){
                        if (user.equalsIgnoreCase(s.getUsername())){
                            s.setAddress(newChange);
                            int k=SQLProcessing.updateAccount(user,s.getPassword(),s.getFullName(),s.getPhone(),s.getAddress(),s.getEmail());
                            System.out.println("Your address has been changed!");
                        break;
                        }
                    }
                    break;
                }
                case 3:{
                    System.out.print("Enter new phone number: ");
                    String newChange=sc.nextLine();
                    for(Account s:listAccount){
                        if (user.equalsIgnoreCase(s.getUsername())){
                            s.setPhone(newChange);
                            int k=SQLProcessing.updateAccount(user,s.getPassword(),s.getFullName(),s.getPhone(),s.getAddress(),s.getEmail());
                            System.out.println("Your phone number has been changed!");
                            break;
                        }
                    }
                    break;
                }
                case 4:{
                    String regexEmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
                    System.out.print("Enter new email: ");
                    String newChange=sc.nextLine();
                    if (!Pattern.matches(regexEmail,newChange)) {
                        System.out.println("This email is invalid!");
                    }
                    for(Account s:listAccount){
                        if (user.equalsIgnoreCase(s.getUsername())){
                            s.setEmail(newChange);
                            int k=SQLProcessing.updateAccount(user,s.getPassword(),s.getFullName(),s.getPhone(),s.getAddress(),s.getEmail());
                            System.out.println("Your email has been changed!");
                            break;
                        }
                    }
                    break;
                }
                case 5:{
                    ChangePassword();
                }
            }
        } while(choose!=6);
     }
}
