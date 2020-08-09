DROP DATABASE IF EXISTS tacocloud;
CREATE DATABASE IF NOT EXISTS tacocloud;
Use tacocloud;

create table if not exists Ingredient (
	id varchar(4) primary key,
	name varchar(25) not null,
	type varchar(10) not null
);

create table if not exists Taco (
	id int primary key,
	name varchar(50) not null,
	createdAt timestamp not null
); 

create table if not exists Taco_Ingredients (
	taco int not null,
	ingredient varchar(4) not null,
    primary key(taco, ingredient),
	foreign key (taco) references Taco(id),
	foreign key (ingredient) references Ingredient(id)
);

create table if not exists Taco_Order (
	id int primary key,
	deliveryName varchar(50) not null,
	deliveryStreet varchar(50) not null,
	deliveryCity varchar(50) not null,
	deliveryState varchar(2) not null,
	deliveryZip varchar(10) not null,
	ccNumber varchar(16) not null,
	ccExpiration varchar(5) not null,
	ccCVV varchar(3) not null,
	placedAt timestamp not null
);

create table if not exists Taco_Order_Tacos (
	tacoOrder int not null,
	taco int not null,
    primary key(tacoOrder,taco),
    foreign key (tacoOrder) references Taco_Order(id),
    foreign key (taco) references Taco(id)
);


insert into Ingredient (id, name, type)
values ('FLTO', 'Flour Tortilla', 'WRAP');
insert into Ingredient (id, name, type)
values ('COTO', 'Corn Tortilla', 'WRAP');
insert into Ingredient (id, name, type)
values ('GRBF', 'Ground Beef', 'PROTEIN');
insert into Ingredient (id, name, type)
values ('CARN', 'Carnitas', 'PROTEIN');
insert into Ingredient (id, name, type)
values ('TMTO', 'Diced Tomatoes', 'VEGGIES');
insert into Ingredient (id, name, type)
values ('LETC', 'Lettuce', 'VEGGIES');
insert into Ingredient (id, name, type)
values ('CHED', 'Cheddar', 'CHEESE');
insert into Ingredient (id, name, type)
values ('JACK', 'Monterrey Jack', 'CHEESE');
insert into Ingredient (id, name, type)
values ('SLSA', 'Salsa', 'SAUCE');
insert into Ingredient (id, name, type)
values ('SRCR', 'Sour Cream', 'SAUCE'); 










