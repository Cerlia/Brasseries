CREATE TABLE BRASSERIE (
    id_brasserie INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    adresse VARCHAR(100),
    coord_gps VARCHAR(50),
    dt_ouverture DATE
);