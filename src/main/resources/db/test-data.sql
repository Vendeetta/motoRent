insert into public.users (id, update_date, create_date, last_name, first_name, patronymic, username, password, email,
                          role)
values (1, '2020-06-18 02:22:48.000000', '2017-07-18 02:22:55.000000', 'Петров', 'Пётр', 'Петрович', 'Petr', '$2y$10$zshJBlFOldBw0bBksod1hu9LlIx52Ghe0uquTVVjkwMftfsN5EZoe',
        'petr@mail.ru', 'NON_AUTH'),
       (2, '2017-08-23 02:22:48.000000', '2019-06-12 02:22:55.000000', 'Иванов', 'Иван', 'Иванович', 'Ivan', '$2y$10$lH1eb6HsHLAfQxPCz7MtKe7riUr6KVRre30lTa9AhM7wj5zfZcn6i',
        'ivan@mail.ru', 'USER'),
       (3, '2022-06-18 02:22:48.000000', '2015-07-18 02:22:55.000000', 'Волкова', 'Елена', 'Константиновна', 'volkova',
        '$2y$10$Vwr2c46MRZMJ56SZVRPm4eVcL9lzn398S5KNb4u7/HsjWend9u3mG', 'volkova@mail.ru', 'MANAGER'),
       (4, '2020-06-18 02:22:48.000000', '2017-07-18 02:22:55.000000', 'Админов', 'Админ', 'Админович', 'Admin',
        '$2y$10$O1ZF8raxfpjYdZcXV/zMg.R3F1hWVl7b6r1HzHKoRlAw66box.t3C', 'admin@mail.ru', 'ADMINISTRATOR');

insert into public.manager (id, position)
values (3, 'God');

insert into public.customer (id)
values (1),
       (2);

insert into public.address (id, update_date, create_date, country, zip_code, region, city, street, number_house, corpus,
                            apartment)
values (1, '2023-05-16 01:50:07.000000', '2023-05-16 01:50:12.000000', 'Россия', '343403', 'Краснодарский край',
        'Краснодар', 'Советов', '32', '1', '23'),
       (2, '2023-05-16 01:50:07.000000', '2023-05-16 01:50:12.000000', 'Россия', '343404', 'Краснодарский край',
        'Краснодар', 'Жукова', '3', 'null', 'null'),
       (3, '2023-05-16 01:50:07.000000', '2023-05-16 01:50:12.000000', 'Россия', '343333', 'Московская область',
        'Москва', 'Главная', '66', 'null', 'null');

insert into public.vehicle_info (id, vin_code, mark, color, model, number, power_hors, power_kvt, working_volume,
                                 type_engine, year, category, type, chassis, body, special_marks, max_mass, netto_mass)
values (1, 'SDFDF231231242', 'HONDA', 'ЧЕРНЫЙ', 'VFR800', '3232ВА23', 123, 43, 800, 'БЕНЗИНОВЫЙ', 2003, 'A', 'МОТОЦИКЛ',
        'SDFDF231231242', 'ОТСУТСВУЕТ', null, 234, 200),
       (2, 'ОТСУТСВУЕТ', 'YAMAHA', 'СИНИЙ', 'FZ6', '2325ЛВ43', 79, 23, 600, 'БЕНЗИНОВЫЙ', 2009, 'A', 'МОТОЦИКЛ',
        'GY-321512', 'ОТСУТСВУЕТ', null, 202, 145);



insert into public.documents (id, type_document, sub_type_document, serial, number, issued_by, date_of_issue, valid_for)
values (1, 10, 'Паспорт транспортного средства', '23ОУ', '435332', 'Московская таможня', '2021-05-16', null);

insert into public.vehicle_passport(id, vehicle_info_id, manufacturer, country_export, customs_restrictions, owner)
values (1, 1, 'ХОНДА МОТОРС', 'JAPAN', null, null);

insert into public.documents (id, type_document, sub_type_document, serial, number, issued_by, date_of_issue, valid_for)
values (2, 6, 'Свидетельство о регистрации ТС', '4134', '432332', 'ГИБДД 23112', '2018-03-16', null);

insert into certificate_d_immatriculation (id, vehicle_info)
values (2, 1);

insert into public.documents (id, type_document, sub_type_document, serial, number, issued_by, date_of_issue, valid_for)
values (3, 10, 'Паспорт транспортного средства', '3441', '432332', 'Тульская таможня', '2018-03-16', null);

insert into public.vehicle_passport(id, vehicle_info_id, manufacturer, country_export, customs_restrictions, owner)
values (3, 2, 'ЯМАХА МОТОРС', 'JAPAN', null, null);

insert into public.documents (id, type_document, sub_type_document, serial, number, issued_by, date_of_issue, valid_for)
values (4, 6, 'Свидетельство о регистрации ТС', '2134', '412732', 'ГИБДД 4532', '2019-05-16', null);

insert into public.certificate_d_immatriculation (id, vehicle_info)
values (4, 2);

