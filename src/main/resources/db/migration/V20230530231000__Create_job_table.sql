CREATE SEQUENCE IF NOT EXISTS job_id_seq START 1;

CREATE TABLE IF NOT EXISTS cd.job (
    id BIGINT DEFAULT nextval('job_id_seq') PRIMARY KEY,
    users_id BIGINT NOT NULL,
    company VARCHAR(50) NOT NULL,
    position VARCHAR(50) NOT NULL,
    start_date DATE,
    end_date DATE,
    job_description_id BIGINT,
    FOREIGN KEY (users_id) REFERENCES cd.users (id)
);