CREATE SEQUENCE user_id_seq START 1;

CREATE TABLE IF NOT EXISTS cd.users (
    id BIGINT DEFAULT nextval('user_id_seq') PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone_number VARCHAR(50) NOT NULL,
    address VARCHAR(50),
    current_position VARCHAR(100),
    date_of_birth DATE
);
