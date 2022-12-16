CREATE DATABASE gite;

USE gite;

CREATE TABLE inventaire (
    Id INTEGER PRIMARY KEY,
    Materiel VARCHAR(20),
    Quantite INTEGER,
    Etat ENUM('bon', 'moyen', 'mauvais'),
    Lieu VARCHAR(20)
);

CREATE TABLE Chambres (
    Id INTEGER PRIMARY KEY,
    Nom VARCHAR(20),
    Type VARCHAR(20),
    Places INTEGER,
    Douche BOOLEAN,
    Image VARCHAR(255)
);

CREATE TABLE Clients (
    Id INTEGER PRIMARY KEY,
    Nom VARCHAR(20),
    Prenom VARCHAR(20),
    Email VARCHAR(20),
    Numero VARCHAR(20)
);

CREATE TABLE Salles (
    Id INTEGER PRIMARY KEY,
    Nom VARCHAR(20),
    Type VARCHAR(20),
    Capacite INTEGER,
    Image VARCHAR(255)
);

CREATE TABLE Reservations (
    Id INTEGER PRIMARY KEY,
    Type VARCHAR(20),
    Valide BOOLEAN,
    Date DATE,
    Duree INTEGER,
    Chambres INTEGER,
    FOREIGN KEY (Chambres) REFERENCES Chambres(Id),
    FOREIGN KEY (Salles) REFERENCES Salles(Id),
    FOREIGN KEY (Client) REFERENCES Clients(Id)
);