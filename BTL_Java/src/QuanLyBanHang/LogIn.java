package QuanLyBanHang;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class LogIn {
    private Account acc=new Account();
    static Connection conn = SqlServerConnection.getJDBCConnection();
    static Statement statement;
    static {
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public void ChangePassword(){
         Scanner sc=new Scanner(System.in);
         System.out.print("Enter old password: ");
         String oldPassword=sc.nextLine();

     }
}
