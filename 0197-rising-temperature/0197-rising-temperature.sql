# Write your MySQL query statement below
select s.id
from Weather s join Weather t on datediff(s.recordDate,t.recordDate)=1
where s.temperature>t.temperature