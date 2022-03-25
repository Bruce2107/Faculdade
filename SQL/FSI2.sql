CREATE DATABASE Auditoria;
USE Auditoria;

CREATE TABLE Usuario (
    Id int auto_increment,
    Nome varchar(50) NOT NULL,
    Permissao varchar(20) NOT NULL,
    Senha varchar(50) NOT NULL,
    PRIMARY KEY (Id)
);

CREATE TABLE Diretorio (
    Id int auto_increment,
    Nome varchar(50) NOT NULL,
    Caminho varchar(100) NOT NULL,
    PRIMARY KEY (Id)
);

CREATE TABLE Acesso (
    Id int auto_increment,
    Id_Usuario int NOT NULL,
    Id_Caminho int NOT NULL,
    FOREIGN KEY (Id_Usuario) REFERENCES Usuario(Id),
    FOREIGN KEY (Id_Caminho) REFERENCES Diretorio(Id),
    PRIMARY KEY (Id)
);


DELIMITER $$
    CREATE PROCEDURE InserirDadosUsuario(vNome varchar(50), vPermissao varchar(20),vSenha varchar(50))
BEGIN
    INSERT INTO Usuario (Nome, Permissao, Senha) VALUES (vNome, vPermissao, vSenha);
END $$
DELIMITER ;

CALL InserirDadosUsuario("Nyller","Admin", "21341");
CALL InserirDadosUsuario("Garrafa","Common","34235");
CALL InserirDadosUsuario("Desktoper","Common","324245");
SELECT * FROM Usuario;


DELIMITER $$
    CREATE PROCEDURE InserirDadosDiretorio(vNome varchar(50), 
                                         vCaminho varchar(100)
                                        )
BEGIN
    INSERT INTO Diretorio (Nome, Caminho) VALUES (vNome, vCaminho);
END $$
DELIMITER ;

CALL InserirDadosDiretorio("Foto de perfil", "/home/pictures/profile.png");
SELECT * FROM Diretorio

DELIMITER $$
    CREATE PROCEDURE InserirDadosAcesso(vId_Usuario int, vId_Caminho int)
BEGIN
    INSERT INTO Acesso (Id_Usuario, Id_Caminho) VALUES (vId_Usuario, vId_Caminho);
END $$
DELIMITER ;

CALL InserirDadosAcesso(1,1);
CALL InserirDadosAcesso(2,1);

SELECT * FROM Acesso;

DELIMITER $$
    CREATE PROCEDURE BuscarAcessos(vId_Usuario int)
BEGIN
    SELECT u.Nome as "Nome Usuario", d.Nome as "Nome Arquivo", d.Caminho as "Caminho" FROM Acesso a INNER JOIN Usuario u ON a.Id_Usuario = vId_Usuario AND u.Id = vId_Usuario INNER JOIN Diretorio d ON d.Id = a.Id_Caminho;
END $$
DELIMITER ;

CALL BuscarAcessos(1);
CALL BuscarAcessos(2);