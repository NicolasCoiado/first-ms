CREATE TABLE tb_users (
    user_id UUID PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    account_locked BOOLEAN NOT NULL DEFAULT FALSE,
    user_role SMALLINT NOT NULL CHECK (user_role IN (0, 1)),
    email_verified BOOLEAN NOT NULL DEFAULT FALSE
);