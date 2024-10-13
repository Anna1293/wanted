1. Для поднятия контейнера с базой данных необходимо, в файлах проекта запустить docker-compose.yml .

2. Первый запуск приложения заполнит бд тестовыми данными.

3. Ссылка на свагер http://localhost:8080/swagger-ui/index.html#/

Описание api:
1. GET /api/wanted/getDateForSendingList
Метод определяет ближайшую дату отправки списка в страховую. Если дата отправки попадает на выходной день - то отправка осуществляется в предыдущий рабочий день.
Условия отправки: отправка осуществляется 1, 10 и 20 числа каждого месяца в 18:00.
Если запрос производится в один из указанных дней вне рабочее время выбирается следующая дата согласно условиям задачи.

2. GET /api/wanted/getStringValue/{number}
Метод возвращает прописное написание стоимости (максимальное значение 99999.99). Слова копейка и рубль склоняются в зависимости от возвращаемого значения.

3 GET /api/wanted/relatives/{personId}
Метод возвращает всех родственников работника по полю personId. Тип поля String. В базе данных находится запись с полем personId = "test". Запись имеет двух родственниковю. Вывод данных производится согласно заданию.

SQL
SQL запрос который выводит всех родственников (ФИО, дата рождение и родственнная связь) для сотрудника с personId ='test'.

select hppg.family_name, hppg.given_name, hppg.middle_name, hppg.birth_date, hppd.contact_relationship  
from hp_person_generic hppg
left join hp_person_dependant hppd on hppg.sys_id= hppd.hp_related_person_sys_id  
where hppd.hp_person_generic_sys_id  in (select sys_id from hp_person_generic where person_id = 'test'); 
