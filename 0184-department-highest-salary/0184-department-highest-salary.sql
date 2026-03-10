# Write your MySQL query statement below
-- select d.name as Department,e.name as Employee ,max(e.salary) as Salary
with 
dept_sal(Dept,high_sal) as 
(
    select departmentId, max(salary)
    from Employee 
    group by departmentId
)
select d.name as Department,e.name as Employee ,e.salary as Salary
from Employee e join  Department d on e.departmentId=d.id join  dept_sal on d.id=dept_sal.Dept
where  e.salary=high_sal