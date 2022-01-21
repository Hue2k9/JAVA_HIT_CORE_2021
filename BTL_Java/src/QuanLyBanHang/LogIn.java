package QuanLyBanHang;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class LogIn {
    private Account acc=new Account();
     private ArrayList<Account> listAccount = new ArrayList<Account>();
    static Connection conn = SqlServerConnection.getJDBCConnection();
    static Statement statement;
    static {
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addAccountToList(){
        List<Account> accounts = SQLProcessing.readAllAccount();
        for(Account s : accounts){
            String userName=s.getUsername().trim();
            String passWord=s.getPassword().trim();
            s.setPassword(passWord);
            s.setUsername(userName);
            listAccount.add(s);
        }
    }

    public void SignUp(){
        acc.input();
        SQLProcessing sql = new SQLProcessing();
        if (sql.addAccountToSQL(acc)){
            listAccount.add(acc);
            System.out.println("Congratulations, you have successfully registered an account.");
        }
        else
            System.out.println("This account has already existed. Please choose another name.");
    }
    public int SignIn(){
        Scanner sc=new Scanner(System.in);
        System.out.print("User name: ");
        String userName=sc.nextLine();
        for(Account acc:listAccount){
            if(acc.getUsername().equalsIgnoreCase(userName)){
                System.out.print("Password: ");
                String passWord=sc.nextLine();
                if(acc.getPassword().equals(passWord)){
                    System.out.println("===Hello "+acc.getFullName()+"===");
                    return 1;
                }
            }
        }
        return 0;
    }
     public void ChangePassword(){
         SQLProcessing sql = new SQLProcessing();
         Scanner sc=new Scanner(System.in);
         System.out.print("Enter old password: ");
         String oldPassword=sc.nextLine();

     }
}
