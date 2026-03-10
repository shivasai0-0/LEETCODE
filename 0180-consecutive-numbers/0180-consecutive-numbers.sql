# Write your MySQL query statement below
select distinct p.num as ConsecutiveNums from logs p join logs q on p.id=q.id-1 join logs r on q.id=r.id-1 where p.num=q.num and q.num=r.num;