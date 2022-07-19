# CoffeeMaker - программа по управлению кофеваркой через браузер.

## Возможности:
1) Включение/выключение кофеварки.
2) Проверка наличия зерен/молока/воды в кофеварке
3) Функция наполнения зерен/молока/воды в кофеварку.
4) Приготовление различных видов кофе(латте, капучино, американо, эспрессо, черный кофе). 
5) Возможность устанавливать крепость кофе(low, medium, hard).
6) В зависимости от типа и крепости кофе тратится разное количество зерен/молока/воды.
7) Все манипуляции с кофеваркой записываются в БД Postgres.
8) Взаимодействие с интерфейсом кофеварки реализуется через SwaggerUI. 
Ссылка: http://localhost:8080/swagger-ui/index.html?configUrl=/api-docs/swagger-config#/
9) Перед тем, как сварить кофе, необходимо включить кофеварку.

## Используемый стек технологий:
Java 11, Spring Boot, PostgresSQL, SwaggerUI, Lombok, Hibernate, JRA repository, модель MVC, Gradle, в построении приложении использовался подход REST FULL APPLICATION. 
