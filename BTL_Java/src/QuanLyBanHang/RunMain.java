package QuanLyBanHang;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class RunMain {
    public static void main(String[] args) throws SQLException {
        Manage nv=new Manage();
        Scanner sc=new Scanner(System.in);
        ArrayList<Product> listProduct =new ArrayList<Product>();
        Connection conn=SqlServerConnection.getJDBCConnection();
        nv.Base();
        LogIn logIn=new LogIn();
        logIn.addAccountToList();

        int menu1=0;
        do{
            nv.addAccountToList();
            logIn.addAccountToList();
            System.out.println("1. Sign in");
            System.out.println("2. Sign up");
            System.out.println("3. Exit");
            System.out.print("Enter your choose: ");
            menu1=sc.nextInt();
            switch (menu1){
                case 1:{
                    int join=logIn.SignIn();
                    if (join==1){
                        /* =======Manage========= */
                        int menu;
                        do{
                            System.out.println(" ________ Hello ________");
                            System.out.println("|                        |");
                            System.out.println("|1. Product              |");
                            System.out.println("|2. Order                |");
                            System.out.println("|3. Personal             |");
                            System.out.println("|4. Log out              |");
                            System.out.println("|                        |");
                            System.out.println("|________________________|");
                            System.out.print("Enter your choose: ");
                            menu = sc.nextInt();
                            switch(menu){
                                case 1:{
                                    int list;
                                    do{
                                        System.out.println(" _________________________________");
                                        System.out.println("|                                 |");
                                        System.out.println("|1. Find product                  |");
                                        System.out.println("|2. Display product list          |");
                                        System.out.println("|3. Exit                          |");
                                        System.out.println("|                                 |");
                                        System.out.println("|_________________________________|");
                                        System.out.print("Enter your choose: ");
                                        list=sc.nextInt();
                                        switch (list){
                                            case 1:{
                                                nv.findProduct();
                                                break;
                                            }
                                            case 2:{
                                                int k;
                                                do{
                                                    System.out.println(" _____________________________ ");
                                                    System.out.println("|                             |");
                                                    System.out.println("|1. Show products by price    |");
                                                    System.out.println("|2. Show products by quantity |");
                                                    System.out.println("|3. Exit                      |");
                                                    System.out.println("|                             |");
                                                    System.out.println("|                             |");
                                                    System.out.println("|_____________________________|");
                                                    System.out.print("Enter your choose: ");
                                                    k=sc.nextInt();
                                                    sc.nextLine();
                                                    switch (k){
                                                        case 1:{
                                                            int m;
                                                            do{
                                                                System.out.println(" ________________________");
                                                                System.out.println("|                        |");
                                                                System.out.println("|1. The price increase?  |");
                                                                System.out.println("|2. The price decrease?  |");
                                                                System.out.println("|3. Exit                 |");
                                                                System.out.println("|                        |");
                                                                System.out.println("|________________________|");
                                                                System.out.print("Enter your choose: ");
                                                                m=sc.nextInt();
                                                                sc.nextLine();
                                                                switch (m){
                                                                    case 1:{
                                                                        nv.sortProductByPriceIncrease();
                                                                        break;
                                                                    }
                                                                    case 2:{
                                                                        nv.sortProductByPriceDecrease();
                                                                    }
                                                                }
                                                            } while(m!=3);
                                                            break;
                                                        }
                                                        case 2:{
                                                            int m;
                                                            do{
                                                                System.out.println(" ________________________");
                                                                System.out.println("|                        |");
                                                                System.out.println("|1. Increase?            |");
                                                                System.out.println("|2. Decrease?            |");
                                                                System.out.println("|3. Exit                 |");
                                                                System.out.println("|                        |");
                                                                System.out.println("|                        |");
                                                                System.out.println("|________________________|");
                                                                System.out.print("Enter your choose: ");
                                                                m=sc.nextInt();
                                                                sc.nextLine();
                                                                switch (m){
                                                                    case 1:{
                                                                        nv.sortProductByQuantityIncrease();
                                                                        break;
                                                                    }
                                                                    case 2:{
                                                                        nv.sortProductByQuantityDecrease();
                                                                    }
                                                                }
                                                            } while(m!=3);
                                                            break;
                                                        }
                                                    }
                                                } while(k!=3);
                                                break;
                                            }
                                        }
                                    } while(list!=3);
                                    break;
                                }
                                case 2:{
                                    int list;
                                    do{
                                        System.out.println(" __________________________________ ");
                                        System.out.println("|                                  |");
                                        System.out.println("|1. Insert order                   |");
                                        System.out.println("|2. Edit order                     |");
                                        System.out.println("|3. Display order list             |");
                                        System.out.println("|4. Exit                           |");
                                        System.out.println("|__________________________________|");
                                        System.out.print("Enter your choose: ");
                                        list=sc.nextInt();
                                        switch (list){
                                            case 1:{
                                                nv.addOrder();
                                                break;
                                            }
                                            case 2:{
                                                nv.editOrder();
                                                break;
                                            }
                                            case 3:{
                                                nv.displayOrder();
                                                break;
                                            }
                                        }
                                    } while(list!=4);
                                    break;
                                }
                                case 3:{
                                    int choose;
                                    do{
                                        System.out.println("1. Personal information");
                                        System.out.println("2. Change information");
                                        System.out.println("3. Exit");
                                        System.out.print("Enter your choose: ");
                                        choose=sc.nextInt();
                                        switch (choose){
                                            case 1:{
                                                logIn.PersonalInformation();
                                                break;
                                            }
                                            case 2:{
                                                logIn.ChangeInformation();
                                                break;
                                            }
                                        }
                                    } while (choose!=3);
                                }
                            }
                        } while(menu!=4);
                        /* =========Manage===========*/
                    }
                    else{
                        menu1=0;
                    }
                    break;
                }
                case 2:{
                    logIn.SignUp();
                    nv.addAccountToList();
                    break;
                }
            }
        } while (menu1!=3);

        /*
              =======Admin========
        int menu1;
        do{
            nv.addAccountToList();
            logIn.addAccountToList();
            System.out.println("1. Sign in");
            System.out.println("2. Sign up");
            System.out.println("3. Exit");
            System.out.print("Enter your choose: ");
            menu1=sc.nextInt();
            switch (menu1){
                case 1:{
                    int join=logIn.SignIn();
                    if (join==1){

                        int menu;
             do{
            System.out.println(" _______MANAGE ______");
            System.out.println("|                    |");
            System.out.println("|1. Staff            |");
            System.out.println("|2. Product          |");
            System.out.println("|3. Order            |");
            System.out.println("|4. Log out          |");
            System.out.println("|                    |");
            System.out.println("|____________________|");
            System.out.print("Enter your choose: ");
            menu = sc.nextInt();
            switch(menu){
                case 1:{
                    int list;
                    do{
                        System.out.println(" ______________________ ");
                        System.out.println("|                      |");
                        System.out.println("|1. Insert staff       |");
                        System.out.println("|2. Find staff         |");
                        System.out.println("|3. Delete staff       |");
                        System.out.println("|4. Display list staff |");
                        System.out.println("|5. Exit               |");
                        System.out.println("|______________________|");
                        System.out.print("Enter your choose: ");
                        list=sc.nextInt();
                        switch (list){
                            case 1:{
                                nv.insertStaff();
                                break;
                            }
                            case 2:{
                                nv.findStaff();
                                break;
                            }
                            case 3:{
                                nv.deleteStaff();
                                break;
                            }
                            case 4:{
                                nv.displayListStaff();
                                break;
                            }
                        }
                    } while(list!=5);
                    break;
                }
                case 2:{
                    int list;
                    do{
                        System.out.println(" _________________________________");
                        System.out.println("|                                 |");
                        System.out.println("|1. Insert product                |");
                        System.out.println("|2. Find product                  |");
                        System.out.println("|3. Delete product                |");
                        System.out.println("|4. Edit the price of the product |");
                        System.out.println("|5. Display product list          |");
                        System.out.println("|6. Exit                          |");
                        System.out.println("|                                 |");
                        System.out.println("|_________________________________|");
                        System.out.print("Enter your choose: ");
                        list=sc.nextInt();
                        switch (list){
                            case 1:{
                                nv.insertProduct();
                                break;
                            }
                            case 2:{
                                nv.findProduct();
                                break;
                            }
                            case 3:{
                                nv.deleteProduct();
                                break;
                            }
                            case 4:{
                                nv.editThePrice();
                                break;
                            }
                            case 5:{
                                int k;
                                do{
                                    System.out.println(" _____________________________ ");
                                    System.out.println("|                             |");
                                    System.out.println("|1. Show products by price    |");
                                    System.out.println("|2. Show products by quantity |");
                                    System.out.println("|3. Exit                      |");
                                    System.out.println("|                             |");
                                    System.out.println("|                             |");
                                    System.out.println("|_____________________________|");
                                    System.out.print("Enter your choose: ");
                                    k=sc.nextInt();
                                    sc.nextLine();
                                    switch (k){
                                        case 1:{
                                            int m;
                                            do{
                                                System.out.println(" ________________________");
                                                System.out.println("|                        |");
                                                System.out.println("|1. The price increase?  |");
                                                System.out.println("|2. The price decrease?  |");
                                                System.out.println("|3. Exit                 |");
                                                System.out.println("|                        |");
                                                System.out.println("|________________________|");
                                                System.out.print("Enter your choose: ");
                                                m=sc.nextInt();
                                                sc.nextLine();
                                              switch (m){
                                                  case 1:{
                                                      nv.sortProductByPriceIncrease();
                                                      break;
                                                  }
                                                  case 2:{
                                                      nv.sortProductByPriceDecrease();
                                                  }
                                              }
                                            } while(m!=3);
                                            break;
                                        }
                                        case 2:{
                                            int m;
                                            do{
                                                System.out.println(" ________________________");
                                                System.out.println("|                        |");
                                                System.out.println("|1. Increase?            |");
                                                System.out.println("|2. Decrease?            |");
                                                System.out.println("|3. Exit                 |");
                                                System.out.println("|                        |");
                                                System.out.println("|                        |");
                                                System.out.println("|________________________|");
                                                System.out.print("Enter your choose: ");
                                                m=sc.nextInt();
                                                sc.nextLine();
                                                switch (m){
                                                    case 1:{
                                                        nv.sortProductByQuantityIncrease();
                                                        break;
                                                    }
                                                    case 2:{
                                                        nv.sortProductByQuantityDecrease();
                                                    }
                                                }
                                            } while(m!=3);
                                            break;
                                        }
                                    }
                                } while(k!=3);
                               break;
                            }

                        }
                    } while(list!=6);
                    break;
                }
                case 3:{
                    int list;
                    do{
                        System.out.println(" __________________________________ ");
                        System.out.println("|                                  |");
                        System.out.println("|1. Insert order                   |");
                        System.out.println("|2. Delete order                   |");
                        System.out.println("|3. Edit order                     |");
                        System.out.println("|4. Display sum of orders          |");
                        System.out.println("|5. Display order list             |");
                        System.out.println("|6. Find order by receiver address |");
                        System.out.println("|7. Exit                           |");
                        System.out.println("|__________________________________|");
                        System.out.print("Enter your choose: ");
                        list=sc.nextInt();
                        switch (list){
                            case 1:{
                                nv.addOrder();
                                break;
                            }
                            case 2:{
                                nv.deleteOrder();
                                break;
                            }
                            case 3:{
                                nv.editOrder();
                                break;
                            }
                            case 4:{
                                nv.sumOfOrder();
                                break;
                            }
                            case 5:{
                                nv.displayOrder();
                                break;
                            }
                            case 6:{
                                nv.findAllOrderByAddress();
                                break;
                            }
                        }
                    } while(list!=7);
                    break;
                }
            }
        } while(menu!=4);

                    }
                    else{
                        menu1=0;
                    }
                    break;
                }
                case 2:{
                    logIn.SignUp();
                    nv.addAccountToList();
                    break;
                }
            }
        } while (menu1!=3);
        */


    }
}
