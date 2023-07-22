REM   Script: Activity4
REM   Activity4

--Alter -Activity 4
alter table salesman add grade int;
update salesman set grade =100;
select * from salesman;