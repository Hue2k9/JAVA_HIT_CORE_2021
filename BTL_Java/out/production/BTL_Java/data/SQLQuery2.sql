
create function Auto_Product_codeProduct()
returns char(10)
as 
begin declare @id varchar(10)
     if (select count(idProduct) from Product)=0
	   set @id='0'
	else
	   select @id=max(right(idProduct,8)) from Product
	   select @id=case
	      when @id>=0 and @id<9 then 'sp00'+convert(char,convert(int,@id)+1)
		  when @id>=9 then 'sp0'+convert(char,convert(int,@id)+1)
	end
	return @id
end

create function Auto_NhanVien_idStaff()
returns char(10)
as 
begin declare @id varchar(10)
     if (select count(idStaff) from NhanVien)=0
	   set @id='0'
	else
	   select @id=max(right(idStaff,8)) from NhanVien
	   select @id=case
	      when @id>=0 and @id<9 then 'nv00'+convert(char,convert(int,@id)+1)
		  when @id>=9 then 'nv0'+convert(char,convert(int,@id)+1)
	end
	return @id
end

create function Auto_Orders_OrderCode()
returns char(10)
as 
begin declare @id varchar(10)
     if (select count(orderCode) from Orders)=0
	   set @id='0'
	else
	   select @id=max(right(orderCode,8)) from Orders
	   select @id=case
	      when @id>=0 and @id<9 then 'd00'+convert(char,convert(int,@id)+1)
		  when @id>=9 then 'd0'+convert(char,convert(int,@id)+1)
	end
	return @id
end
create table Product(
   idProduct char(10) primary key constraint codeProduct default dbo.Auto_Product_codeProduct(),
   nameProduct nvarchar(Max),
   quantity int,
   price int,
   dayAdded char(10),
   origin nvarchar(Max),
)

create table NhanVien(
   idStaff char(10) primary key constraint idStaff_auto default dbo.Auto_NhanVien_idStaff(),
   nameStaff nvarchar(Max),
   age int,
   gender nvarchar(5),
   addressStaff nvarchar(Max),
   totalDays int,
   phoneNumber char(11)
)
create table orders
(
   orderCode char(10) primary key constraint orderCode_auto default dbo.Auto_Orders_OrderCode(),
   receiver Nvarchar(Max),
   addressClient Nvarchar(Max),
   quantity int,
   phoneNumber char(11),
   idProduct char(10),
   dayAdded char(10)
   constraint fk_order_idProduct foreign key (idProduct)
   references Product(idProduct)  
)

insert into NhanVien values
(dbo.Auto_NhanVien_idStaff(),N'Trương Ngọc Ánh',19,N'nữ',N'Tuyên Quang',29,'84961327504')
insert into NhanVien values
(dbo.Auto_NhanVien_idStaff(),N'Trần Văn Hoàng',20,'nam',N'Thái Nguyên',27,'84981364460')
insert into NhanVien values
(dbo.Auto_NhanVien_idStaff(),N'Nguyễn Thiện Khải',21,'nam',N'Hà Nội',27,'0868186367')




insert into Orders values
(dbo.Auto_Orders_OrderCode(),N'Nguyen Van C','Can Tho',4,'0868299812','sp001','03/01/2022')
insert into Orders values
(dbo.Auto_Orders_OrderCode(),N'Hoang Minh Hue','Vinh Phuc',5,'0332364705','sp002','09/01/2022')
insert into Orders values
(dbo.Auto_Orders_OrderCode(),N'Nguyen Van C','Ninh Binh',1,'0332364705','sp007','03/01/2022')
insert into Orders values
(dbo.Auto_Orders_OrderCode(),N'Hoang Minh Hue','Thai Nguyen',1,'0332364705','sp005','09/01/2022')
insert into Orders values
(dbo.Auto_Orders_OrderCode(),N'Nguyen Van D','Ha Giang',1,'0868299812','sp007','03/01/2022')
insert into Orders values
(dbo.Auto_Orders_OrderCode(),N'Ngoc Anh','Ha Noi',1,'0868299812','sp004','09/01/2022')
insert into Orders values
(dbo.Auto_Orders_OrderCode(),N'Chi Hai','Ha Noi',1,'0868299812','sp002','03/01/2022')


-- Thành tiền
select  orderCode,receiver,addressClient,orders.quantity,phoneNumber,orders.idProduct, orders.dayAdded, orders.quantity*price as 'sumMoney'
from orders inner join product on orders.idproduct=product.idproduct

select * from Orders
select * from Product
select * from NhanVien

