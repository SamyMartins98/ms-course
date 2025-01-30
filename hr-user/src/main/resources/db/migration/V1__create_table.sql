CREATE TABLE tb_role (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE tb_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE tb_user_role (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES tb_user(id),
    FOREIGN KEY (role_id) REFERENCES tb_role(id)
);
