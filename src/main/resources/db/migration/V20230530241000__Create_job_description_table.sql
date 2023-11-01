CREATE SEQUENCE IF NOT EXISTS job_description_id_seq START 1;

CREATE TABLE IF NOT EXISTS cd.job_description (
    id BIGINT  DEFAULT nextval('job_description_id_seq')PRIMARY KEY,
    programming_languages VARCHAR(200),
    frameworks VARCHAR(300),
    tools VARCHAR(200),
    testing VARCHAR(200),
    database VARCHAR(200),
    interests VARCHAR(200),
    job_id BIGINT,
    FOREIGN KEY (job_id) REFERENCES cd.job (id)

);


