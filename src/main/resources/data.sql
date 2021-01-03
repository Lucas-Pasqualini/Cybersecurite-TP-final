insert into brand(id, name) values(1, 'Peugeot');
insert into brand(id, name) values(2, 'BMW');
insert into brand(id, name) values(3, 'Ferrari');
insert into brand(id, name) values(4, 'Lamborghini');
insert into brand(id, name) values(5, 'Citroën');

insert into customer(id, name) values(1,  'Lucas');
insert into customer(id, name) values(2,  'Anais');
insert into customer(id, name) values(3,  'Julien');
insert into customer(id, name) values(4,  'Arthur');
insert into customer(id, name) values(5,  'Mathis');
insert into customer(id, name) values(6,  'Tristan');
insert into customer(id, name) values(7,  'Hugo');
insert into customer(id, name) values(8,  'Corentin');
insert into customer(id, name) values(9,  'Anthony');
insert into customer(id, name) values(10, 'kader');

insert into car(id, name, brand_id, customer_id) values(1, '207',        1, 1);
insert into car(id, name, brand_id, customer_id) values(2, '206',        1, 2);
insert into car(id, name, brand_id, customer_id) values(3, 'X5',         2, 3);
insert into car(id, name, brand_id, customer_id) values(4, '720 S',      3, 4);
insert into car(id, name, brand_id, customer_id) values(5, 'Urus',       4, 5);
insert into car(id, name, brand_id, customer_id) values(6, 'Picasso',    5, 6);
insert into car(id, name, brand_id, customer_id) values(7, 'Citroën C4', 5, 7);
insert into car(id, name, brand_id, customer_id) values(8, 'Aventador',  4, 8);
insert into car(id, name, brand_id, customer_id) values(9, 'Uracan',     4, 9);
insert into car(id, name, brand_id, customer_id) values(10, '3008',      1, 10);

insert into adress(id, adress) values(1,  '120, boulevard de l''Ouest B.P. 16 59651 VILLENEUVE D''ASCQ');
insert into adress(id, adress) values(2,  '16 Rue du Haut de la Cruppe, 59650 Villeneuve-d''Ascq');
insert into adress(id, adress) values(3,  'Route de Lille, 59113 Seclin');
insert into adress(id, adress) values(4,  '2 Rue Bellini, 92800 Puteaux');
insert into adress(id, adress) values(5,  'Avenue du Pont de Bois, 59260 Lille');

insert into concessionary(id, name, adress_id) values(1, 'Peugeot PSA RETAIL VILLENEUVE D''ASCQ', 1);
insert into concessionary(id, name, adress_id) values(2, 'BMW', 2);
insert into concessionary(id, name, adress_id) values(3, 'Ferrari Lille', 3);
insert into concessionary(id, name, adress_id) values(4, 'Lamborghini Paris', 4);
insert into concessionary(id, name, adress_id) values(5, 'CITROËN PSA RETAIL HELLEMMES', 5);

insert into brand_in_concessionary(brand_id, concessionary_id) values(1,1);
insert into brand_in_concessionary(brand_id, concessionary_id) values(5,1);
