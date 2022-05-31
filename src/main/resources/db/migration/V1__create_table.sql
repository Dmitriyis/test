CREATE TABLE lord
(
    id   bigserial primary key,
    name varchar(24),
    age  int
);

CREATE TABLE planet
(
    id      bigserial primary key,
    name    varchar(24),
    lord_id int,
    FOREIGN KEY (lord_id) REFERENCES lord (id)
)