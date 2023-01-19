CREATE DATABASE Gite;

USE Gite;

CREATE TABLE Chambres (
    id INTEGER PRIMARY KEY,
    nom VARCHAR(20),
    type VARCHAR(20),
    places INTEGER,
    douche BOOLEAN,
    image VARCHAR(255)
);

CREATE TABLE Clients (
    id INTEGER PRIMARY KEY,
    nom VARCHAR(20),
    prenom VARCHAR(20),
    email VARCHAR(50),
    numero VARCHAR(20)
);

CREATE TABLE Salles (
    id INTEGER PRIMARY KEY,
    nom VARCHAR(20),
    type VARCHAR(20),
    capacite INTEGER,
    image VARCHAR(255)
);

CREATE TABLE Actualites (
    id INTEGER PRIMARY KEY,
    nom VARCHAR(20),
    description VARCHAR(255),
    premièreImage VARCHAR(255),
    secondeImage VARCHAR(255),
    troisiemeImage VARCHAR(255),
    quatriemeImage VARCHAR(255),
    date DATE
);

CREATE TABLE Reservations (
    id INTEGER PRIMARY KEY,
    evenement VARCHAR(255),
    valide BOOLEAN,
    dateDebut VARCHAR(255),
    duree INTEGER,
    chambres INTEGER,
    salles INTEGER,
    client INTEGER,
    FOREIGN KEY (chambres) REFERENCES chambres(id),
    FOREIGN KEY (salles) REFERENCES salles(id),
    FOREIGN KEY (client) REFERENCES clients(id)
);

CREATE TABLE Avis (
  id INT PRIMARY KEY,
  nom VARCHAR(255),
  prenom VARCHAR(255),
  commentaire VARCHAR(255),
  email VARCHAR(255),
  note INT
);

ALTER TABLE Avis MODIFY id INT NOT NULL AUTO_INCREMENT;

INSERT INTO `Actualites` (`id`, `nom`, `description`, `premièreImage`, `secondeImage`, `troisiemeImage`, `quatriemeImage`, `date`) VALUES
(1, 'Mariage Champêtre', 'La saison des mariages n’est pas fini, mariage d’automne ce week-end.\r\n\r\n#mariagechampetre #maineetloire #bassesvalleesangevines #rivesduloirenanjou #salledereceptionmariage #salledereceptionavechebergements', '../img/Actualites/premier_post/premier_post.jpg', '../img/Actualites/premier_post/premier_post_2.jpg', '../img/Actualites/premier_post/premier_post_3.jpg', '../img/Actualites/premier_post/premier_post_4.jpg', '2022-10-08'),
(2, 'Les extérieurs', 'Nos espaces extérieurs et la salle en mode banquet #salledereception #bibou #mariagechampetre #bassesvalleesangevines #romaintouzé #hebergementsinsolites', '../img/Actualites/second_post/second_post.jpg', '../img/Actualites/second_post/second_post_2.jpg', '../img/Actualites/second_post/second_post_3.jpg', '../img/Actualites/second_post/second_post_4.jpg', '2022-07-24'),
(3, 'Mariage au logis', 'Mariage au logis #mariage #decomariage #lydiefleurs #salledereception #maineetloire #bassesvalleesangevines #mariagehebergement', '../img/Actualites/troisieme_post/troisieme_post.jpg', '../img/Actualites/troisieme_post/troisieme_post_2.jpg', '../img/Actualites/troisieme_post/troisieme_post_3.jpg', '../img/Actualites/troisieme_post/troisieme_post_4.jpg', '2022-07-10'),
(4, 'Robe de mariée', 'Robe de mariée de Blandine\r\n\r\n#robedemariee #mariage #mariagechic #cheval #salledereception #hebergementinsolite', '../img/Actualites/quatrieme_post/quatrieme_post.jpg', NULL, NULL, NULL, '2022-06-26');

INSERT INTO `Avis` (`id`, `nom`, `prenom`, `commentaire`, `email`, `note`) VALUES
(1, 'Théo', 'SUEUR', 'Le logis fut fameux.', 'ttsueur62600@gmail.com', '3'),
(2, 'Blois', 'Hugo', 'Le logis était incroyable.', 'hugoblois@gmail.com', '5'),
(3, 'Guilpin', 'Erwan', 'Les hôtes nous ont très très bien reçus.', 'erwanguilpin@gmail.com', '5'),
(4, 'Souletis', 'Clovis', 'Amazing !!!!!!!!!!', 'cloclo@gmail.com', '5');

INSERT INTO `Clients`(`id`, `nom`, `prenom`, `email`, `numero`) VALUES 
(1,"Erwan","Guilpin","erwanguilpin@gmail.com","0672348867"),
(2,"Hugo","Blois","hugoblois@coucou.fr","0675473298");

INSERT INTO `Chambres`(`id`, `nom`, `type`, `places`, `douche`, `image`) VALUES
(1, "Chêne", "Double", 2, 0, NULL),
(2, "Peuplier", "Double", 2, 0, NULL),
(3, "Abricot", "Double", 2, 0, NULL),
(4, "Fôret", "Dortoir", 7, 1, NULL),
(5, "Le site", "Le domaine", 13, 1, NULL),
(6, "Aucune", "N/A", 0, 0, NULL);

INSERT INTO `Salles`(`id`, `nom`, `type`, `capacite`, `image`) VALUES
(1, "Salle des fêtes", "Fête", 90, NULL),
(2, "Bar", "Chill", 40, NULL),
(3, "Le site", "Maraiage", 130, NULL),
(4, "Aucune", "N/A", 0, NULL);