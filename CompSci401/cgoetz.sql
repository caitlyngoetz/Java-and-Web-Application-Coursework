DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS galleries; 
DROP TABLE IF EXISTS comment;

CREATE TABLE users(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,  
	password VARCHAR (50) NOT NULL UNIQUE, 
	first_name VARCHAR (50) NOT NULL, 
	last_name VARCHAR (50) NOT NULL, 
	email VARCHAR (100) NOT NULL);

CREATE TABLE galleries(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	gallery VARCHAR (50) NOT NULL,
	address VARCHAR (50) NOT NULL UNIQUE);

CREATE TABLE comment(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	created TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	comment VARCHAR(255) NOT NULL
	);

INSERT INTO users (password, first_name, last_name, email) VALUES ('mywebsite', 'Cheyenne', 'Goetz', 'goetzcheyenne@gmail.com');

INSERT INTO users (password, first_name, last_name, email) VALUES ('project', 'Caitlyn', 'Goetz', 'this@that.com');

INSERT INTO users (password, first_name, last_name, email) VALUES ('mychildren', 'Carolyn', 'Goetz', 'jandcgoetz@gmail.com');

INSERT INTO users (password, first_name, last_name, email) VALUES ('mystudent', 'Marissa', 'Schmidt', 'marissaschmidt@boisestate.edu');

INSERT INTO galleries (gallery, address) VALUES ('color', 'images/color/1.jpg');
INSERT INTO galleries (gallery, address) VALUES ('color', 'images/color/2.jpg');
INSERT INTO galleries (gallery, address) VALUES ('color', 'images/color/3.jpg');
INSERT INTO galleries (gallery, address) VALUES ('color', 'images/color/4.jpg');
INSERT INTO galleries (gallery, address) VALUES ('color', 'images/color/5.jpg');
INSERT INTO galleries (gallery, address) VALUES ('color', 'images/color/design1.jpg');
INSERT INTO galleries (gallery, address) VALUES ('color', 'images/color/design2.jpg');
INSERT INTO galleries (gallery, address) VALUES ('color', 'images/color/moon.jpg');
INSERT INTO galleries (gallery, address) VALUES ('color', 'images/color/rain.jpg');
INSERT INTO galleries (gallery, address) VALUES ('color', 'images/color/waterfall1.jpg');
INSERT INTO galleries (gallery, address) VALUES ('color', 'images/color/waterfall2.jpg');
INSERT INTO galleries (gallery, address) VALUES ('color', 'images/color/waterfall3.jpg');

INSERT INTO galleries (gallery, address) VALUES ('flowers', 'images/Flowers/1.jpg');
INSERT INTO galleries (gallery, address) VALUES ('flowers', 'images/Flowers/2.jpg');
INSERT INTO galleries (gallery, address) VALUES ('flowers', 'images/Flowers/3.jpg');
INSERT INTO galleries (gallery, address) VALUES ('flowers', 'images/Flowers/bluelakeflowers.jpg');
INSERT INTO galleries (gallery, address) VALUES ('flowers', 'images/Flowers/flower.jpg');
INSERT INTO galleries (gallery, address) VALUES ('flowers', 'images/Flowers/leaf.jpg');
INSERT INTO galleries (gallery, address) VALUES ('flowers', 'images/Flowers/purple1.jpg');
INSERT INTO galleries (gallery, address) VALUES ('flowers', 'images/Flowers/purple2.jpg');
INSERT INTO galleries (gallery, address) VALUES ('flowers', 'images/Flowers/rock.jpg');
INSERT INTO galleries (gallery, address) VALUES ('flowers', 'images/Flowers/rose.jpg');
INSERT INTO galleries (gallery, address) VALUES ('flowers', 'images/Flowers/spiderweb&rose.jpg');

INSERT INTO galleries (gallery, address) VALUES ('landscapes', 'images/landscapes/fallpond.jpg');
INSERT INTO galleries (gallery, address) VALUES ('landscapes', 'images/landscapes/GoatLake2.jpg');
INSERT INTO galleries (gallery, address) VALUES ('landscapes', 'images/landscapes/GoatLakeFilter.jpg');
INSERT INTO galleries (gallery, address) VALUES ('landscapes', 'images/landscapes/GoatLakeMorning.jpg');
INSERT INTO galleries (gallery, address) VALUES ('landscapes', 'images/landscapes/GoatLakeMorning2.jpg');
INSERT INTO galleries (gallery, address) VALUES ('landscapes', 'images/landscapes/steckHDR1.jpg');

INSERT INTO galleries (gallery, address) VALUES ('nighttime', 'images/Nighttime/blue.jpg');
INSERT INTO galleries (gallery, address) VALUES ('nighttime', 'images/Nighttime/BlueLakeCamp.jpg');
INSERT INTO galleries (gallery, address) VALUES ('nighttime', 'images/Nighttime/BlueLakeStarTrails.jpg');
INSERT INTO galleries (gallery, address) VALUES ('nighttime', 'images/Nighttime/finished.jpg');
INSERT INTO galleries (gallery, address) VALUES ('nighttime', 'images/Nighttime/GoatLakeTent2.jpg');
INSERT INTO galleries (gallery, address) VALUES ('nighttime', 'images/Nighttime/milkyway.jpg');
INSERT INTO galleries (gallery, address) VALUES ('nighttime', 'images/Nighttime/2.jpg');
INSERT INTO galleries (gallery, address) VALUES ('nighttime', 'images/Nighttime/nightcabin.jpg');
INSERT INTO galleries (gallery, address) VALUES ('nighttime', 'images/Nighttime/nighttent.jpg');
INSERT INTO galleries (gallery, address) VALUES ('nighttime', 'images/Nighttime/observatory.jpg');
INSERT INTO galleries (gallery, address) VALUES ('nighttime', 'images/Nighttime/stars.jpg');
INSERT INTO galleries (gallery, address) VALUES ('nighttime', 'images/Nighttime/treestars.jpg');
INSERT INTO galleries (gallery, address) VALUES ('nighttime', 'images/Nighttime/wires.jpg');

INSERT INTO galleries (gallery, address) VALUES ('random', 'images/random/agate.jpg');
INSERT INTO galleries (gallery, address) VALUES ('random', 'images/random/boat.jpg');
INSERT INTO galleries (gallery, address) VALUES ('random', 'images/random/cat.jpg');
INSERT INTO galleries (gallery, address) VALUES ('random', 'images/random/cat2.jpg');
INSERT INTO galleries (gallery, address) VALUES ('random', 'images/random/drop1.jpg');
INSERT INTO galleries (gallery, address) VALUES ('random', 'images/random/drop3.jpg');
INSERT INTO galleries (gallery, address) VALUES ('random', 'images/random/eggs.jpg');
INSERT INTO galleries (gallery, address) VALUES ('random', 'images/random/king.jpg');
INSERT INTO galleries (gallery, address) VALUES ('random', 'images/random/lightbulb.jpg');
INSERT INTO galleries (gallery, address) VALUES ('random', 'images/random/snail.jpg');
INSERT INTO galleries (gallery, address) VALUES ('random', 'images/random/walking.jpg');
INSERT INTO galleries (gallery, address) VALUES ('random', 'images/random/waterleaf.jpg');
INSERT INTO galleries (gallery, address) VALUES ('random', 'images/random/woodpile.jpg');

INSERT INTO galleries (gallery, address) VALUES ('sunsets', 'images/sunsets/cabin.jpg');
INSERT INTO galleries (gallery, address) VALUES ('sunsets', 'images/sunsets/city.jpg');
INSERT INTO galleries (gallery, address) VALUES ('sunsets', 'images/sunsets/GoatLakeSunset.jpg');
INSERT INTO galleries (gallery, address) VALUES ('sunsets', 'images/sunsets/stack.jpg');
INSERT INTO galleries (gallery, address) VALUES ('sunsets', 'images/sunsets/sunset2.jpg');

INSERT INTO galleries (gallery, address) VALUES ('waterfalls', 'images/waterfalls/archcape.jpg');
INSERT INTO galleries (gallery, address) VALUES ('waterfalls', 'images/waterfalls/bluelakewaterfall3.jpg');
INSERT INTO galleries (gallery, address) VALUES ('waterfalls', 'images/waterfalls/creek.jpg');
INSERT INTO galleries (gallery, address) VALUES ('waterfalls', 'images/waterfalls/creek2.jpg');
INSERT INTO galleries (gallery, address) VALUES ('waterfalls', 'images/waterfalls/falls.jpg');
INSERT INTO galleries (gallery, address) VALUES ('waterfalls', 'images/waterfalls/LickCreekFalls9.jpg');
INSERT INTO galleries (gallery, address) VALUES ('waterfalls', 'images/waterfalls/multenoma.jpg');
INSERT INTO galleries (gallery, address) VALUES ('waterfalls', 'images/waterfalls/munsonfallscreek2.jpg');
INSERT INTO galleries (gallery, address) VALUES ('waterfalls', 'images/waterfalls/OneontaFalls.jpg');
INSERT INTO galleries (gallery, address) VALUES ('waterfalls', 'images/waterfalls/OneontaGorge.jpg');
INSERT INTO galleries (gallery, address) VALUES ('waterfalls', 'images/waterfalls/thor.jpg');
