-- 코드를 입력하세요
SELECT month(start_date) as month, car_id, count(car_id) as records
from car_rental_company_rental_history
where car_id in (
    select car_id from car_rental_company_rental_history
    where month(start_date) between 8 and 10
    group by car_id
    having count(*) >= 5
)
and month(start_date) between 8 and 10
group by car_id, month
order by month, car_id desc;