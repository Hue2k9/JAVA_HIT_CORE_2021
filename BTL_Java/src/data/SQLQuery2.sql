
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
   userName char(50)
)

insert into NhanVien values
(dbo.Auto_NhanVien_idStaff(),N'Trương Ngọc Ánh',19,N'nữ',N'Tuyên Quang',29,'84961327504')
insert into NhanVien values
(dbo.Auto_NhanVien_idStaff(),N'Trần Văn Hoàng',20,'nam',N'Thái Nguyên',27,'84981364460')
insert into NhanVien values
(dbo.Auto_NhanVien_idStaff(),N'Nguyễn Thiện Khải',21,'nam',N'Hà Nội',27,'0868186367')




insert into Orders values
(dbo.Auto_Orders_OrderCode(),'hue2k9')
insert into Orders values
(dbo.Auto_Orders_OrderCode(),'hue2k8')
insert into Orders values
(dbo.Auto_Orders_OrderCode(),'hue2k9')
insert into Orders values
(dbo.Auto_Orders_OrderCode(),'hue2k9')
insert into Orders values
(dbo.Auto_Orders_OrderCode(),'hue2k7')


--============Admin=============---
create table Admin
(
  id char(50) primary key,
  password char(50)
)
insert into Admin values
('AdminHue2k9','AdminHue2k9***')

--============USERS==============
create table Users(
   userName char(50) primary key,
   password char(50),
   Name nvarchar(max),
   phoneNumber char(11),
   address nvarchar(max),
)
insert into Users values
('hue2k9','Doanxem2k9***',N'Hoàng Minh Huệ','0868299812',N'Hà Nội'),
('hue2k8','Doanxem2k9***',N'Hoàng Minh Huệ','0868299812',N'Hà Nội'),
('hue2k7','Doanxem2k9***',N'Hoàng Minh Huệ','0868299812',N'Hà Nội')
create table userOrder
(
   userName char(50),
   idProduct char(10),
   quantity int,
   orderCode char(10),
   constraint Fk_userOrder_orderCode foreign key (orderCode)
   references orders(orderCode),
   constraint Fk_userOrder_idProduct foreign key (idProduct)
   references Product(idProduct),
   constraint Fk_Users_userName foreign key (userName)
   references users(userName)
)

insert into userOrder values 
('hue2k9','sp001',2,'d001'),
('hue2k9','sp002',3,'d001'),
('hue2k9','sp003',2,'d001'),
('hue2k9','sp004',3,'d001'),
('hue2k8','sp001',2,'d002'),
('hue2k7','sp002',3,'d003')

--===========Hien don hang============--
select userName, nameProduct,userOrder.quantity,orderCode
from userOrder 
inner join Product on userOrder.idProduct=Product.idProduct
where userName='hue2k8' and orderCode='d001'


select * from orders where userName='hue2k9'


select * from Orders
select * from Product
select * from NhanVien