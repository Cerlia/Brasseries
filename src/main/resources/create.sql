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

INSERT INTO BRASSERIE (nom, adresse, coord_gps, dt_ouverture) VALUES ('Sainte-Colombe', 'Corps-Nuds', '254 123', '1986-12-3');
INSERT INTO BRASSERIE (nom, adresse, coord_gps, dt_ouverture) VALUES ('Saint-Omer', 'Saint-Omer', '23 156', '1975-4-3');
INSERT INTO BRASSERIE (nom, adresse, coord_gps, dt_ouverture) VALUES ('Kro', 'Kronembourg', '11 652', '1889-1-3');

INSERT INTO BIERE (nom, type, description, dg_alcool, note, id_brasserie)
    VALUES ('Sainte-Colombe', 'BLONDE', 'Une bière qui est bonne', 5.5, 4, 1);
INSERT INTO BIERE (nom, type, description, dg_alcool, note, id_brasserie)
    VALUES ('Leffe', 'BLONDE', 'Une bière qui est sympa', 5.5, 3, 2);
INSERT INTO BIERE (nom, type, description, dg_alcool, note, id_brasserie)
    VALUES ('Leffe', 'NOIRE', 'Une bière qui est noire', 7.5, 2, 2);