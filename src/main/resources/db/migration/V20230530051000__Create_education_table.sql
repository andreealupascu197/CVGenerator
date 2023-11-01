CREATE SEQUENCE education_id_seq START 1;

CREATE TABLE IF NOT EXISTS cd.education (
    id BIGINT DEFAULT nextval('education_id_seq') PRIMARY KEY,
    users_id BIGINT,
    name VARCHAR(50),
    country VARCHAR(50),
    county VARCHAR(50),
    diploma VARCHAR(50),
    profile VARCHAR(50),
    start_date DATE,
    end_date DATE,
    FOREIGN KEY (users_id) REFERENCES cd.users (id)
);


