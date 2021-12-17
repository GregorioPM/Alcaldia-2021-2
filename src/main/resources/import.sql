INSERT INTO alcaldia(alcalde,correo,direccion,horario_atencion,logo,nombre,telefono) VALUES ('Gerson Gomez','acaldiaTachira@gmail.com','Calle 10 Tachira', '8AM A 6PM','','Alcaldia de Tachira','+565650255');

INSERT INTO usuario(email,apellidos,nombre,password,rol,id_alcaldia) VALUES('jose@gmail.com','Perez','Gregorio','$2a$10$x9QL2mkHqf7emophVVMyhuCIm8jEhtOhWQbR0TXOslK7NJoAmh7RW','ROLE_ADMIN',1);

INSERT INTO categoria(id_categoria,descripcion,orden,titulo) VALUES(1,'Para Deportes','Alta','Deportes Cucuteños');
INSERT INTO categoria(id_categoria,descripcion,orden,titulo) VALUES(2,'Para Deportes','Alta','Deportes Cucuteños');


INSERT INTO sub_categoria(id_sub_categoria,descripcion,orden,titulo,categoria_id) VALUES(1,'Para pruebas',2,'Contaduria',1);

insert into noticia(titulo,descripcion,usuario) values ("Sustentacion","Previo final","jose@gmail.com");

insert into foto (descripcion,id_noticia,usuario) values ("5f3207dd-e75d-4d8f-82be-feef44945782_2296.jpg",1,"jose@gmail.com");

Insert into evento (titulo,descripcion,categoria,alcaldia_id) values ("Evento Ejercicios","En el polideportivo","Deportes",1);

