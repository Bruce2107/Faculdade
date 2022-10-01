create database video_player;
use video_player;

create table if not exists Movie(
  id int not null auto_increment,
  name varchar(50) not null,
  duration int not null,
  synopsis varchar(100) not null,
  year int not null,
  primary key(id)
);

create table if not exists Gender(
  id int not null auto_increment,
  name varchar(20) not null,
  primary key(id)
);

create table if not exists Studio(
  id int not null auto_increment,
  name varchar(50) not null,
  primary key(id)
);

create table if not exists Subtitle(
  id int not null auto_increment,
  language varchar(20) not null,
  primary key(id)
);

create table if not exists Nation(
  id int not null auto_increment,
  name varchar(20) not null,
  language varchar(20) not null,
  primary key(id)
);

create table if not exists Screenwriter(
  id int not null auto_increment,
  name varchar(50) not null,
  primary key(id)
);

create table if not exists Director(
  id int not null auto_increment,
  name varchar(50) not null,
  primary key(id)
);

create table if not exists Actor(
  id int not null auto_increment,
  name varchar(50) not null,
  amount_of_awards int not null,
  main_activity varchar(50) not null,
  age int not null,
  primary key(id)
);

create table if not exists Movie_Gender(
  id_movie int not null,
  id_gender int not null,
  primary key(id_movie,id_gender),
  foreign key (id_movie) references Movie(id),
  foreign key (id_gender) references Gender(id)
);

create table if not exists Movie_Studio(
  id_movie int not null,
  id_studio int not null,
  primary key(id_movie,id_studio),
  foreign key (id_movie) references Movie(id),
  foreign key (id_studio) references Studio(id)
);

create table if not exists Movie_Subtitle(
  id_movie int not null,
  id_subtitle int not null,
  primary key(id_movie,id_subtitle),
  foreign key (id_movie) references Movie(id),
  foreign key (id_subtitle) references Subtitle(id)
);

create table if not exists Movie_Nation(
  id_movie int not null,
  id_nation int not null,
  primary key(id_movie,id_nation),
  foreign key (id_movie) references Movie(id),
  foreign key (id_nation) references Nation(id)
);

create table if not exists Movie_Screenwriter(
  id_movie int not null,
  id_screenwriter int not null,
  primary key(id_movie,id_screenwriter),
  foreign key (id_movie) references Movie(id),
  foreign key (id_screenwriter) references Screenwriter(id)
);

create table if not exists Movie_Director(
  id_movie int not null,
  id_director int not null,
  primary key(id_movie,id_director),
  foreign key (id_movie) references Movie(id),
  foreign key (id_director) references Director(id)
);

create table if not exists Movie_Actor(
  id_movie int not null,
  id_actor int not null,
  primary key(id_movie,id_actor),
  foreign key (id_movie) references Movie(id),
  foreign key (id_actor) references Actor(id)
);

create table if not exists Nation_Actor(
  id_nation int not null,
  id_actor int not null,
  primary key(id_nation,id_actor),
  foreign key (id_nation) references Nation(id),
  foreign key (id_actor) references Actor(id)
);

DELIMITER $$
  CREATE PROCEDURE InsertMovie(vName varchar(50), vDuration int,VSynopsis varchar(100), vYear int)
  BEGIN
    INSERT INTO Movie (name, duration, synopsis, year) VALUES (vName, vDuration, VSynopsis, vYear);
  END $$
DELIMITER ;

DELIMITER $$
  CREATE PROCEDURE InsertGender(vName varchar(20))
  BEGIN
      INSERT INTO Gender (name) VALUES (vName);
  END $$
DELIMITER ;

DELIMITER $$
  CREATE PROCEDURE InsertStudio(vName varchar(50))
  BEGIN
    INSERT INTO Studio (name) VALUES (vName);
  END $$
DELIMITER ;

DELIMITER $$
  CREATE PROCEDURE InsertSubtitle(vLanguage varchar(20))
  BEGIN
    INSERT INTO Subtitle (language) VALUES (vLanguage);
  END $$
DELIMITER ;

DELIMITER $$
  CREATE PROCEDURE InsertNation(vName varchar(20), vLanguage varchar(20))
  BEGIN
    INSERT INTO Nation (name, language) VALUES (vName, vLanguage);
  END $$
DELIMITER ;

DELIMITER $$
  CREATE PROCEDURE InsertScreenwriter(vName varchar(50))
  BEGIN
    INSERT INTO Screenwriter (name) VALUES (vName);
  END $$
DELIMITER ;

DELIMITER $$
  CREATE PROCEDURE InsertDirector(vName varchar(50))
  BEGIN
    INSERT INTO Director (name) VALUES (vName);
  END $$
DELIMITER ;

DELIMITER $$
  CREATE PROCEDURE InsertActor(vName varchar(50), vAmount_of_awards int, vMain_activity varchar(50), vAge int)
  BEGIN
    INSERT INTO Actor (name, amount_of_awards, main_activity, age) VALUES (vName, vAmount_of_awards, vMain_activity, vAge);
  END $$
DELIMITER ;

DELIMITER $$
  CREATE PROCEDURE InsertMovieGender(vId_Movie int, vId_Gender int)
  BEGIN
      INSERT INTO Movie_Gender (id_movie, id_gender) VALUES (vId_Movie, vId_Gender);
  END $$
DELIMITER ;

DELIMITER $$
  CREATE PROCEDURE InsertMovieStudio(vId_Movie int, vId_Studio int)
  BEGIN
      INSERT INTO Movie_Studio (id_movie, id_studio) VALUES (vId_Movie, vId_Studio);
  END $$
DELIMITER ;

DELIMITER $$
  CREATE PROCEDURE InsertMovieSubtitle(vId_Movie int, vId_Subtitle int)
  BEGIN
      INSERT INTO Movie_Subtitle (id_movie, id_subtitle) VALUES (vId_Movie, vId_Subtitle);
  END $$
DELIMITER ;

DELIMITER $$
  CREATE PROCEDURE InsertMovieNation(vId_Movie int, vId_Nation int)
  BEGIN
      INSERT INTO Movie_Nation (id_movie, id_nation) VALUES (vId_Movie, vId_Nation);
  END $$
DELIMITER ;

DELIMITER $$
  CREATE PROCEDURE InsertMovieScreenwriter(vId_Movie int, vId_Screenwriter int)
  BEGIN
      INSERT INTO Movie_Screenwriter (id_movie, id_screenwriter) VALUES (vId_Movie, vId_Screenwriter);
  END $$
DELIMITER ;

DELIMITER $$
  CREATE PROCEDURE InsertMovieDirector(vId_Movie int, vId_Director int)
  BEGIN
      INSERT INTO Movie_Director (id_movie, id_director) VALUES (vId_Movie, vId_Director);
  END $$
DELIMITER ;

DELIMITER $$
  CREATE PROCEDURE InsertMovieActor(vId_Movie int, vId_Actor int)
  BEGIN
      INSERT INTO Movie_Actor (id_movie, id_actor) VALUES (vId_Movie, vId_Actor);
  END $$
DELIMITER ;

DELIMITER $$
  CREATE PROCEDURE InsertNationActor(vId_Nation int, vId_Actor int)
  BEGIN
      INSERT INTO Nation_Actor (id_nation, id_actor) VALUES (vId_Nation, vId_Actor);
  END $$
DELIMITER ;

CALL InsertMovie("THX 1138", 88, "People in the future live in a totalitarian society.", 1971);
CALL InsertMovie("Hubie Halloween", 102, "Hubie Dubois, despite his devotion to his hometown of Salem", 2020);
CALL InsertMovie("Tombstone", 134, "Legendary marshal Wyatt Earp, now a weary gunfighter", 1993);
CALL InsertMovie("Tom & Jerry", 101, "Tom the cat and Jerry the mouse get kicked out of their", 2021);
CALL InsertMovie("The Gift", 112, "When a local woman disappears and the police can't seem to find any leads", 2000);
CALL InsertMovie("The SpongeBob Movie", 83, "When his best friend Gary is suddenly snatched away", 2020);

CALL InsertGender("Drama"); -- 1
CALL InsertGender("Mystery"); -- 2
CALL InsertGender("Sci-Fi");  -- 3
CALL InsertGender("Comedy");  -- 4
CALL InsertGender("Fantasy"); -- 5
CALL InsertGender("Horror");  -- 6
CALL InsertGender("Western"); -- 7
CALL InsertGender("Action");  -- 8
CALL InsertGender("Family");  -- 9
CALL InsertGender("Animation"); -- 10
CALL InsertGender("Thiller"); -- 11
CALL InsertGender("Adventure"); -- 12

CALL InsertStudio("American Zoetrope"); -- 1
CALL InsertStudio("Happy Madison Productions"); -- 2
CALL InsertStudio("Hollywood Pictures"); -- 3
CALL InsertStudio("Cinergi Pictures"); -- 4
CALL InsertStudio("Warner Bros. Pictures"); -- 5
CALL InsertStudio("Warner Animation Group"); -- 6
CALL InsertStudio("Lakeshore Entertainment"); -- 7
CALL InsertStudio("Paramount Animation"); -- 8
CALL InsertStudio("Nickelodeon Movies"); -- 9
CALL InsertStudio("United Plankton Pictures MRC"); -- 10

CALL InsertSubtitle("English");
CALL InsertSubtitle("Portuguese");
CALL InsertSubtitle("Mandarin");

CALL InsertNation("USA", "English");
CALL InsertNation("UK", "English");
CALL InsertNation("China", "Mandarin");
CALL InsertNation("Canada", "English");

CALL InsertScreenwriter("George Lucas");
CALL InsertScreenwriter("Tim Herlihy");
CALL InsertScreenwriter("Adam Sandler");
CALL InsertScreenwriter("Kevin Jarre");
CALL InsertScreenwriter("Kevin Costello");
CALL InsertScreenwriter("Billy Bob Thornton");
CALL InsertScreenwriter("Tom Epperson");
CALL InsertScreenwriter("Tim Hill");
CALL InsertScreenwriter("Jonathan Aibel Glenn Berger");

CALL InsertDirector("George Lucas");
CALL InsertDirector("Steven Brill");
CALL InsertDirector("George P. Cosmatos");
CALL InsertDirector("Tim Story");
CALL InsertDirector("Sam Raimi");
CALL InsertDirector("Tim Hill");

CALL InsertActor("Robert Duvall", 20, "The Godfather", 91);
CALL InsertActor("Adam Sandler", 22, "Punch-Drunk Love", 55);
CALL InsertActor("Val Kilmer", 2, "Top Secret!", 62);
CALL InsertActor("Chloë Grace Moretz", 10, "Kick-Ass", 25);
CALL InsertActor("Keanu Reeves", 7, "John Wick", 57);
CALL InsertActor("Tom Kenny", 4, "SpongeBob SquarePants", 59);

CALL InsertMovieGender(1,1);
CALL InsertMovieGender(1,2);
CALL InsertMovieGender(1,3);
CALL InsertMovieGender(2,4);
CALL InsertMovieGender(2,5);
CALL InsertMovieGender(2,2);
CALL InsertMovieGender(2,6);
CALL InsertMovieGender(3,7);
CALL InsertMovieGender(3,8);
CALL InsertMovieGender(4,8);
CALL InsertMovieGender(4,4);
CALL InsertMovieGender(4,9);
CALL InsertMovieGender(4,10);
CALL InsertMovieGender(5,6);
CALL InsertMovieGender(5,1);
CALL InsertMovieGender(5,11);
CALL InsertMovieGender(5,2);
CALL InsertMovieGender(6,10);
CALL InsertMovieGender(6,5);
CALL InsertMovieGender(6,12);
CALL InsertMovieGender(6,4);
CALL InsertMovieGender(6,9);

CALL InsertMovieStudio(1,1);
CALL InsertMovieStudio(2,2);
CALL InsertMovieStudio(3,3);
CALL InsertMovieStudio(3,4);
CALL InsertMovieStudio(4,5);
CALL InsertMovieStudio(4,6);
CALL InsertMovieStudio(5,7);
CALL InsertMovieStudio(6,8);
CALL InsertMovieStudio(6,9);
CALL InsertMovieStudio(6,10);

CALL InsertMovieSubtitle(1,1);
CALL InsertMovieSubtitle(1,2);
CALL InsertMovieSubtitle(2,1);
CALL InsertMovieSubtitle(2,3);
CALL InsertMovieSubtitle(3,1);
CALL InsertMovieSubtitle(3,2);
CALL InsertMovieSubtitle(3,3);
CALL InsertMovieSubtitle(4,3);
CALL InsertMovieSubtitle(5,1);
CALL InsertMovieSubtitle(6,2);
CALL InsertMovieSubtitle(6,3);

CALL InsertMovieNation(1,1);
CALL InsertMovieNation(2,1);
CALL InsertMovieNation(3,1);
CALL InsertMovieNation(4,1);
CALL InsertMovieNation(5,1);
CALL InsertMovieNation(6,1);

CALL InsertMovieScreenwriter(1,1);
CALL InsertMovieScreenwriter(2,2);
CALL InsertMovieScreenwriter(2,3);
CALL InsertMovieScreenwriter(3,4);
CALL InsertMovieScreenwriter(4,5);
CALL InsertMovieScreenwriter(5,6);
CALL InsertMovieScreenwriter(5,7);
CALL InsertMovieScreenwriter(6,8);
CALL InsertMovieScreenwriter(6,9);

CALL InsertMovieDirector(1,1);
CALL InsertMovieDirector(2,2);
CALL InsertMovieDirector(3,3);
CALL InsertMovieDirector(4,4);
CALL InsertMovieDirector(5,5);
CALL InsertMovieDirector(6,6);

CALL InsertMovieActor(1,1);
CALL InsertMovieActor(2,2);
CALL InsertMovieActor(3,3);
CALL InsertMovieActor(4,4);
CALL InsertMovieActor(5,5);
CALL InsertMovieActor(6,6);

CALL InsertNationActor(1,1);
CALL InsertNationActor(1,2);
CALL InsertNationActor(1,3);
CALL InsertNationActor(1,4);
CALL InsertNationActor(4,5);
CALL InsertNationActor(1,6);

SELECT * FROM Movie;
SELECT * FROM Gender;
SELECT * FROM Studio;
SELECT * FROM Subtitle;
SELECT * FROM Screenwriter;
SELECT * FROM Director;
SELECT * FROM Nation;
SELECT * FROM Actor;


SELECT name as Nome, year as Ano from Movie; --a
SELECT a.name as Nome, n.name as Nacionalidade from Actor a INNER JOIN Nation_Actor na on a.id = na.id_actor INNER JOIN Nation n on n.id = na.id_nation; --b
SELECT a.id as Código, a.name as Nome from Actor a WHERE a.amount_of_awards > 0 AND a.age BETWEEN 40 AND 50; --c
SELECT name as Nome, duration as "Duração (min)" from Movie; --d
SELECT a.name as Nome, a.age as Idade, n.name as Nacionalidade from Actor a INNER JOIN Nation_Actor na on a.id = na.id_actor INNER JOIN Nation n on n.id = na.id_nation; --e
SELECT AVG(a.age) as Média_Idade from Actor a INNER JOIN Nation_Actor na on a.id = na.id_actor AND na.id_nation = (SELECT n.id FROM Nation n WHERE n.name = "Brazil"); --f
SELECT MIN(a.age) as Média_Idade from Actor a INNER JOIN Nation_Actor na on a.id = na.id_actor AND na.id_nation = (SELECT n.id FROM Nation n WHERE n.name = "USA"); --g
SELECT a.name as Nome from Actor a WHERE a.amount_of_awards > 0; --h
SELECT n.name as Nacionalidade from Movie m INNER JOIN Movie_Nation mn on m.id = mn.id_movie INNER JOIN Nation n on n.id = mn.id_nation INNER JOIN Movie_Actor ma on m.id = ma.id_movie AND ma.id_actor = (SELECT a.id FROM Actor a INNER JOIN Nation_Actor na on a.id = na.id_actor AND na.id_nation = (SELECT n.id FROM Nation n WHERE n.name = "Canada")); --i
SELECT d.name as Diretor from Director d INNER JOIN Screenwriter s on d.name = s.name; --j

--a π name → nome, year → ano (Movie)
--b π a.name → nome, n.name → nacionalidade (Actor a ⋈ Nation_Actor NA ⋈ Nation n)
--c π a.id → código, a.name → nome σ a.amount_of_awards > 0 V (40 <= a . age V a . age <= 50) (Actor a)
--d π name → nome, duration → "duração (min)" (Movie)
--e π a.name → nome, a.age → idade, n.name → nacionalidade (Actor a ⋈ Nation_Actor NA ⋈ Nation n)
--f π AVG(a.age) → média_idade (σ n.name = "Brazil") (Actor a ⋈ Nation_Actor NA ⋈ Nation n)
--g π MIN(a.age) → média_idade (σ n.name = "USA") (Actor a ⋈ Nation_Actor NA ⋈ Nation n)
--h π a.name → nome(σ a.amount_of_awards > 0) (Actor a)
--i R1 <- π a.id (σ n.name = "Canada") (Actor a ⋈ Nation_Actor NA ⋈ Nation n)
--i π n.name → Nacionalidade (Movie m ⋈ Movie_Nation mn ⋈ Nation n ⋈ Movie_Actor MA ⋈ Actor a ⋈ Nation_Actor na ⋈ R1)
--j π d.name → Diretor (Screenwriter s ⋈ Director d)