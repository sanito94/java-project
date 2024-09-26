CREATE TABLE user_table
(
    id            int auto_increment primary key,
    first_name    varchar(50) not null,
    last_name     varchar(50) not null,
    date_of_birth date,
    phone_number  varchar(50) not null,
    email         varchar(50) not null
)