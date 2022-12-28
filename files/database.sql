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

CREATE TABLE Actualites (
    Id INTEGER PRIMARY KEY,
    Nom VARCHAR(20),
    Description VARCHAR(255),
    Image VARCHAR(255)
);

CREATE TABLE Reservations (
    Id INTEGER PRIMARY KEY,
    Type VARCHAR(20),
    Valide BOOLEAN,
    Date DATE,
    Duree INTEGER,
    Chambres INTEGER,
    Salles INTEGER,
    Client INTEGER,
    FOREIGN KEY (Chambres) REFERENCES Chambres(Id),
    FOREIGN KEY (Salles) REFERENCES Salles(Id),
    FOREIGN KEY (Client) REFERENCES Clients(Id)
);

INSERT INTO `actualites` (`Id`, `Nom`, `Description`, `PremièreImage`, `SecondeImage`, `TroisiemeImage`, `QuatriemeImage`, `date`) VALUES
(1, 'Mariage Champêtre', 'La saison des mariages n’est pas fini, mariage d’automne ce week-end.\r\n\r\n#mariagechampetre #maineetloire #bassesvalleesangevines #rivesduloirenanjou #salledereceptionmariage #salledereceptionavechebergements', '../img/Actualites/premier_post/premier_post.jpg', '../img/Actualites/premier_post/premier_post_2.jpg', '../img/Actualites/premier_post/premier_post_3.jpg', '../img/Actualites/premier_post/premier_post_4.jpg', '2022-10-08'),
(2, 'Les extérieurs', 'Nos espaces extérieurs et la salle en mode banquet #salledereception #bibou #mariagechampetre #bassesvalleesangevines #romaintouzé #hebergementsinsolites', '../img/Actualites/second_post/second_post.jpg', '../img/Actualites/second_post/second_post_2.jpg', '../img/Actualites/second_post/second_post_3.jpg', '../img/Actualites/second_post/second_post_4.jpg', '2022-07-24'),
(3, 'Mariage au logis', 'Mariage au logis #mariage #decomariage #lydiefleurs #salledereception #maineetloire #bassesvalleesangevines #mariagehebergement', '../img/Actualites/troisieme_post/troisieme_post.jpg', '../img/Actualites/troisieme_post/troisieme_post_2.jpg', '../img/Actualites/troisieme_post/troisieme_post_3.jpg', '../img/Actualites/troisieme_post/troisieme_post_4.jpg', '2022-07-10'),
(4, 'Robe de mariée', 'Robe de mariée de Blandine\r\n\r\n#robedemariee #mariage #mariagechic #cheval #salledereception #hebergementinsolite', '../img/Actualites/quatrieme_post/quatrieme_post.jpg', NULL, NULL, NULL, '2022-06-26');
