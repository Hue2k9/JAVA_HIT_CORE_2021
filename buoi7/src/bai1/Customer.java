package bai1;

public class Customer extends Person{
    private int balance;

    public Customer(String name, String address, int balance) {
        super(name, address);
        this.balance = balance;
    }

    public Customer(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public void display() {
        System.out.println("Custemer name: "+getName());
        System.out.println("Customer address: " + getAddress());
        System.out.println("Customer balance: " + getBalance());
    }
}
