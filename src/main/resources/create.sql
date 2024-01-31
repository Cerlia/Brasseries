CREATE TABLE BRASSERIE
(
    id_brasserie INT AUTO_INCREMENT PRIMARY KEY,
    nom          VARCHAR(50) NOT NULL,
    adresse      VARCHAR(100),
    coord_gps    VARCHAR(50),
    dt_ouverture DATE
);

CREATE TABLE BIERE
(
    id_biere     INT AUTO_INCREMENT PRIMARY KEY,
    nom          VARCHAR(50) NOT NULL,
    type         VARCHAR(50),
    description  VARCHAR(150),
    dg_alcool    NUMERIC(4, 2),
    note         INT,
    id_brasserie INT         NOT NULL,
    CONSTRAINT FK_Biere_Brasserie FOREIGN KEY (id_brasserie) REFERENCES BRASSERIE (id_brasserie)
);