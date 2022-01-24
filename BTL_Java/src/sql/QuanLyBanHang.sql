go 
use BTL_Java_QLBH;
go
/*
drop table orders;
drop table product;
drop table NhanVien;
*/
create table Product(
   idProduct char(10) primary key,
   nameProduct nvarchar(50),
   quantity int,
   price int,
   dayAdded char(12),
   origin nvarchar(50),
)
create table NhanVien(
   idStaff char(10) primary key,
   nameStaff nvarchar(50),
   age int,
   gender nvarchar(5),
   addressStaff nvarchar(50),
   totalDays int,
   phoneNumber int
)
create table orders
(
   orderCode char(10) primary key,
   receiver Nvarchar(50),
   addressClient Nvarchar(200),
   quantity int,
   phoneNumber int,
   idProduct char(10),
   dayAdded char(12),
   sumMoney int,
   idStaff char(10),
   constraint fk_order_idProduct foreign key (idProduct)
   references Product(idProduct)
   
)
alter table Orders
add 
constraint fk_order_idStaff foreign key (idStaff)
references NhanVien(idStaff)

insert into Product values
('sp01',N'sua rua mat',200,2500,'01/01/2022','China'),
('sp02',N'Linh sam 24h',170,500,'24/12/2021',N'Viet Nam'),
('sp03',N'quan jean',99,27000,'05/01/2022','China'),
('sp04',N'ao so mi',10,9900,'12/01/2022',N'Viet Nam'),
('sp05',N'ao len',19,600,'07/08/2021',N'Thai Lan'),
('sp06', N'tu dien English',5,750,'10/10/2020',N'America'),
('sp07',N'Sach lap trinh C',3,999,'7/5/2020',N'Singaproe')

insert into NhanVien values
('nv01',N'Trương Ngọc Ánh',19,N'nữ',N'Tuyên Quang',29,84560097),
('nv02',N'Trần Văn Hoàng',20,'nam',N'Thái Nguyên',27,8412378),
('nv03',N'Nguyễn Thiện Khải',21,'nam',N'Hà Nội',27,8450395)

insert into Orders values
('d1',N'Hoang Minh Hue','Ha Noi',5,8486898,'sp01','09/01/2022',12500,'nv01'),
('d2',N'Nguyen Van A','Ha Nam',1,84123457,'sp02','03/01/2022',500,'nv01'),
('d3',N'Hoang Minh Hue','TP Ho Chi Minh',2,8486998,'sp03','09/01/2022',500,'nv01'),
('d4',N'Nguyen Van B','Can Tho',4,841237,'sp02','03/01/2022',54000,'nv02'),
('d5',N'Hoang Minh Hue','Vinh Phuc',5,84868299,'sp02','09/01/2022',2500,'nv03'),
('d6',N'Nguyen Van C','Ninh Binh',1,8412367,'sp07','03/01/2022',999,'nv02'),
('d7',N'Hoang Minh Hue','Thai Nguyen',1,8486898,'sp05','09/01/2022',600,'nv02'),
('d8',N'Nguyen Van D','Ha Giang',1,84123459,'sp07','03/01/2022',999,'nv03'),
('d9',N'Ngoc Anh','Ha Noi',1,848688,'sp04','09/01/2022',9900,'nv01'),
('d10',N'Chi Hai','Ha Noi',1,8412367,'sp02','03/01/2022',500,'nv01')


select * from Orders;
select * from Product;
select * from NhanVien;



