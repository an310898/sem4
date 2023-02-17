use master
go
drop database BOOKSTORE
go
create database BOOKSTORE
go
use BOOKSTORE
GO


create table Category
(
    Id          int identity (1,1) primary key,
    Name        nvarchar(100)          not null,
    CreatedDate date default getdate() not null
)
create table Book
(
    Id          int identity (1,1) primary key,
    Name        nvarchar(250)          not null,
    Description nvarchar(250),
    Price       decimal(10, 5),
    IsHidden    bit  default 1,
    CreatedDate date default getdate() not null
)

create table BookCategoryMapping
(
    Id         int identity (1,1) primary key,
    BookId     int foreign key references Book (Id) not     null,
    CategoryId int foreign key references Category (Id) not null
)

create table Users
(
    Id          int identity (1,1) primary key,
    UserName    varchar(250)           not null,
    [Password]  varchar(250)           not null,
    FullName    nvarchar(250)          not null,
    CreatedDate date default getdate() not null
)
create table BookOrder
(
    Id          int identity (1,1) primary key,
    UserId      int                    not null foreign key references Users (Id),
    BookId      int                    not null foreign key references Book (Id),
    CreatedDate date default getdate() not null
)

create procedure [dbo].[BookCategoryMap] @BookId int, @CategoryIdArrays varchar(max)
as
begin
    declare @CategoryIdArraySlice varchar(max) = substring(@CategoryIdArrays, 2, len(@CategoryIdArrays) - 2)
    if len(@CategoryIdArraySlice) = 0
        return

    insert into BookCategoryMapping (BookId, CategoryId)
    SELECT @BookId, value
    FROM string_split(@CategoryIdArraySlice, ',')
end
GO

insert into Category(Name)
values ('Test')

select *
from Category