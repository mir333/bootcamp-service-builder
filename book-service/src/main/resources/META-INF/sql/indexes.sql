create index IX_391BC4D8 on BOOK_Book (bookAuthorName[$COLUMN_LENGTH:75$]);
create index IX_7F8046A1 on BOOK_Book (bookOnlinePdf);
create index IX_CF07959 on BOOK_Book (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D2C9821B on BOOK_Book (uuid_[$COLUMN_LENGTH:75$], groupId);