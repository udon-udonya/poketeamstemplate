CREATE TABLE teams
(
    id SERIAL NOT NULL,
    title VARCHAR(255) NOT NULL,
    content VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    updated_at TIMESTAMP NOT NULL DEFAULT now(),
    PRIMARY KEY (id)
);
