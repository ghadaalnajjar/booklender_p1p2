insert into book (book_id, available, description, fine_per_day, max_loans_days, reserved, title) values (null, true, "good", null, 30, true,"Hello Pippi" );

insert into library_user (user_id, email, name, reg_date) values (null, 'mmm@yahoo.com','Maha',null );

insert into library_user (user_id, email, name, reg_date) values (null, 'xb@yahoo.com','all','2020-11-12');

insert into loan (loan_id, book_book_id, loan_date, loan_taker_user_id, terminate) values (null, 1, null, 1, false);

