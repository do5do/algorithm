-- july의 flavor는 하나 이상일 수 있다.
SELECT j.flavor
from first_half h join (
    select flavor, sum(total_order) total_order
    from july
    group by flavor
) j 
on h.flavor = j.flavor
order by h.total_order + j.total_order desc
limit 3;