# Write your MySQL query statement below
select unique_id,name from employees t1 left join employeeuni t2 on 
t1.id=t2.id 