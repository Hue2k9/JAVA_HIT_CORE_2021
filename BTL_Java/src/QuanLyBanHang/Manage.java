package QuanLyBanHang;
import java.sql.Connection;
import java.util.*;

public class Manage {
    private ArrayList<NhanVien> listStaff= new ArrayList<NhanVien>();
    private ArrayList<Product> listProduct =new ArrayList<Product>();
    private ArrayList<Order> listOrder=new ArrayList<Order>();
    Product product=new Product();
    Order order=new Order();
    NhanVien nhanVien = new NhanVien();
    Connection conn=SqlServerConnection.getJDBCConnection();

    public Manage(ArrayList<NhanVien> listStaff, ArrayList<Product> listProduct, ArrayList<Order> listOrder) {
        this.listStaff = listStaff;
        this.listProduct = listProduct;
        this.listOrder = listOrder;
    }
    public Manage(){};


    //Them nhan vien
    public void insertStaff(){
        NhanVien nv=new NhanVien();
        nv.input();
        SQLProcessing sql=new SQLProcessing();
        if(sql.addStaffToSQL(nv)){
            listStaff.add(nv);
            System.out.println("The staff is added!");
        }
        else{
            System.out.println("Staff's Id cannot be duplicated!");
        }
    }
    //Hien thi danh sach nhan vien
    public void displayListStaff(){
        Scanner sc=new Scanner(System.in);
        for(NhanVien nv : listStaff){
            System.out.println(nv.toString());
        }
    }
    //Xoa nhan vien
    public void deleteStaff(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter id staff: ");
        String idStaff=sc.nextLine();
        int k=0;
        for(NhanVien nv: listStaff){
            if (nv.getIdStaff().equalsIgnoreCase(idStaff)){
                boolean isRemove=listStaff.remove(nv);
                k=SQLProcessing.deleteStaff(nv.getIdStaff());
                break;
            }
        }
        if (k==-1)
            System.out.println("Staff's ID is invalid!");
        else
            System.out.println("The staff has been removed.");
    }
    //Tìm nhân viên theo tên
    public void findStaff(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter name staff: ");
        String name=sc.nextLine();
        System.out.print("List of employees named "+ name+": \n");
        for(NhanVien nv:listStaff){
            if(nv.getName().equalsIgnoreCase(name)){
                nv.output();
            }
        }
    }
    public void Base(){
        //San pham
        List<Product> products=SQLProcessing.readAllProduct();
        for(Product s : products){
            listProduct.add(s);
        }
        for(Product s: listProduct){
            String id=s.getIdProduct().trim();
            String day=s.getDayAdded().trim();
            s.setIdProduct(id);
            s.setDayAdded(day);
        }
        //Nhan vien
        List<NhanVien> nhanViens =SQLProcessing.readAllStaff();
       for(NhanVien s: nhanViens){
           listStaff.add(s);
       }
       for(NhanVien s : listStaff){
           String id=s.getIdStaff().trim();
           s.setIdStaff(id);
       }
    }
    public void insertProduct() {
        Product sp=new Product();
        sp.input();
        SQLProcessing sql=new SQLProcessing();
        if (sql.addProducttoSQL(sp)){
            System.out.println("Add product success");
            listProduct.add(sp);
        }else{
            System.out.println("Product's ID cannot be duplicated!");
        }
    }
    public void deleteProduct(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter code product: ");
        String idProduct=sc.nextLine();
        int k=0;
        for(Product sp: listProduct){
            if (sp.getIdProduct().equalsIgnoreCase(idProduct)){
                boolean isRemove=listProduct.remove(sp);
                k=SQLProcessing.deleteProduct(sp.getIdProduct());
                break;
            }
        }
        if (k==-1){
            System.out.println("Product ID is invalid!");
        }else{
            System.out.println("The product has been removed.");
        }

    }
    public void findProduct(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter code product: ");
        String code=sc.nextLine();
        int count=0;
        for(Product sp:listProduct){
            if (sp.getIdProduct().equals(code)){
                System.out.println(sp.toString());
            }
            else
                count++;
        }
        if (count==listProduct.size())
            System.out.println("The product is not available");
    }
    public void displayListProduct(){
        Scanner sc=new Scanner(System.in);
        for(Product sp : listProduct){
            sp.toString();
        }
    }
    //Sap xep theo chieu tang dan gia ban
    public void sortProductByPriceIncrease(){
        Collections.sort(listProduct);
        for(Product sp: listProduct){
            System.out.println(sp.toString());
        }
    }
    //Sắp xếp theo chiều giảm dần giá bán
    public void sortProductByPriceDecrease(){
        Collections.sort(listProduct, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice()>o2.getPrice())
                    return -1;
                else if (o1.getPrice()<o2.getPrice())
                    return 1;
                else
                    return 0;
            }
        });
        for(Product sp: listProduct){
            System.out.println(sp.toString());
        }
    }
    //Hiển thị sản phẩm số lượng giám dần
    public void sortProductByQuantityDecrease(){
        Collections.sort(listProduct, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getQuantity()> o2.getQuantity())
                    return -1;
                else if (o1.getQuantity()<o2.getQuantity())
                    return 1;
                else
                    return 0;
            }
        });
        for(Product sp: listProduct){
            System.out.println(sp.toString());
        }
    }
    //Hiển thị sản phẩm số lượng tăng dần
    public void sortProductByQuantityIncrease(){
        Collections.sort(listProduct, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getQuantity()> o2.getQuantity())
                    return 1;
                else if (o1.getQuantity()<o2.getQuantity())
                    return -1;
                else
                    return 0;
            }
        });
        for(Product sp: listProduct){
            System.out.println(sp.toString());
        }
    }

    public void editThePrice(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter code product: ");
        String idProduct=sc.nextLine();
        SQLProcessing sql=new SQLProcessing();
        int price;
        int k=0;
        for(Product sp: listProduct){
            if (sp.getIdProduct().equals(idProduct)){
                System.out.print("Enter the new price: ");
                price=sc.nextInt();
                sc.nextLine();
                sp.setPrice(price);
                k=SQLProcessing.updateProduct(idProduct,price);
            }
        }
        if (k==-1)
            System.out.println("Product Id is invalid!");
        else
            System.out.println("The price of the product has been updated.");
    }

    //Quan ly don hang
    public void addOrder(){
        Order or=new Order();
        or.inputOrder();
        int quantity;
        int check=0;
        for(Product p:listProduct){
            if (or.getCodeProduct().equalsIgnoreCase(p.getIdProduct())){
              quantity=p.getQuantity()-or.getQuantity();
              if(quantity>0){
                  or.setSumMoney(or.getQuantity()*p.getPrice());
                  System.out.println("1 order has been created.");
                  listOrder.add(or);
              }else{
                  System.out.println("The number of available items is not enough");
              }
              check=1;
                break;
            }
        }
        if (check==0){
            System.out.println("ID product is invalid.");
        }

    }
    public void displayOrder(){
        for(Order or: listOrder)
            System.out.println(or);
    }
    public void findAllOrderByAddress(){
        System.out.println("Enter address: ");
        Scanner sc=new Scanner(System.in);
        String address=sc.nextLine();
        for(Order or:listOrder){
            if (address.equalsIgnoreCase(or.getAddress()))
                System.out.println(or);
        }
    }
    public void deleteOrder(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter code order: ");
        String orderCode=sc.nextLine();
        for(Order or:listOrder){
            if (orderCode.equalsIgnoreCase(or.getOrderCode())){
                boolean isRemove=listOrder.remove(or);
                break;
            }
        }
    }
    public void editOrder(){
        int choose;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter order code: ");
        String orderCode=sc.nextLine();
        do{
            System.out.println("1. Edit name");
            System.out.println("2. Edit address");
            System.out.println("3. Edit quantity");
            System.out.println("4. Edit phone number");
            System.out.println("5. Edit code product");
            System.out.println("6. Exit");
            System.out.println("Enter your choose: ");
            choose=sc.nextInt();
            sc.nextLine();
            switch (choose){
                case 1:{
                    for(Order or:listOrder){
                        if(orderCode.equalsIgnoreCase(or.getOrderCode())){
                            System.out.print("Enter new name: ");
                            String name=sc.nextLine();
                            or.setReceiver(name);
                            System.out.println("Name change successfully!");
                        }
                    }
                    break;
                }
                case 2:{
                    for(Order or:listOrder){
                        if(orderCode.equalsIgnoreCase(or.getOrderCode())){
                            System.out.print("Enter new address: ");
                            String address=sc.nextLine();
                            or.setAddress(address);
                            System.out.println("Address change successful!");
                        }
                    }
                    break;
                }
                case 3:{
                    for(Order or:listOrder){
                        if(orderCode.equalsIgnoreCase(or.getOrderCode())){
                            System.out.print("Enter new quantity: ");
                            int quantity=sc.nextInt();
                            sc.nextLine();
                            or.setQuantity(quantity);
                            System.out.println("Quantity of products change successful!");
                        }
                    }
                    break;
                }
                case 4:{
                    for(Order or:listOrder){
                        if(orderCode.equalsIgnoreCase(or.getOrderCode())){
                            System.out.print("Enter new phone number: ");
                            int phoneNumber=sc.nextInt();
                            sc.nextLine();
                            or.setPhoneNumber(phoneNumber);
                            System.out.println("Phone number change successful!");
                        }
                    }
                    break;
                }
                case 5:{
                    for(Order or:listOrder){
                        if(orderCode.equalsIgnoreCase(or.getOrderCode())){
                            System.out.print("Enter new code product: ");
                            String codeProduct=sc.nextLine();
                            or.setCodeProduct(codeProduct);
                            System.out.println("Code product change successful!");
                        }
                    }
                    break;
                }
            }
        } while(choose!=6);
    }
}
