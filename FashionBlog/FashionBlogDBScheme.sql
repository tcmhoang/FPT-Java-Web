Create database FashionBlog;
use FashionBlog;
CREATE TABLE Categories (
	CategoryID int IDENTITY(1,1) PRIMARY KEY,
	CategoryName varchar(MAX)
);

CREATE TABLE Entries (
	EntryID int IDENTITY(1,1) PRIMARY KEY,
	CategoryID int REFERENCES Categories(CategoryID) NOT NULL,
	Heading varchar(MAX) NOT NULL,
	Published date NOT NULL,
	ImageName varchar(MAX),
	ImageCaption varchar(MAX),
	Author varchar(MAX),
	Content varchar(MAX)
);

CREATE TABLE Contact (
	CommentID int IDENTITY(1,1) PRIMARY KEY,
	Name varchar(MAX) NOT NULL,
	Email varchar(MAX) NOT NULL,
	Message varchar(MAX) NOT NULL
);

INSERT INTO Categories(CategoryName) VALUES
('Photo'),('Post');

INSERT INTO Entries(CategoryID,Heading,Published,ImageName,ImageCaption) VALUES
(1,'In New York',GETDATE(),'i284852689410723512._szw1280h1280_.jpg','Claritas est etiam processus dynamicus, qui sequitur');

INSERT INTO Entries(CategoryID,Heading,Published,ImageName,Content) VALUES
(2,'In New York',GETDATE(),'i284852689410723418._szw480h1280_.jpg','<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius.</p>');

INSERT INTO Entries(CategoryID,Heading,Published,ImageName,ImageCaption) VALUES
(1,'Awesome Gucci',GETDATE(),'i284852689410723250._szw1280h1280_.jpg','Claritas est etiam processus dynamicus, qui sequitur');

INSERT INTO Entries(CategoryID,Heading,Published,ImageName,ImageCaption) VALUES
(1,'Special Offer',GETDATE(),'i284852689410723270._szw1280h1280_.jpg','Claritas est etiam processus dynamicus, qui sequitur');