CREATE TABLE IF NOT EXISTS info1 (
    key CHAR(20),
    attr1 CHAR(20),
    attr2 CHAR(12),
    attr3 CHAR(34),
    attr4 CHAR(100),
    attr5 CHAR(50),
    attr6 CHAR(50),
    creater_name CHAR(40),
    create_date TIMESTAMP,
    updater_name CHAR(40),
    update_date TIMESTAMP,
    delete_flg INT,
    PRIMARY KEY(key)
);
