insert into brand(id, name) values(0, 'Peugeot');
insert into brand(id, name) values(1, 'BMW');
insert into brand(id, name) values(2, 'Ferrari');
insert into brand(id, name) values(3, 'Lamborghini');
insert into brand(id, name) values(4, 'Citroën');

insert into customer(id, name) values(0,  'Lucas');
insert into customer(id, name) values(1,  'Anais');
insert into customer(id, name) values(2,  'Julien');
insert into customer(id, name) values(3,  'Arthur');
insert into customer(id, name) values(4,  'Mathis');
insert into customer(id, name) values(5,  'Tristan');
insert into customer(id, name) values(6,  'Hugo');
insert into customer(id, name) values(7,  'Corentin');
insert into customer(id, name) values(8,  'Anthony');
insert into customer(id, name) values(9, 'kader');

insert into car(id, name, brand_id, customer_id) values(1, '207',        0, 0);
insert into car(id, name, brand_id, customer_id) values(2, '206',        0, 1);
insert into car(id, name, brand_id, customer_id) values(3, 'X5',         1, 2);
insert into car(id, name, brand_id, customer_id) values(4, '720 S',      2, 3);
insert into car(id, name, brand_id, customer_id) values(5, 'Urus',       3, 4);
insert into car(id, name, brand_id, customer_id) values(6, 'Picasso',    4, 5);
insert into car(id, name, brand_id, customer_id) values(7, 'Citroën C4', 4, 6);
insert into car(id, name, brand_id, customer_id) values(8, 'Aventador',  3, 7);
insert into car(id, name, brand_id, customer_id) values(9, 'Uracan',     3, 8);
insert into car(id, name, brand_id, customer_id) values(10, '3008',      0, 9);

insert into adress(id, adress) values(0,  '120, boulevard de l''Ouest B.P. 16 59651 VILLENEUVE D''ASCQ');
insert into adress(id, adress) values(1,  '16 Rue du Haut de la Cruppe, 59650 Villeneuve-d''Ascq');
insert into adress(id, adress) values(2,  'Route de Lille, 59113 Seclin');
insert into adress(id, adress) values(3,  '2 Rue Bellini, 92800 Puteaux');
insert into adress(id, adress) values(4,  'Avenue du Pont de Bois, 59260 Lille');

insert into concessionary(id, name, adress_id) values(0, 'Peugeot PSA RETAIL VILLENEUVE D''ASCQ', 0);
insert into concessionary(id, name, adress_id) values(1, 'BMW', 1);
insert into concessionary(id, name, adress_id) values(2, 'Ferrari Lille', 2);
insert into concessionary(id, name, adress_id) values(3, 'Lamborghini Paris', 3);
insert into concessionary(id, name, adress_id) values(4, 'CITROËN PSA RETAIL HELLEMMES', 4);

insert into brand_in_concessionary(brand_id, concessionary_id) values(0,0);
insert into brand_in_concessionary(brand_id, concessionary_id) values(4,0);
