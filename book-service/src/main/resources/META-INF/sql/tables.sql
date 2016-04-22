create table BOOK_Book (
	uuid_ VARCHAR(75) null,
	bookId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	bookName VARCHAR(75) null,
	bookAbstract VARCHAR(75) null,
	bookAuthorName VARCHAR(75) null,
	bookOnlinePdf BOOLEAN,
	bookPageCount INTEGER,
	bookPublishDate DATE null
);