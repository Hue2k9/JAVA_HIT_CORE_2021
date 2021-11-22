package bai2;
import java.util.Scanner;
public class RunMain {
    static int n;
    Book book[];
    public void addBook(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap so luong sach: ");
        n=sc.nextInt();
        for(int i=0; i<n; i++){
            book[i]=new Book[n];
            book[i].nhap();
        }
    }
    public void DeleteBookById(){

    }
    public void sortBooksByPrice(){
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if (book[i].getPrice()<book[j].getPrice()){

                    temp=book[i].getPrice();
                    book[i].getPrice()=book[j].getPrice();
                    book[j].getPrice()=temp;
                }
            }
        }
    }
    public void ShowAllBooks(){
        for(int i=0; i<n; i++){

            book[i].xuat();
            System.out.println();
        }
    }
    public static void main(String[] args){
        int number;
        Scanner sc=new Scanner();

        do{
            System.out.print("Nhap lua chon: ");
            number=sc.nextInt();
            switch (number){
                case 1:{
                    addBook();
                    break;
                }
                case 6:{
                    ShowAllBooks();
                    break;
                }
                case 5:{
                    sortBooksByPrice();
                    break;
                }
                case 7:{
                    return;
                }
            }
        } while(number!=7);
    }
}
