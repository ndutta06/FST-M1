REM   Script: Activity7
REM   Activity7

-- Write an SQL statement to find the total purchase amount of all orders.
select SUM(purchase_amount) AS "sum" from orders;

-- Write an SQL statement to find the average purchase amount of all orders.
select AVG(purchase_amount) AS "Avg" from orders;

-- Write an SQL statement to get the maximum purchase amount of all the orders.
select MAX(purchase_amount) AS "Max" from orders;

-- Write an SQL statement to get the minimum purchase amount of all the orders.
select MIN(purchase_amount) AS "Min" from orders;

-- Write an SQL statement to find the number of salesmen listed in the table.
select count(distinct salesman_id) AS "Total count" from orders;