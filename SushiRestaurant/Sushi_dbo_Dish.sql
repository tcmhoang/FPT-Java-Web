create table Dish
(
    id int not null
        primary key,
    name varchar(50) not null,
    description text,
    price decimal
)
go

INSERT INTO Sushi.dbo.Dish
    (id, name, description, price)
VALUES
    (1, N'Claritas est etiam processus', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.', 15);
INSERT INTO Sushi.dbo.Dish
    (id, name, description, price)
VALUES
    (2, N'Duis autem vel eum iriure dolor.', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.', 20);
INSERT INTO Sushi.dbo.Dish
    (id, name, description, price)
VALUES
    (3, N'Eodem modo typi, qui nunc nobis videntur.', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.', 25);