package bai2;
import java.util.Scanner;
public class Book extends Document{
    private int numberOfPage;
    private String author;

    public Book() {
    }

    public Book(int numberOfPage, String author) {
        this.numberOfPage = numberOfPage;
        this.author = author;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public void nhap(){
        Scanner sc=new Scanner(System.in);
        super.nhap();
        System.out.print("Number of page: ");
        numberOfPage=sc.nextInt();
        System.out.print("Author: ");
        author=sc.nextLine();
    }
    public void xuat(){
        super.xuat();
        System.out.println("Number of page: "+numberOfPage);
        System.out.println("Author: "+author);

    }
}
