CREATE SEQUENCE IF NOT EXISTS job_description_id_seq START 1;

CREATE TABLE IF NOT EXISTS cd.job_description (
    id BIGINT  DEFAULT nextval('job_description_id_seq')PRIMARY KEY,
    programming_language VARCHAR(200),
    framework VARCHAR(300),
    tool VARCHAR(200),
    testing VARCHAR(200),
    database VARCHAR(200),
    interest VARCHAR(200),
    job_id BIGINT,
    FOREIGN KEY (job_id) REFERENCES cd.job (id)
);