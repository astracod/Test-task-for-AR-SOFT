CREATE TABLE payments
(
    id BIGSERIAL primary key ,
    name varchar(255),
    supply_date timestamp,
    state boolean,
    part char(1),
    value bigint
);