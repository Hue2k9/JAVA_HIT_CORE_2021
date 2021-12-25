package bai1;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Date;
import java.text.SimpleDateFormat;
public class RunMain {
    static List<Account> accounts = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        int menu;
        Scanner sc=new Scanner(System.in);
        FileWriter fileWriter = new FileWriter("ACC.DAT",true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        do{
            System.out.println("1. Create new account.\n" +
                    "2. Login to an existing account.\n" +
                    "3. Sort accounts by username.\n" +
                    "4. Exit.\n");
            System.out.print("Nhap lua chon: ");
            menu=sc.nextInt();
            switch (menu){
                case 1:{
                    Account acc=new Account();
                    acc.input();
                    Date date=new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
                    String strDate = formatter.format(date);
                    acc.setCreateAt(strDate);
                    accounts.add(acc);
                    printWriter.println(acc.getId() + "| "+acc.getPassword());
                    break;
                }
                case 2:{
                    sc.nextLine();
                    System.out.print("User: ");
                    String name=sc.nextLine();
                    System.out.print("Password: ");
                    String password=sc.nextLine();
                    int luachon;
                    for(int i=0; i<accounts.size(); i++){
                        if (name.equals(accounts.get(i).getUsername()) && password.equals(accounts.get(i).getPassword())){
                            System.out.println("1.Show info.\n" +
                                    "2.Change password.\n");
                            System.out.println("Nhap lua chon: ");
                            luachon=sc.nextInt();
                            if (luachon==1){
                                    System.out.println(accounts.get(i).hidePassword());
                            }
                            else if (luachon==2){
                                String regexPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,}$";
                                System.out.print("Enter new pass word: ");
                                password=sc.nextLine();
                                sc.nextLine();
                                while(!Pattern.matches(regexPassword,password)){
                                    System.out.println("password is not strong enough");
                                    System.out.print("Enter new pass word: ");
                                    password=sc.nextLine();
                                }
                                System.out.print("Enter new password again: ");
                                String passwordAgain=sc.nextLine();
                                if (password.equals(passwordAgain)){
                                    accounts.get(i).setPassword(passwordAgain);
                                    System.out.println("Change password successfully!");
                                    printWriter.println(accounts.get(i).getId() + "| "+accounts.get(i).getPassword());
                                }
                            }
                        }
                        else{
                            System.out.println("Incorrect user name or password");
                        }
                    }
                    break;
                }
                case 3: {
                    Collections.sort(accounts, new Comparator<Account>(){
                        @Override
                        public int compare(Account o1, Account o2){
                            return o1.getUsername().compareTo(o2.getUsername());
                        }
                    });
                    for(Account acc : accounts)
                        System.out.println(acc.toString());
                    break;
                }
            }
        } while(menu!=4);
        fileWriter.close();
        bufferedWriter.close();
        printWriter.close();
    }
}
