CREATE TABLE product_tb(
    id int auto_increment primary key,
    name varchar unique not null,
    price int not null,
    qty int not null,
    created_at timestamp not null
);
