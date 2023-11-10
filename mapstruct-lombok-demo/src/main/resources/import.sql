insert into category (id, nombre, status) values (1, 'aaaaa', false);

insert into category (id, nombre, status) values (2, 'bbbbb', false);

insert into category (id, nombre, status) values (3, 'cccccc', true);

insert into
    product (
        id,
        nombre,
        creation_date,
        category_id
    )
values (
        1,
        'Chicken - White Meat, No Tender',
        '2022-12-25',
        1
    );

insert into
    product (
        id,
        nombre,
        creation_date,
        category_id
    )
values (
        2,
        'Beer - Sleemans Honey Brown',
        '2023-03-21',
        1
    );

insert into
    product (
        id,
        nombre,
        creation_date,
        category_id
    )
values (
        3,
        'Pasta - Penne Primavera, Single',
        '2023-05-06',
        2
    );

insert into
    product (
        id,
        nombre,
        creation_date,
        category_id
    )
values (
        4,
        'Cake - Cake Sheet Macaroon',
        '2022-11-27',
        2
    );

insert into
    product (
        id,
        nombre,
        creation_date,
        category_id
    )
values (
        5,
        'Nantucket - Carrot Orange',
        '2022-11-10',
        3
    );