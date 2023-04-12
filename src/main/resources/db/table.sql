CREATE TABLE product_tb(
    id int auto_increment primary key,
    name varchar not null unique,
    price int not null,
    qty int not null,
    created_at timestamp not null
);
