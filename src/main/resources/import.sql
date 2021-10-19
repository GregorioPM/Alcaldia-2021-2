INSERT INTO alcaldia(alcalde,correo,direccion,horario_atencion,logo,nombre,telefono) VALUES ('Gerson Gomez','acaldiaTachira@gmail.com','Calle 10 Tachira', '8AM A 6PM','','Alcaldia de Tachira','+565650255');

INSERT INTO usuario(email,apellidos,nombre,password,rol,id_alcaldia) VALUES('jose@gmail.com','Perez','Gregorio','$2a$10$x9QL2mkHqf7emophVVMyhuCIm8jEhtOhWQbR0TXOslK7NJoAmh7RW','ROLE_ADMIN',1);

INSERT INTO categoria(id_categoria,descripcion,orden,titulo) VALUES(1,'Para Deportes','Alta','Deportes Cucuteños');
INSERT INTO categoria(id_categoria,descripcion,orden,titulo) VALUES(2,'Para Deportes','Alta','Deportes Cucuteños');


INSERT INTO sub_categoria(id_sub_categoria,descripcion,orden,titulo,categoria_id) VALUES(1,'Para pruebas',2,'Contaduria',1);



