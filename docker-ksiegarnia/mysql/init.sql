CREATE TABLE `ksiegarnia`
(
    `id`    int          NOT NULL AUTO_INCREMENT,
    `nazwa` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `autor`
(
    `id`        int          NOT NULL AUTO_INCREMENT,
    `imie`      varchar(255) NOT NULL,
    `nazwisko`  varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `ksiazka`
(
    `id`        int          NOT NULL AUTO_INCREMENT,
    `tytul`     varchar(255) NOT NULL,
    `ocena`     float DEFAULT NULL,
    `autor_id`  int   DEFAULT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`autor_id`) REFERENCES `autor`(`id`)
);

CREATE TABLE `ksiazka_ksiegarnia`
(
    `ksiazka_id`    int NOT NULL,
    `ksiegarnia_id` int NOT NULL,
    PRIMARY KEY (`ksiazka_id`, `ksiegarnia_id`),
    FOREIGN KEY (`ksiazka_id`) REFERENCES `ksiazka`(`id`),
    FOREIGN KEY (`ksiegarnia_id`) REFERENCES `ksiegarnia`(`id`)
);


INSERT INTO `autor`(`id`, `imie`, `nazwisko`) VALUES
                                                  (1, 'Olga', 'Tokarczuk'),
                                                  (2, 'Andrzej', 'Sapkowski'),
                                                  (3, 'Stanis�aw', 'Lem'),
                                                  (4, 'Wis�awa', 'Szymborska');


INSERT INTO `ksiegarnia`(`id`, `nazwa`) VALUES
                                            (1, 'Merlin Books'),
                                            (2, 'Empik Krak�w'),
                                            (3, 'Matras'),
                                            (4, 'Bonito Online');


INSERT INTO `ksiazka`(`id`, `tytul`, `ocena`, `autor_id`) VALUES
                                                              (1, 'Bieguni', 4.8, 1),
                                                              (2, 'Dom dzienny, dom nocny', 4.5, 1),
                                                              (3, 'Saga o Wied�minie', 4.9, 2),
                                                              (4, 'Krew elf�w', 4.6, 2),
                                                              (5, 'Solaris', 4.7, 3),
                                                              (6, 'Cyberiada', 4.4, 3),
                                                              (7, 'Koniec i pocz�tek', 4.9, 4),
                                                              (8, 'Wiersze wybrane', 4.3, 4);


INSERT INTO `ksiazka_ksiegarnia`(`ksiegarnia_id`, `ksiazka_id`) VALUES
                                                                    (1, 1), (1, 3), -- Merlin: Bieguni, Wied�min
                                                                    (2, 1), (2, 2), (2, 4), -- Empik: Bieguni, Dom dzienny, Krew elf�w
                                                                    (3, 5), (3, 6), (3, 3), -- Matras: Solaris, Cyberiada, Wied�min
                                                                    (4, 7), (4, 8), (4, 1); -- Bonito: Koniec i pocz�tek, Wiersze, Bieguni


CREATE TABLE user
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE role
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    role     VARCHAR(255)
);

INSERT INTO user(username, password)
VALUES ('dbuser1', 'dbuser1'),
       ('dbuser2', 'dbuser2'),
       ('dbuser3', 'dbuser3');


INSERT INTO role(username, role)
VALUES ('dbuser1', 'ROLE_ADMIN'),
       ('dbuser2', 'ROLE_AUTHOR_ADMIN'),
       ('dbuser3', 'ROLE_BOOK_ADMIN');