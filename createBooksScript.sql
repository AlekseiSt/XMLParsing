create table BOOKS
(
	BOOK_ID NUMBER not null
		primary key,
	X_TITLE VARCHAR2(255),
	X_DATE VARCHAR2(32),
	X_ISBN VARCHAR2(32),
	X_PUBLISHER VARCHAR2(255),
	X_COST VARCHAR2(32)
)
/

create trigger BOOKS_INCR
	before insert
	on BOOKS
	for each row
BEGIN
  SELECT dept_seq.NEXTVAL
  INTO   :new.book_id
  FROM   dual;
END;
/