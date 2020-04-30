CREATE DATABASE portal_realNews;

USE portal_realNews;

CREATE TABLE realNews (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
descricao VARCHAR(512),
titulo VARCHAR(126),
texto TEXT
);

CREATE TABLE comentario (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(126),
texto VARCHAR(512),
fk_noticia_id INT NOT NULL,
FOREIGN KEY (fk_noticia_id)
REFERENCES noticia(id)
);