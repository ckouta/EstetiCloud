/* insert barberos*/
INSERT INTO barberos (apellido,email,nombre,telefono) VALUES ("Booth, Uma G.","lectus@mauriselit.edu","Allen","1-883-183-551");
INSERT INTO barberos (apellido,email,nombre,telefono) VALUES ("Wall, Nathan C.","egestas@utodiovel.co.uk","Stone","1-542-994-189");
INSERT INTO barberos (apellido,email,nombre,telefono) VALUES ("Dalton, Deanna U.","vitae@tincidunt.net","Luke","1-358-484-158");
INSERT INTO barberos (apellido,email,nombre,telefono) VALUES ("Matthews, Cade A.","rutrultrices@ac.net","Keefe","1-186-661-529");
INSERT INTO barberos (apellido,email,nombre,telefono) VALUES ("Conway, Farrah W.","et.lacinia@etla.co.uk","Wynter","1-487-309-592");
INSERT INTO barberos (apellido,email,nombre,telefono) VALUES ("Gilliam, Kirby O.","facilorci@vitaeali.org","Kirby","1-720-484-375");
INSERT INTO barberos (apellido,email,nombre,telefono) VALUES ("Holt, Kane Y.","urna@magna","Roth","1-668-825-872");
INSERT INTO barberos (apellido,email,nombre,telefono) VALUES ("Guzman, Adria M.","porta.eli@augueport.edu","Jerry","1-779-591-256");
INSERT INTO barberos (apellido,email,nombre,telefono) VALUES ("Harvey, Thor B.","enim@aultricies.ca","Bevis","1-819-606-998");
INSERT INTO barberos (apellido,email,nombre,telefono) VALUES ("Cantrell, Baker O.","Vivamus@Crasint.ca","Debra","1-521-178-719");

/*insert clientes*/
INSERT INTO clientes (apellido,email,nombre,telefono) VALUES ("Holt, Kane Y.","urna.et.arcu@magnamalesuada.com","Roth","1-668-825-872");
INSERT INTO clientes (apellido,email,nombre,telefono) VALUES ("Frederick, Meredith V.","Suspendisse.eleifend@quis.com","Cameran","1-230-884-784");
INSERT INTO clientes (apellido,email,nombre,telefono) VALUES ("Hyde, Gannon H.","Aenean@arcuVestibulumut.edu","Sage","1-170-930-748");
INSERT INTO clientes (apellido,email,nombre,telefono) VALUES ("Warner, Cade C.","metus@rutrumeu.co.uk","Jaquelyn","1-707-907-465");
INSERT INTO clientes (apellido,email,nombre,telefono) VALUES ("Green, Noah I.","arcu.iaculis.enim@semmagna.net","Solomon","1-300-561-579");
INSERT INTO clientes (apellido,email,nombre,telefono) VALUES ("Stephenson, Quon L.","sed.sapien.Nunc@eleifend.org","Iola","1-259-544-920");
INSERT INTO clientes (apellido,email,nombre,telefono) VALUES ("Young, Tanner R.","Nunc@consequatdolorvitae.co.uk","Bradley","1-679-531-247");
INSERT INTO clientes (apellido,email,nombre,telefono) VALUES ("Perry, Lael S.","Quisque@velest.com","Price","1-882-484-343");
INSERT INTO clientes (apellido,email,nombre,telefono) VALUES ("Jenkins, Moses J.","nec.ante.blandit@nibhPhasellus.org","Xaviera","1-864-888-958");
INSERT INTO clientes (apellido,email,nombre,telefono) VALUES ("Watson, Hasad U.","nec.ante@cursus.com","Quynn","1-719-293-395");

/*insert servicios*/
INSERT INTO servicio (duracion,nombre,precio) VALUES (20,"Corte de Cabello",3000);
INSERT INTO servicio (duracion,nombre,precio) VALUES (20,"Perfilado de barba",3000);
INSERT INTO servicio (duracion,nombre,precio) VALUES (20,"Afeitado al ras",3000);
INSERT INTO servicio (duracion,nombre,precio) VALUES (20,"Afeitado Clásico",3000);
INSERT INTO servicio (duracion,nombre,precio) VALUES (20,"Arreglo de Barba",4000);
INSERT INTO servicio (duracion,nombre,precio) VALUES (20,"Degradado",4000);
INSERT INTO servicio (duracion,nombre,precio) VALUES (30,"Corte Clásico + Barba",7000);
INSERT INTO servicio (duracion,nombre,precio) VALUES (30,"Rasurado de Cabeza + Barba",7000);
INSERT INTO servicio (duracion,nombre,precio) VALUES (30,"Degradado + Barba",8000);
INSERT INTO servicio (duracion,nombre,precio) VALUES (0,"Gift Card",0);


/*Creamos usuarios y sus roles*/
INSERT INTO users (username, password, enabled) VALUES('secretaria', '$2a$10$HUuNeObsc5iqan95ZfmPjOB8nO51Q4TErr6o7ALlr9FbwFWY6LBpO', 1);
INSERT INTO users (username, password, enabled) VALUES('admin','$2a$10$VCpIQGDiFwthrX2HQAC.E.5Jete/BSMkNOywJFx5sbO2XvxoJ7Pdq', 1);

INSERT INTO authorities (user_id, authority) VALUES(1, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES(2, 'ROLE_ADMIN');