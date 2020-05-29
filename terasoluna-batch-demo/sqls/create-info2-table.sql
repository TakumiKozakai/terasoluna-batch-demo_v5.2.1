CREATE TABLE IF NOT EXISTS info2 (
    id CHAR(8),
    type CHAR(1),
    status CHAR(1),
    point INT,
    create_date TIMESTAMP,
    update_date TIMESTAMP,
    delete_flg INT,
    PRIMARY KEY(id)
);