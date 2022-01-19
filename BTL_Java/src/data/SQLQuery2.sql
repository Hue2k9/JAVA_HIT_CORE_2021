
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
create table NhanVien(
   idStaff char(10) primary key constraint idStaff_auto default dbo.Auto_NhanVien_idStaff(),
   nameStaff nvarchar(Max),
   age int,
   gender nvarchar(5),
   addressStaff nvarchar(Max),
   totalDays int,
   phoneNumber int
)
create table Product(
   idProduct char(10) primary key constraint codeProduct default dbo.Auto_Product_codeProduct(),
   nameProduct nvarchar(Max),
   quantity int,
   price int,
   dayAdded char(10),
   origin nvarchar(Max),
)
insert into Product values
(dbo.Auto_Product_codeProduct(),N'Sách lập trình C',3,999,'07/05/2020',N'Singaproe')
insert into NhanVien values
(dbo.Auto_NhanVien_idStaff(),N'Trương Ngọc Ánh',19,N'nữ',N'Tuyên Quang',29,84560097)
insert into NhanVien values
(dbo.Auto_NhanVien_idStaff(),N'Trần Văn Hoàng',20,'nam',N'Thái Nguyên',27,8412378)
insert into NhanVien values
(dbo.Auto_NhanVien_idStaff(),N'Nguyễn Thiện Khải',21,'nam',N'Hà Nội',27,8450395)

select * from NhanVien
select * from Product

