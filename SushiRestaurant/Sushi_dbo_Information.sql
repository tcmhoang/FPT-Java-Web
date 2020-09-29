create table Information
(
    id      int not null
        primary key,
    type    varchar(50),
    summary varchar(50),
    content text
)
go

INSERT INTO Sushi.dbo.Information (id, type, summary, content) VALUES (1, N'imgCover', N'imgCover', N'i282319414620330848._szw1280h1280_.jpg');
INSERT INTO Sushi.dbo.Information (id, type, summary, content) VALUES (2, N'address', N'address', N'The Sushi Restaurant
ew York, Y, USA');
INSERT INTO Sushi.dbo.Information (id, type, summary, content) VALUES (3, N'tel', N'tel', N'01633911325');
INSERT INTO Sushi.dbo.Information (id, type, summary, content) VALUES (4, N'mail', N'mail', N'hoangnmhe130341@fpt.edu.vn');
INSERT INTO Sushi.dbo.Information (id, type, summary, content) VALUES (5, N'work', N'Monday', N'Closed');
INSERT INTO Sushi.dbo.Information (id, type, summary, content) VALUES (6, N'work', N'Tuesday', N'12 - 22');
INSERT INTO Sushi.dbo.Information (id, type, summary, content) VALUES (7, N'work', N'Wednesday', N'12 - 22');
INSERT INTO Sushi.dbo.Information (id, type, summary, content) VALUES (8, N'work', N'Thursday', N'12 - 22');
INSERT INTO Sushi.dbo.Information (id, type, summary, content) VALUES (9, N'work', N'Friday', N'11 - 23');
INSERT INTO Sushi.dbo.Information (id, type, summary, content) VALUES (10, N'work', N'Saturday', N'11 - 23');
INSERT INTO Sushi.dbo.Information (id, type, summary, content) VALUES (11, N'work', N'Sunday', N'11 - 22');