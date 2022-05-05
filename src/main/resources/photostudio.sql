INSERT INTO `photostudio`.`camera` (`name`)
VALUES ("Canon"), ("Sony"), ("Nikon");

INSERT INTO `photostudio`.`administrator` (`name`)
VALUES ("Valera"), ("Olena"), ("Nick");

INSERT INTO `photostudio`.`photographer` (`name`, `camera_id`)
VALUES ("Bob", 1), ("Alice", 2), ("John", 3);

INSERT INTO `photostudio`.`location` (`name`)
VALUES("Studio"), ("Field"), ("City");

INSERT INTO `photostudio`.`event` (`name`, `location_id`)
VALUES ("Wedding", 1), ("Family", 2), ("Portrait", 3);

INSERT INTO `photostudio`.`client` (`name`, `phone_number`, `date_of_registration`)
VALUES ("Boris", "+380950000000", "21.04.2022"), ("Joe", "+380981111111", "19.03.2022"), ("Ursula", "+380972222222", "21.01.2022");

INSERT INTO `photostudio`.`payment_type`(`name`)
VALUES ("Cash"), ("Card"), ("Crypto");

INSERT INTO `photostudio`.`billing` (`event_id`, `client_id`, `payment_type_id`)
VALUES (1, 3, 1), (3, 1, 2), (2, 2, 3);

INSERT INTO `photostudio`.`price_list` (`name`, `price`, `event_id`)
VALUES ("Standard", "500$", 1), ("Full", "900$", 1), ("Studio", "100$", 2);

INSERT INTO `photostudio`.`schedule` (`name`, `photographer_id`, `client_id`, `administrator_id`)
VALUES ("Standart", 1, 2, 3), ("Individual", 2, 3, 2), ("Specail", 3, 1, 1);

--update--
UPDATE `photostudio`.`schedule`
SET `name` = "Standard"
WHERE `id` = 1;

UPDATE `photostudio`.`billing`
SET `payment_type_id` = 1, `event_id` = 2, `client_id` = 3
WHERE `client_id` = 4;

UPDATE `photostudio`.`schedule`
SET `name` = "Special"
WHERE `id` = 3;

--order by--
SELECT * FROM photostudio.client ORDER BY date_of_registration DESC;
SELECT * FROM photostudio.client ORDER BY date_of_registration;
SELECT * FROM photostudio.client WHERE id=2;
SELECT * FROM photostudio.client WHERE name="Boris";

--inner join--
SELECT client.id AS "ID", client.name AS "Name", client.phone_number AS "Phone", client.date_of_registration AS "Registration Date"
FROM photostudio.client
LEFT JOIN photostudio.schedule
ON client.id=schedule.client_id
WHERE schedule.id IS NULL;

SELECT billing.id AS "№", payment_type.name AS "Pay", event.name AS "Event", client.name AS "Client",
client.phone_number AS "Client Phone"
FROM photostudio.billing
INNER JOIN photostudio.event
ON billing.event_id=event.id
LEFT JOIN photostudio.payment_type
ON billing.payment_type_id=payment_type.id
INNER JOIN photostudio.client
ON billing.client_id=client.id;

SELECT photographer.id, photographer.name AS "Name", camera.name AS "Camera"
FROM photostudio.photographer
INNER JOIN photostudio.camera
ON photographer.camera_id=camera.id
GROUP BY camera.name;

SELECT * FROM photostudio.photographer
WHERE photographer.camera_id BETWEEN 2 AND 3;

--delete--
DELETE FROM `photostudio`.`photographer`
WHERE camera_id=2;

DELETE FROM `photostudio`.`event`
WHERE name="Family";

DELETE FROM photostudio.administrator
WHERE administrator.name="Nick";
