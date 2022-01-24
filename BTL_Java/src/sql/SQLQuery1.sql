select * from NhanVien;
select * from orders;
alter table orders drop column idStaff;
create table Product(
   idProduct char(10) primary key,
   nameProduct nvarchar(Max),
   quantity int,
   price int,
   dayAdded char(10),
   origin nvarchar(Max),
)
create table NhanVien(
   idStaff char(10) primary key,
   nameStaff nvarchar(Max),
   age int,
   gender nvarchar(5),
   addressStaff nvarchar(Max),
   totalDays int,
   phoneNumber int
)
create table orders
(
   orderCode char(10) primary key,
   receiver Nvarchar(Max),
   addressClient Nvarchar(Max),
   quantity int,
   phoneNumber int,
   idProduct char(10),
   dayAdded char(10),
   sumMoney int
   constraint fk_order_idProduct foreign key (idProduct)
   references Product(idProduct)  
)

insert into Product values
('sp01',N'Tẩy trang Nivea',200,2500,'01/01/2022','China'),
('sp02',N'Vang đỏ 1972',170,500,'24/12/2021',N'Việt Nam'),
('sp03',N'Murad skin perfecting lotion',99,27000,'05/01/2022','China'),
('sp04',N'Kem dưỡng ẩm Innisfree',10,9900,'12/01/2022',N'Việt Nam'),
('sp05',N'Sữa rửa mặt Simple',19,600,'07/08/2021',N'Hàn Quốc'),
('sp06', N'Tử điển tiếng anh',5,750,'10/10/2020',N'America'),
('sp07',N'Sách lập trình C',3,999,'07/05/2020',N'Singaproe')

insert into NhanVien values
('nv01',N'Trương Ngọc Ánh',19,N'nữ',N'Tuyên Quang',29,84560097),
('nv02',N'Trần Văn Hoàng',20,'nam',N'Thái Nguyên',27,8412378),
('nv03',N'Nguyễn Thiện Khải',21,'nam',N'Hà Nội',27,8450395)

insert into Orders values
('d1',N'Hoang Minh Hue','Ha Noi',5,8486898,'sp01','09/01/2022',12500),
('d2',N'Nguyen Van A','Ha Nam',1,84123457,'sp02','03/01/2022',500),
('d3',N'Hoang Minh Hue','TP Ho Chi Minh',2,8486998,'sp03','09/01/2022',500),
('d4',N'Nguyen Van B','Can Tho',4,841237,'sp02','03/01/2022',54000),
('d5',N'Hoang Minh Hue','Vinh Phuc',5,84868299,'sp02','09/01/2022',2500),
('d6',N'Nguyen Van C','Ninh Binh',1,8412367,'sp07','03/01/2022',999),
('d7',N'Hoang Minh Hue','Thai Nguyen',1,8486898,'sp05','09/01/2022',600),
('d8',N'Nguyen Van D','Ha Giang',1,84123459,'sp07','03/01/2022',999),
('d9',N'Ngoc Anh','Ha Noi',1,848688,'sp04','09/01/2022',9900),
('d10',N'Chi Hai','Ha Noi',1,8412367,'sp02','03/01/2022',500)



