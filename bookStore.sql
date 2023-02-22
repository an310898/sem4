USE master;
GO
DROP DATABASE IF EXISTS BOOKSTORE;
GO
CREATE DATABASE BOOKSTORE;
GO
USE BOOKSTORE;
GO


CREATE TABLE Category
(
    Id INT IDENTITY(1, 1) PRIMARY KEY,
    Name NVARCHAR(100) NOT NULL,
    CreatedDate DATE
        DEFAULT GETDATE() NOT NULL
);
CREATE TABLE Book
(
    Id INT IDENTITY(1, 1) PRIMARY KEY,
    Name NVARCHAR(250) NOT NULL,
    Description NVARCHAR(250),
	Image NVARCHAR(max),
    Author NVARCHAR(250) NOT NULL,
    Price DECIMAL(10, 5) NOT NULL,
    IsHidden BIT
        DEFAULT 1,
    CreatedDate DATE
        DEFAULT GETDATE() NOT NULL
);

CREATE TABLE BookCategoryMapping
(
    Id INT IDENTITY(1, 1) PRIMARY KEY,
    BookId INT
        FOREIGN KEY REFERENCES Book (Id) NOT NULL,
    CategoryId INT
        FOREIGN KEY REFERENCES Category (Id) NOT NULL
);

CREATE TABLE Users
(
    Id INT IDENTITY(1, 1) PRIMARY KEY,
    UserName VARCHAR(250) NOT NULL,
    [Password] VARCHAR(250) NOT NULL,
    FullName NVARCHAR(250) NOT NULL,
    CreatedDate DATE
        DEFAULT GETDATE() NOT NULL
);
CREATE TABLE BookOrder
(
    Id INT IDENTITY(1, 1) PRIMARY KEY,
    UserId INT NOT NULL
        FOREIGN KEY REFERENCES Users (Id),
    BookId INT NOT NULL
        FOREIGN KEY REFERENCES Book (Id),
    CreatedDate DATE
        DEFAULT GETDATE() NOT NULL
);

GO

CREATE PROCEDURE [dbo].[BookCategoryMap]
    @BookId INT,
    @CategoryIdArrays VARCHAR(MAX)
AS
BEGIN
    DECLARE @CategoryIdArraySlice VARCHAR(MAX) = SUBSTRING(@CategoryIdArrays, 2, LEN(@CategoryIdArrays) - 2);
    IF LEN(@CategoryIdArraySlice) = 0
        RETURN;

    INSERT INTO BookCategoryMapping
    (
        BookId,
        CategoryId
    )
    SELECT @BookId,
           value
    FROM STRING_SPLIT(@CategoryIdArraySlice, ',');
END;
GO

INSERT INTO Category
(
    Name
)
VALUES
('Test');

SELECT *
FROM Category;